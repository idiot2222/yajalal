package me.bogeun.mapper;

import me.bogeun.domain.User;
import me.bogeun.payload.user.UserCreateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User createDtoToUser(UserCreateDto createDto);

}
