package com.alasgarov.ms.user.service;

import com.alasgarov.ms.user.dto.CreateUserRequest;
import com.alasgarov.ms.user.dto.UserDto;
import com.alasgarov.ms.user.model.User;
import com.alasgarov.ms.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.alasgarov.ms.user.dto.converter.UserConverter.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserDto createUser(CreateUserRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .build();
        return convertToUserDto(userRepository.save(user));
    }

    public UserDto getUserById(Long id) {
        return convertToUserDto(findById(id));
    }

    private User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> {
            log.error("ActionLog.getUserById.error id:{}", id);
            throw new RuntimeException("");
        });
    }
}
