package org.example.applicationwithoauth.service;

import org.example.applicationwithoauth.model.request.user.CreateUserRequest;
import org.example.applicationwithoauth.model.response.Response;
import org.example.applicationwithoauth.model.response.user.CreateUserResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
  Response<CreateUserResponse> createUser(CreateUserRequest request);
}
