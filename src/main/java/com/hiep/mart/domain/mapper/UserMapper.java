package com.hiep.mart.domain.mapper;

import com.hiep.mart.domain.dto.UserDTO;
import com.hiep.mart.domain.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toUsers(UserDTO userDTO);
    UserDTO toUserDTO(Users users);
    void updateUsers(@MappingTarget Users users,  UserDTO userDTO);
}
