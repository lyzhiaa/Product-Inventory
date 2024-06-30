package com.example.projectspringrupp.feature.user;

import com.example.projectspringrupp.domain.User;
import com.example.projectspringrupp.feature.user.dto.UserCreateRequest;
import com.example.projectspringrupp.feature.user.dto.UserResponse;
import com.example.projectspringrupp.feature.user.dto.UserUpdateRequest;
import com.example.projectspringrupp.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // create user
    @Override
    public UserResponse createUser(UserCreateRequest userCreateRequest) {
        // validate user phone number
        if (userRepository.existsByUserPhone(userCreateRequest.userPhone())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "This user is already exist!");
        }
        // transfer DTO domain model
        User user = userMapper.fromUserCreateRequest(userCreateRequest);
        user = userRepository.save(user);

        // system generate date
        user.setFirstname(user.getFirstname());
        user.setLastname(user.getLastname());
        user.setUserPhone(user.getUserPhone());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());

        // save product to database
        user = userRepository.save(user);

        return userMapper.toUserResponse(user);
    }

    // find all user
    @Override
    public List<UserResponse> findAllUser() {
        List<User> users= userRepository.findAll();
        return userMapper.toUserResponseList(users);
    }

    // find user by name
    @Override
    public UserResponse findUserByPhone(String phone) {
        User user = userRepository.findByUserPhone(phone)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "This user is not found!"));
        return userMapper.toUserResponse(user);
    }

    // update user
    @Override
    public UserResponse UpdateUser(String phone, UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findByUserPhone(phone)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "We can not find this user."));
        userMapper.fromUserUpdateRequest(userUpdateRequest, user);
        user = userRepository.save(user);

        return userMapper.toUserResponse(user);
    }

    // delete user
    @Override
    public void deleteUserByPhone(String phone) {
        User user = userRepository.findByUserPhone(phone)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Can't delete this user because it is not found."));
        userRepository.delete(user);
    }
}
