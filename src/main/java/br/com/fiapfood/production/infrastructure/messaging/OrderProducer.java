package br.com.fiapfood.production.infrastructure.messaging;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderProducer {

    @Value("${aws.orderQueueName}")
    private String queueName;

    private final AmazonSQS amazonSQSClient;

    public void publishMessage(String orderId) {
        log.info("Publish message "+ orderId);
        try {
            GetQueueUrlResult queueUrl = amazonSQSClient.getQueueUrl(queueName);
            var message = orderId;
            var result = amazonSQSClient.sendMessage(queueUrl.getQueueUrl(), message);
        } catch (Exception e) {
            log.error("Queue Exception Message: {}", e.getMessage());
        }

    }
}
