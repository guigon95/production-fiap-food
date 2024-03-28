package br.com.fiapfood.production.adapter.dto.request;

import java.util.List;

public record OrderRequest(Long id, List<ItemOrderRequest> itemOrderRequest) {
}
