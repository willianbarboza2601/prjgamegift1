package br.edu.utfpr.pb.prjgamegift1.server.repository;

import br.edu.utfpr.pb.prjgamegift1.server.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUserEmail(String email);
}
