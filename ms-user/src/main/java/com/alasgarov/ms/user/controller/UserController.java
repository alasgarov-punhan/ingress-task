package com.alasgarov.ms.user.controller;

import com.alasgarov.ms.user.dto.CreateUserRequest;
import com.alasgarov.ms.user.dto.UserDto;
import com.alasgarov.ms.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    UserDto getUser(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping
    UserDto createUser(@Valid @RequestBody CreateUserRequest request){
        return userService.createUser(request);
    }

}
