package br.com.fiapfood.production.adapter.dto.request;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductRequest(UUID id,
                             String name,
                             Category category,
                             String description,
                             BigDecimal price,
                             String images,
                             Status status) {
}
