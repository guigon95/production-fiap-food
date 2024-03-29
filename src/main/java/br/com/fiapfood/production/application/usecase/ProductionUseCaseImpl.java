package br.com.fiapfood.production.application.usecase;

import br.com.fiapfood.production.adapter.dto.messaging.OrderMessageDto;
import br.com.fiapfood.production.domain.model.ItemOrder;
import br.com.fiapfood.production.domain.model.Order;
import br.com.fiapfood.production.domain.model.Product;
import br.com.fiapfood.production.domain.usecase.ProductionUseCase;
import br.com.fiapfood.production.external.gateway.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProductionUseCaseImpl implements ProductionUseCase {

    private final TopicProducerGateway topicProducerGateway;
    private final PaymentConsumerGateway paymentConsumerGateway;
    private final OrderProducerGateway orderProducerGateway;
    private final ProductionConsumerGateway productionConsumerGateway;
    private final OrderGateway orderGateway;

    @Override
    public void publishMessage(String message) {
        topicProducerGateway.publishMessage(message);
    }

    @Override
    public void updateStatus(String orderId) {
        orderProducerGateway.publishMessage(orderId);
    }

    @Scheduled(fixedDelay = 15000)
    public void consumePaymentMessages() {
        String orderId = paymentConsumerGateway.consumeMessages();

        if (orderId == null) return;

        orderProducerGateway.publishMessage(orderId);
    }

    @Scheduled(fixedDelay = 15000)
    public void consumeProductionMessages() {
        OrderMessageDto orderMessageDTO = productionConsumerGateway.consumeMessages();

        if (orderMessageDTO == null) return;

        log.info("Salvando order" + orderMessageDTO.toString());

        List<ItemOrder> itemOrderList = getItemOrderList(orderMessageDTO);

        Order order = Order.builder().id(orderMessageDTO.getId())
                .orderStatus(orderMessageDTO.getOrderStatus())
                .itemOrder(itemOrderList)
                .client(orderMessageDTO.getClient())
                .createdAt(orderMessageDTO.getCreatedAt())
                .build();

        orderGateway.save(order);

    }

    private static List<ItemOrder> getItemOrderList(OrderMessageDto orderMessageDTO) {
        return orderMessageDTO.getItemOrder().stream().map(itemOrderMessageDto -> new ItemOrder(new Product(itemOrderMessageDto.getProduct().name,
                itemOrderMessageDto.getProduct().description,
                itemOrderMessageDto.getProduct().category,
                itemOrderMessageDto.getProduct().price,
                itemOrderMessageDto.getProduct().images,
                itemOrderMessageDto.getProduct().status),
                itemOrderMessageDto.getQuantity())).toList();
    }
}
