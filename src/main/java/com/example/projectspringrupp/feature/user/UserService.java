package com.example.projectspringrupp.feature.user;

import com.example.projectspringrupp.feature.user.dto.UserCreateRequest;
import com.example.projectspringrupp.feature.user.dto.UserResponse;
import com.example.projectspringrupp.feature.user.dto.UserUpdateRequest;

import java.util.List;

public interface UserService {
    // Create User
    UserResponse createUser(UserCreateRequest userCreateRequest);
    // Find all user
    List<UserResponse> findAllUser();
    // Find user by phone number
    UserResponse findUserByPhone(String phone);
    // Update user by phone number
    UserResponse UpdateUser(String phone, UserUpdateRequest userUpdateRequest);
    // Delete user by phone number
    void deleteUserByPhone(String phone);

}
