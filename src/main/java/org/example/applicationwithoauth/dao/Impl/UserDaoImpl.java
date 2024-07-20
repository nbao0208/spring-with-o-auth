package org.example.applicationwithoauth.dao.Impl;

import lombok.RequiredArgsConstructor;
import org.example.applicationwithoauth.dao.UserDao;
import org.example.applicationwithoauth.entity.UserEntity;
import org.example.applicationwithoauth.repository.UserRepository;
import org.example.applicationwithoauth.shared.enums.Gender;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
  private final UserRepository userRepository;

  @Override
  public boolean createUser(String name, Date dob, String phoneNumber, String personalityId, int genderValue) {
    userRepository.save(this.createUserFromDefaultInfo(name, dob, phoneNumber, personalityId, genderValue));
    return true;
  }

  private UserEntity createUserFromDefaultInfo(String name, Date dob, String phoneNumber, String personalityId, int genderValue) {
    return UserEntity.builder()
            .name(name)
            .dob(dob)
            .phoneNumber(phoneNumber)
            .personalityId(personalityId)
            .gender(this.genderFromGenderValue(genderValue))
            .build();
  }

  private Gender genderFromGenderValue(int genderValue) {
    if (genderValue == Gender.FEMALE.getValue()) {
      return Gender.FEMALE;
    }
    return Gender.MALE;
  }
}
