package org.example.applicationwithoauth.dao;

import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface UserDao {
  boolean createUser(String name, Date dob, String phoneNumber, String personalityId, int genderValue);
}
