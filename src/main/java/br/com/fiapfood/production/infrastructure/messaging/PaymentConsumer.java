package br.com.fiapfood.production.infrastructure.messaging;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class PaymentConsumer {

    //https://medium.com/@mertcakmak2/aws-standard-sqs-queue-with-spring-boot-974c163e0616
    
    @Value("${aws.queueName}")
    private String queueName;

    private final AmazonSQS amazonSQSClient;

    public String consumeMessages() {
        try {
            String queueUrl = amazonSQSClient.getQueueUrl(queueName).getQueueUrl();

            ReceiveMessageResult receiveMessageResult = amazonSQSClient.receiveMessage(queueUrl);

            if (!receiveMessageResult.getMessages().isEmpty()) {
                Message message = receiveMessageResult.getMessages().get(0);
                log.info("Read Message from queue: {}", message.getBody());
                amazonSQSClient.deleteMessage(queueUrl, message.getReceiptHandle());
                return message.getBody();
            }

        } catch (Exception e) {
            log.error("Queue Exception Message: {}", e.getMessage());
            throw new RuntimeException();
        }

        log.info("retornando null");
        return null;
    }
}
