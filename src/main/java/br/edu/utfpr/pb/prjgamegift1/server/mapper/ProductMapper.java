package br.edu.utfpr.pb.prjgamegift1.server.mapper;

import br.edu.utfpr.pb.prjgamegift1.server.dto.ProductDTO;
import br.edu.utfpr.pb.prjgamegift1.server.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    ProductDTO toDto(Product entity);

    Product toEntity(ProductDTO dto);
}
