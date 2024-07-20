package org.example.applicationwithoauth.dto.Impl;

import lombok.RequiredArgsConstructor;
import org.example.applicationwithoauth.dao.UserDao;
import org.example.applicationwithoauth.dto.UserDto;
import org.example.applicationwithoauth.model.request.user.CreateUserRequest;
import org.example.applicationwithoauth.model.response.user.CreateUserResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDtoImpl implements UserDto {
  private final UserDao userDao;

  @Override
  public CreateUserResponse createUser(CreateUserRequest request) {
    return CreateUserResponse.builder()
            .success(userDao.createUser(request.getName(),
                    request.getDob(),
                    request.getPhoneNumber(),
                    request.getPersonalityId(),
                    request.getGenderValue()))
            .build();
  }

}
