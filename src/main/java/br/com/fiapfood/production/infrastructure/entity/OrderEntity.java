package br.com.fiapfood.production.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT")
    private Long id;

    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    //private List<ItemOrderEntity> itemOrder;

    private String orderStatus;

    @Column(name = "client_id")
    private String client;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
