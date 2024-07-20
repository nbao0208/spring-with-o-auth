package org.example.applicationwithoauth.shared.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Gender {
  MALE(1),
  FEMALE(0);

  private final int value;
}
