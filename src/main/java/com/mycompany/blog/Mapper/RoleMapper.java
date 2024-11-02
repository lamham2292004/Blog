package com.mycompany.blog.Mapper;

import com.mycompany.blog.dto.request.PermissionRequest;
import com.mycompany.blog.dto.request.RoleRequest;
import com.mycompany.blog.dto.response.PermissionResponse;
import com.mycompany.blog.dto.response.RoleResponse;
import com.mycompany.blog.entity.Permission;
import com.mycompany.blog.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
     @Mapping(target = "permissions", ignore = true)
     Role toRole(RoleRequest request);

     RoleResponse toRoleResponse(Role role);
}
