package br.com.fiapfood.production.adapter.dto.request;

public record ItemOrderRequest(ProductRequest productRequest, Integer quantity) {
}
