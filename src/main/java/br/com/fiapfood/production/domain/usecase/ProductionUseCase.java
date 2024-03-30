package br.com.fiapfood.production.domain.usecase;

public interface ProductionUseCase {

    public void publishMessage(String message);
    public void updateStatus(String orderId);

    String findOrder(Long id, String token);
}
