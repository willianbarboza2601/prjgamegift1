package br.edu.utfpr.pb.prjgamegift1.server.mapper;

import br.edu.utfpr.pb.prjgamegift1.server.dto.AddressDTO;
import br.edu.utfpr.pb.prjgamegift1.server.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AddressMapper {
    AddressDTO toDto(Address entity);

    Address toEntity(AddressDTO dto);
}
