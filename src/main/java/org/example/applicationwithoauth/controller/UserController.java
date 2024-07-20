package org.example.applicationwithoauth.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.applicationwithoauth.model.request.user.CreateUserRequest;
import org.example.applicationwithoauth.model.response.Response;
import org.example.applicationwithoauth.model.response.user.CreateUserResponse;
import org.example.applicationwithoauth.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
  private final UserService userService;

  @PostMapping(value = "/create", produces = {MediaType.APPLICATION_JSON_VALUE})
  public Response<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {
    log.info("=====>request {}:", request.toString());
    return null;
//    return userService.createUser(request);
  }
}
