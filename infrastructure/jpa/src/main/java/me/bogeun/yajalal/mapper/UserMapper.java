package me.bogeun.yajalal.mapper;

import me.bogeun.yajalal.domain.User;
import me.bogeun.yajalal.entity.UserEntity;
import me.bogeun.yajalal.payload.user.UserCreateDto;
import me.bogeun.yajalal.payload.user.UserUpdateDto;
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
