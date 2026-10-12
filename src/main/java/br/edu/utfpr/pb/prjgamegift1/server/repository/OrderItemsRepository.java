package br.edu.utfpr.pb.prjgamegift1.server.repository;

import br.edu.utfpr.pb.prjgamegift1.server.model.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
    List<OrderItems> findOrderItemsByOrderId(Long id);
}
