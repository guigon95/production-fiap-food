package br.com.fiapfood.production.external.gateway;

public interface OrderProducerGateway {
    public void publishMessage(String orderId);
}
