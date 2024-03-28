package br.com.fiapfood.production.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ItemOrder {

    private Product product;

    private Integer quantity;
}
