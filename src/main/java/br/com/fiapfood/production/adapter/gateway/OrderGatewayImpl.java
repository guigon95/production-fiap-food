package br.com.fiapfood.production.adapter.gateway;

import br.com.fiapfood.production.domain.model.Order;
import br.com.fiapfood.production.external.gateway.OrderGateway;
import br.com.fiapfood.production.infrastructure.entity.OrderEntity;
import br.com.fiapfood.production.infrastructure.repository.JPA.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class OrderGatewayImpl implements OrderGateway {

    private final OrderJpaRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderEntity -> new Order(orderEntity.getId(), null, orderEntity.getOrderStatus(), orderEntity.getClient(), orderEntity.getCreatedAt())).toList();
    }

    @Override
    public Order findById(String id) {

        Optional<OrderEntity> optional = orderRepository.findById(id);

        return optional.map(orderEntity -> new Order(orderEntity.getId(), null, orderEntity.getOrderStatus(), orderEntity.getClient(), orderEntity.getCreatedAt()))
                .orElse(null);

    }


    @Override
    public Order save(Order order) {
        var orderEntity = new OrderEntity(order.getId(), order.getOrderStatus(), order.getClient(), order.getCreatedAt());
        OrderEntity orderEntitySaved = orderRepository.save(orderEntity);
        Order orderSaved = new Order(orderEntitySaved.getId(), null, orderEntitySaved.getOrderStatus(), orderEntitySaved.getClient(), orderEntitySaved.getCreatedAt());
        return orderSaved;
    }
}
