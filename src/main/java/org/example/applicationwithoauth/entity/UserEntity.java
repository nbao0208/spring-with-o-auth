package org.example.applicationwithoauth.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.applicationwithoauth.shared.enums.Gender;

import java.sql.Date;

@Entity
@Table(name = "aoa_user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {
  @Column(name = "name")
  private String name;

  @Column(name = "dob")
  private Date dob;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "personality_id")
  private String personalityId;

  @Column(name = "gender")
  @Enumerated(value = EnumType.STRING)
  private Gender gender;
}
