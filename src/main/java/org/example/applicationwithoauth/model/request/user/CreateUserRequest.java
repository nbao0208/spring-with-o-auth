package org.example.applicationwithoauth.model.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
  private String name;
  private Date dob;
  private String phoneNumber;
  private String personalityId;
  private int genderValue;
}
