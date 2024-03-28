package br.com.fiapfood.production.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class Order {

    private Long id;

    private List<ItemOrder> itemOrder;

    private String orderStatus;

    private String client;

    private LocalDateTime createdAt;

}
