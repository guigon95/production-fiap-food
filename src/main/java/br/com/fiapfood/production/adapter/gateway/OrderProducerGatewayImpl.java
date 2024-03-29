package br.com.fiapfood.production.adapter.gateway;

import br.com.fiapfood.production.external.gateway.OrderProducerGateway;
import br.com.fiapfood.production.external.gateway.TopicProducerGateway;
import br.com.fiapfood.production.infrastructure.messaging.OrderProducer;
import br.com.fiapfood.production.infrastructure.messaging.TopicProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderProducerGatewayImpl implements OrderProducerGateway {

    private final OrderProducer orderProducer;

    @Override
    public void publishMessage(String orderId) {
        orderProducer.publishMessage(orderId);
    }
}
