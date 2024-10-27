package com.mycompany.blog.Mapper;

import com.mycompany.blog.dto.request.UserCreationRequest;
import com.mycompany.blog.dto.request.UserUpdateRequest;
import com.mycompany.blog.dto.response.UserResponse;
import com.mycompany.blog.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
     User toUser(UserCreationRequest request);

//     @Mapping(source = "firstName", target = "lastName") ( code này có nghĩa là gán first = last / vd : first = lam thì last đang là mai anh cũng sẽ thành lam )
     UserResponse toUserResponse(User user);
     void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
