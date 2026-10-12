package br.edu.utfpr.pb.prjgamegift1.server.service.impl;

import br.edu.utfpr.pb.prjgamegift1.server.dto.OrderItemRequestDTO;
import br.edu.utfpr.pb.prjgamegift1.server.dto.OrderResponseDTO;
import br.edu.utfpr.pb.prjgamegift1.server.model.*;
import br.edu.utfpr.pb.prjgamegift1.server.repository.*;
import br.edu.utfpr.pb.prjgamegift1.server.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final OrderItemsServiceImpl orderItemsService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            UserRepository userRepository,
                            AddressRepository addressRepository,
                            OrderItemsServiceImpl orderItemsService) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.orderItemsService = orderItemsService;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAll(){
        return this.orderRepository.findAll();
    }

    @Override
    @Transactional
    public Order save(String email, Long addressId, List<OrderItemRequestDTO> items){
        User user = userRepository.findByEmail(email);

        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        if(!address.getUser().getId().equals(user.getId())){
            throw new IllegalArgumentException("O endereço não pertence ao usuario autenticado");
        }

        Order order = new Order();

        order.setUser(user);
        order.setAddress(address);
        order.setDate(LocalDateTime.now());

        Order savedOrder = orderRepository.save(order);

        orderItemsService.saveItems(savedOrder, items);

        return savedOrder;
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal calculateTotalPrice(Long orderId) {

        List<OrderItems> items = orderItemsService.findByOrderId(orderId);

        return items.stream()
                .map(item -> item.getPrice().multiply(
                        BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public List<Order> findAllByUserEmail(String email){
        return this.orderRepository.findAllByUserEmail(email);
    }

}
