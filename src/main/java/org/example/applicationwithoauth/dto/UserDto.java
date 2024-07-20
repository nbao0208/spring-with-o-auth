package org.example.applicationwithoauth.dto;

import org.example.applicationwithoauth.model.request.user.CreateUserRequest;
import org.example.applicationwithoauth.model.response.user.CreateUserResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDto {
  CreateUserResponse createUser(CreateUserRequest request);
}
