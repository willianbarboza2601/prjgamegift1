package br.edu.utfpr.pb.prjgamegift1.server.service;

import br.edu.utfpr.pb.prjgamegift1.server.dto.OrderItemRequestDTO;
import br.edu.utfpr.pb.prjgamegift1.server.model.Order;
import br.edu.utfpr.pb.prjgamegift1.server.model.OrderItems;

import java.math.BigDecimal;
import java.util.List;

public interface IOrderItemService {
    void saveItems(Order order, List<OrderItemRequestDTO> items);
    List<OrderItems> findByOrderId(Long id);
}
