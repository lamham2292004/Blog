package com.mycompany.blog.Mapper;

import com.mycompany.blog.dto.request.PermissionRequest;
import com.mycompany.blog.dto.response.PermissionResponse;
import com.mycompany.blog.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
     Permission toPermission(PermissionRequest request);
     PermissionResponse toPermissionResponse(Permission permission);

}
