package br.com.fiapfood.production.domain.usecase;

import br.com.fiapfood.production.domain.model.Order;

public interface ProductionUseCase {

    public void publishMessage(String message);
    public void updateStatus(String orderId);
}
