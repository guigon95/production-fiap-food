package br.com.fiapfood.production.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@AllArgsConstructor
@Builder
@Data
public class Product {
    private String name;
    private String category;
    private String description;
    private BigDecimal price;
    private String images;
    private String status;
}
