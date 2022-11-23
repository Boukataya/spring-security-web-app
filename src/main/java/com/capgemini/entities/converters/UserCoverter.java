package com.capgemini.entities.converters;

import com.capgemini.entities.UserEntity;
import com.capgemini.entities.dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class UserCoverter {
    public static List<UserDto> toUserDtoList(List<UserEntity> listUsers) {
        List<UserDto> listUsersDto = new ArrayList<>();
        listUsers.stream().map(user -> listUsersDto.add(toUserDto(user))).collect(Collectors.toList());
        return listUsersDto;
    }

    public static UserDto toUserDto(UserEntity user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        //userDto.setRoles(user.getRoles());

        return userDto;
    }
}
