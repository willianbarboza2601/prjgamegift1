package br.edu.utfpr.pb.prjgamegift1.server.mapper;

import br.edu.utfpr.pb.prjgamegift1.server.dto.OrderRequestDTO;
import br.edu.utfpr.pb.prjgamegift1.server.dto.OrderResponseDTO;
import br.edu.utfpr.pb.prjgamegift1.server.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    @Mapping(source = "address.id", target = "addressId")
    @Mapping(target = "items", ignore = true)
    @Mapping(target = "totalPrice", ignore = true)
    OrderResponseDTO toDto(Order entity);

    Order toEntity(OrderResponseDTO dto);
}
