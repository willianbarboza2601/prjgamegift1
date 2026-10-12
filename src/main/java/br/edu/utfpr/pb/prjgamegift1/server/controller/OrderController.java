package br.edu.utfpr.pb.prjgamegift1.server.controller;

import br.edu.utfpr.pb.prjgamegift1.server.dto.OrderRequestDTO;
import br.edu.utfpr.pb.prjgamegift1.server.dto.OrderResponseDTO;
import br.edu.utfpr.pb.prjgamegift1.server.mapper.OrderItemMapper;
import br.edu.utfpr.pb.prjgamegift1.server.mapper.OrderMapper;
import br.edu.utfpr.pb.prjgamegift1.server.model.Order;
import br.edu.utfpr.pb.prjgamegift1.server.model.OrderItems;
import br.edu.utfpr.pb.prjgamegift1.server.service.IOrderItemService;
import br.edu.utfpr.pb.prjgamegift1.server.service.IOrderService;
import br.edu.utfpr.pb.prjgamegift1.server.service.impl.OrderItemsServiceImpl;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orders")
@RestController
public class OrderController {
    private final IOrderService orderService;
    private final IOrderItemService orderItemService;
    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;

    public OrderController(IOrderService orderService,
                           OrderMapper orderMapper,
                           OrderItemMapper orderItemMapper,
                           IOrderItemService orderItemService){
        this.orderService = orderService;
        this.orderItemService = orderItemService;
        this.orderMapper = orderMapper;
        this.orderItemMapper = orderItemMapper;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> save(@RequestBody @Valid OrderRequestDTO orderDTO,
                                                 Authentication authentication){
        String email = authentication.getName();

        Order savedOrder = orderService.save(
                email,
                orderDTO.getAddressId(),
                orderDTO.getOrderItems()
        );

        OrderResponseDTO response = toResponseDTO(savedOrder);

        List<OrderItems> items = orderItemService
                .findByOrderId(savedOrder.getId());

        response.setItems(orderItemMapper.toDTO(items));

        response.setTotalPrice(
                orderService.calculateTotalPrice(savedOrder.getId())
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    //MÉTODO AUXILIAR PARA RETORNAR O PREÇO TOTAL E OS ITENS DOS PEDIDOS
    private OrderResponseDTO toResponseDTO(Order order) {

        OrderResponseDTO response = orderMapper.toDto(order);

        List<OrderItems> items = orderItemService.findByOrderId(order.getId());

        response.setItems(orderItemMapper.toDTO(items));

        response.setTotalPrice(
                orderService.calculateTotalPrice(order.getId())
        );

        return response;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> findAll(
            Authentication authentication) {

        String email = authentication.getName();

        List<Order> orders = orderService.findAllByUserEmail(email);

        List<OrderResponseDTO> response = orders.stream()
                .map(this::toResponseDTO)
                .toList();

        return ResponseEntity.ok(response);
    }


}
