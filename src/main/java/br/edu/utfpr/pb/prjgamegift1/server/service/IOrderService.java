package br.edu.utfpr.pb.prjgamegift1.server.service;

import br.edu.utfpr.pb.prjgamegift1.server.dto.OrderItemRequestDTO;
import br.edu.utfpr.pb.prjgamegift1.server.dto.OrderResponseDTO;
import br.edu.utfpr.pb.prjgamegift1.server.model.Order;

import java.math.BigDecimal;
import java.util.List;

public interface IOrderService {
    List<Order> findAll();
    Order save(String email, Long addressId, List<OrderItemRequestDTO> items);
    BigDecimal calculateTotalPrice(Long orderId);
    List<Order> findAllByUserEmail(String email);
}
