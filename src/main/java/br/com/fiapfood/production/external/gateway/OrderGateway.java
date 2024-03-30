package br.com.fiapfood.production.external.gateway;

import br.com.fiapfood.production.domain.model.Order;

import java.util.List;

public interface OrderGateway {
    List<Order> findAll();

    String findById(Long id, String token);

    Order save(Order order);
}
