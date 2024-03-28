package br.com.fiapfood.production.adapter.gateway;

import br.com.fiapfood.production.external.gateway.TopicProducerGateway;
import br.com.fiapfood.production.infrastructure.messaging.TopicProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TopicProducerGatewayImpl implements TopicProducerGateway {

    private final TopicProducer topicProducer;

    @Override
    public void publishMessage(String orderId) {
        topicProducer.publishMessage(orderId);
    }
}
