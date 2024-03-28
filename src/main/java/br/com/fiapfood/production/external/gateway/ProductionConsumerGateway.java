package br.com.fiapfood.production.external.gateway;


import br.com.fiapfood.production.adapter.dto.messaging.OrderMessageDto;

public interface ProductionConsumerGateway {
    public OrderMessageDto consumeMessages();
}
