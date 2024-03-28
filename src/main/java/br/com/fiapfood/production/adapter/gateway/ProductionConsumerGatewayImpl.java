package br.com.fiapfood.production.adapter.gateway;

import br.com.fiapfood.production.adapter.dto.messaging.OrderMessageDto;
import br.com.fiapfood.production.external.gateway.ProductionConsumerGateway;
import br.com.fiapfood.production.infrastructure.messaging.ProductionConsumer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductionConsumerGatewayImpl implements ProductionConsumerGateway {

    private final ProductionConsumer orderConsumer;

    private final ObjectMapper objectMapper;

    @Override
    public OrderMessageDto consumeMessages() {

        String message = orderConsumer.consumeMessages();
        OrderMessageDto orderMessageDTO = null;

        if(message == null)
            return null;

        try {
            orderMessageDTO = objectMapper.readValue(message, OrderMessageDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return orderMessageDTO;
    }
}
