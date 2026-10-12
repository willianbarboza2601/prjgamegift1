package br.edu.utfpr.pb.prjgamegift1.server.mapper;

import br.edu.utfpr.pb.prjgamegift1.server.dto.UserDTO;
import br.edu.utfpr.pb.prjgamegift1.server.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper{
    UserDTO toDto(User entity);

    User toEntity(UserDTO dto);
}
