package oop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

import static lombok.AccessLevel.PRIVATE;

@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public final class Person {

  public static final double PI = 3.1415;

  String firstName;
  String lastName;
  int age;

  @Setter(PRIVATE)
  Date dob;
  boolean isTester;
}
