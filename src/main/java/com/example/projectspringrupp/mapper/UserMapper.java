package com.example.projectspringrupp.mapper;

import com.example.projectspringrupp.domain.Product;
import com.example.projectspringrupp.domain.User;
import com.example.projectspringrupp.feature.product.dto.ProductCreateRequest;
import com.example.projectspringrupp.feature.product.dto.ProductResponse;
import com.example.projectspringrupp.feature.product.dto.ProductUpdateRequest;
import com.example.projectspringrupp.feature.user.dto.UserCreateRequest;
import com.example.projectspringrupp.feature.user.dto.UserResponse;
import com.example.projectspringrupp.feature.user.dto.UserUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface UserMapper {
    UserResponse toUserResponse(User user);
    User fromUserCreateRequest(UserCreateRequest userCreateRequest);
    List<UserResponse> toUserResponseList(List<User> users);
    void fromUserUpdateRequest(UserUpdateRequest userUpdateRequest, @MappingTarget User user);
}
