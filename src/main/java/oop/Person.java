package oop;

import lombok.*;
import lombok.experimental.Wither;

import java.util.Date;
import java.util.Set;

@Value // @Getter, @ToString, @EqualsAndHashCode, @AllArgsConstructor, @FieldDefaults(level = PRIVATE, makeFinal = true)
//@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode
//@NoArgsConstructor(force = true)
//@RequiredArgsConstructor
@Wither
@Builder
@EqualsAndHashCode(exclude = "age")
public final class Person {

  public static double PI = 3.1415;

  @Getter(onMethod = @__(@SuppressWarnings("unchecked")))
  String firstName;

//  @Setter(onParam = @__(@NotNull))
  String lastName;

//  @NonFinal
  @Builder.Default
  int age = 55;

  @Singular
  Set<String> contacts;

//  @Setter(PRIVATE)
  Date dob;
  boolean isTester;
}
