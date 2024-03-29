package br.com.fiapfood.production.infrastructure.repository.JPA;

import br.com.fiapfood.production.infrastructure.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, String> {

}
