package me.bogeun.mapper;

import me.bogeun.domain.User;
import me.bogeun.entity.UserEntity;
import me.bogeun.payload.user.UserCreateDto;
import me.bogeun.payload.user.UserUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User createDtoToUser(UserCreateDto createDto);

    UserEntity userToEntity(User user);

    User entityToUser(UserEntity entity);

    @Mapping(target = "username", ignore = true)
    @Mapping(target = "birthDate", ignore = true)
    @Mapping(target = "gender", ignore = true)
    UserEntity updateDtoToEntity(UserUpdateDto updateDto);

}
