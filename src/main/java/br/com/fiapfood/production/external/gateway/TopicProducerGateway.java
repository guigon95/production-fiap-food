package br.com.fiapfood.production.external.gateway;

public interface TopicProducerGateway {

    public void publishMessage(String id);
}
