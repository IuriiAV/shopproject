package org.telran.shop.de.converter;

import org.springframework.stereotype.Component;
import org.telran.shop.de.dto.UserCreateDto;
import org.telran.shop.de.dto.UserResponseDto;
import org.telran.shop.de.entity.User;

@Component
public class UserCreateConverter implements Converter<User, UserCreateDto, UserResponseDto> {

    @Override
    public UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getId(), user.getLogin(), user.getEmail());
    }

    @Override
    public User toEntity(UserCreateDto userCreateDto) {
        return new User(userCreateDto.getLogin(), userCreateDto.getEmail());
    }
}