package br.com.fiapfood.production.adapter.dto.messaging;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
public class OrderMessageDto {

    private Long id;

    private List<ItemOrderMessageDto> itemOrder;

    private String orderStatus;

    private String client;

    private LocalDateTime createdAt;

}
