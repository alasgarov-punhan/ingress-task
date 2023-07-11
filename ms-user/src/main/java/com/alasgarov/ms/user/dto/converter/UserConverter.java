package com.alasgarov.ms.user.dto.converter;

import com.alasgarov.ms.user.dto.UserDto;
import com.alasgarov.ms.user.model.User;

public class UserConverter {

    public static UserDto convertToUserDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}
