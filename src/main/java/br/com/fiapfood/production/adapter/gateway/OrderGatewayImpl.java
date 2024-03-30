package br.com.fiapfood.production.adapter.gateway;

import br.com.fiapfood.production.domain.model.Order;
import br.com.fiapfood.production.external.gateway.OrderGateway;
import br.com.fiapfood.production.infrastructure.client.OrderClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class OrderGatewayImpl implements OrderGateway {

    private final OrderClient orderClient;

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public String findById(Long id, String token) {

        return orderClient.getOrderById(id, token);
    }


    @Override
    public Order save(Order order) {

       return null;
    }
}
