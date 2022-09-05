package com.micro.sample.project.mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.micro.sample.project.commands.CreateUserCmd;
import com.micro.sample.project.dto.UserDto;
import com.micro.sample.project.model.User;
import com.micro.sample.project.service.impl.UserService;

@Mapper
public interface UserMapping {

    UserMapping USER_MAPPING = Mappers.getMapper(UserMapping.class);

    UserDto convertUserDoToDto(User user);

    User createCmdToUser(CreateUserCmd cmd);
}
