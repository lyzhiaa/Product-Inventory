package com.example.projectspringrupp.feature.user;

import com.example.projectspringrupp.feature.user.dto.UserCreateRequest;
import com.example.projectspringrupp.feature.user.dto.UserResponse;
import com.example.projectspringrupp.feature.user.dto.UserUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;
    //create user
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    UserResponse createNewUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
        return userService.createUser(userCreateRequest);
    }
    //find single user
    @GetMapping("/{phone}")
    UserResponse findUserByPhone(@Valid @PathVariable String phone) {
        return userService.findUserByPhone(phone);
    }

    //find all user
    @GetMapping
    List<UserResponse> findAllUser() {
        return userService.findAllUser();
    }

    //update user
    @PatchMapping("/{phone}")
    UserResponse updateByPhone(@Valid @PathVariable String phone, @RequestBody UserUpdateRequest userUpdateRequest) {
        return userService.UpdateUser(phone, userUpdateRequest);
    }

    //delete user
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{phone}")
    void deleteByPhone(@Valid @PathVariable String phone) {
        userService.deleteUserByPhone(phone);
    }
}
