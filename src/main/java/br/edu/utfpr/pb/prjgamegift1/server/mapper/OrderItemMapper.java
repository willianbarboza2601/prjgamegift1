package br.edu.utfpr.pb.prjgamegift1.server.mapper;

import br.edu.utfpr.pb.prjgamegift1.server.dto.OrderItemResponseDTO;
import br.edu.utfpr.pb.prjgamegift1.server.model.OrderItems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemMapper {
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    OrderItemResponseDTO toDTO(OrderItems entity);

    List<OrderItemResponseDTO> toDTO(List<OrderItems> entities);
}
