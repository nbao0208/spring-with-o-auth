package org.example.applicationwithoauth.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.applicationwithoauth.dto.UserDto;
import org.example.applicationwithoauth.model.request.user.CreateUserRequest;
import org.example.applicationwithoauth.model.response.Response;
import org.example.applicationwithoauth.model.response.user.CreateUserResponse;
import org.example.applicationwithoauth.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserDto userDto;

  @Override
  public Response<CreateUserResponse> createUser(CreateUserRequest request) {
    return Response.<CreateUserResponse>builder()
            .id(UUID.randomUUID().toString())
            .data(userDto.createUser(request))
            .build();
  }
}
