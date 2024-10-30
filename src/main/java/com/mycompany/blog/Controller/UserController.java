package com.mycompany.blog.Controller;

import com.mycompany.blog.Service.UserService;
import com.mycompany.blog.dto.request.ApiResponse;
import com.mycompany.blog.dto.request.UserCreationRequest;
import com.mycompany.blog.dto.request.UserUpdateRequest;
import com.mycompany.blog.dto.response.UserResponse;
import com.mycompany.blog.entity.User;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {
     UserService userService;
//CREATE
    @PostMapping
     ApiResponse <UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse();


        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }
//READ
    @GetMapping
    ApiResponse<List<UserResponse>> getUsers(){
        return ApiResponse.<List<UserResponse>>builder()
            .result(userService.getUsers())
            .build();
}

    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUser(@PathVariable("userId") String userId){
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUser(userId))
                .build();
    }
//UPDATE
    @PutMapping("/{userId}")
     ApiResponse<UserResponse> updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return ApiResponse.<UserResponse>builder()
                          .result(userService.updateUser(userId,request))
                          .build();
    }
//DELETE
    @DeleteMapping("/{userId}")
    ApiResponse<String> deleteUser(@PathVariable String userId){
    userService.deleteUser(userId);
        return ApiResponse.<String>builder()
            .result("User has been deleted")
            .build();
}
}
