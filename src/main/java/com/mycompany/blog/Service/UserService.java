package com.mycompany.blog.Service;

import com.mycompany.blog.Mapper.UserMapper;
import com.mycompany.blog.Repository.UserRepository;
import com.mycompany.blog.dto.request.UserCreationRequest;
import com.mycompany.blog.dto.request.UserUpdateRequest;
import com.mycompany.blog.dto.response.UserResponse;
import com.mycompany.blog.entity.User;
import com.mycompany.blog.enums.Role;
import com.mycompany.blog.exception.AppException;
import com.mycompany.blog.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

//CREATE
    public UserResponse createUser(UserCreationRequest request) {

        //ko cho trùng email
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXITED);
        }
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTS);
        }
        User user = userMapper.toUser(request);
        //mã hóa pass
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        HashSet<String>roles = new HashSet<>();
        roles.add(Role.USER.name());

        user.setRoles(roles);
        return userMapper.toUserResponse(userRepository.save(user));
    }
//READ
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse).toList();
    }

    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found")));
    }
//UPDATE
    public UserResponse updateUser(String userId ,UserUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        userMapper.updateUser(user,request);
        return userMapper.toUserResponse(userRepository.save(user));
    }//DELETE
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
