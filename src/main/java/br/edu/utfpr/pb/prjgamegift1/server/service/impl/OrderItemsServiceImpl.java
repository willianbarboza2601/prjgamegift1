package br.edu.utfpr.pb.prjgamegift1.server.service.impl;

import br.edu.utfpr.pb.prjgamegift1.server.dto.OrderItemRequestDTO;
import br.edu.utfpr.pb.prjgamegift1.server.model.Order;
import br.edu.utfpr.pb.prjgamegift1.server.model.OrderItems;
import br.edu.utfpr.pb.prjgamegift1.server.model.Product;
import br.edu.utfpr.pb.prjgamegift1.server.repository.OrderItemsRepository;
import br.edu.utfpr.pb.prjgamegift1.server.repository.ProductRepository;
import br.edu.utfpr.pb.prjgamegift1.server.service.IOrderItemService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsServiceImpl implements IOrderItemService {
    private final OrderItemsRepository orderItemsRepository;
    private final ProductRepository productRepository;

    public OrderItemsServiceImpl(OrderItemsRepository orderItemsRepository,
                                 ProductRepository productRepository){
        this.orderItemsRepository = orderItemsRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void saveItems(Order order,
                          List<OrderItemRequestDTO> items) {

        for (OrderItemRequestDTO itemDTO : items) {

            Product product = productRepository
                    .findById(itemDTO.getProductId())
                    .orElseThrow(() ->
                            new RuntimeException("Produto não encontrado"));

            OrderItems orderItem = new OrderItems();

            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setPrice(product.getPrice());
            orderItem.setQuantity(itemDTO.getQuantity());

            orderItemsRepository.save(orderItem);
        }
    }

    @Override
    @Transactional
    public List<OrderItems> findByOrderId(Long id){
        return this.orderItemsRepository.findOrderItemsByOrderId(id);
    }
}
