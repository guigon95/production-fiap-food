package br.com.fiapfood.production.adapter.gateway;

import br.com.fiapfood.production.external.gateway.PaymentConsumerGateway;
import br.com.fiapfood.production.infrastructure.messaging.PaymentConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentConsumerGatewayImpl implements PaymentConsumerGateway {

    private final PaymentConsumer paymentConsumer;
    @Override
    public String consumeMessages() {
        return paymentConsumer.consumeMessages();
    }
}
