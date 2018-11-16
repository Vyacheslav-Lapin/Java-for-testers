package oop;

import lombok.Getter;
import lombok.Value;
import lombok.experimental.Wither;

import java.util.Date;

@Value // @Getter, @ToString, @EqualsAndHashCode, @AllArgsConstructor, @FieldDefaults(level = PRIVATE, makeFinal = true)
//@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode
//@NoArgsConstructor(force = true)
@Wither
public final class Person {

  public static double PI = 3.1415;

  @Getter(onMethod = @__(@SuppressWarnings("unchecked")))
  String firstName;

//  @Setter(onParam = @__(@NotNull))
  String lastName;
  int age;

//  @Setter(PRIVATE)
  Date dob;
  boolean isTester;
}
