package br.edu.utfpr.pb.prjgamegift1.server.mapper;

import br.edu.utfpr.pb.prjgamegift1.server.dto.CategoryDTO;
import br.edu.utfpr.pb.prjgamegift1.server.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    CategoryDTO toDTO(Category entity);

    Category toEntity(CategoryDTO dto);
}
