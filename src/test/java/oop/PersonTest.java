package oop;// import oop.Person

import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static lombok.AccessLevel.PRIVATE;
import static org.assertj.core.api.Assertions.assertThat;

@FieldDefaults(level = PRIVATE, makeFinal = true)
class PersonTest {

  public static final String FIRST_NAME = "Василиса";

  @Test
  @SneakyThrows
  @DisplayName("\"GetAge\" method works correctly")
  void testGetAge() {
    // given
    // when
    Date dob = new Date();
    Person person = new Person(FIRST_NAME,
        "Иванова",
        0,
        dob,
        true);

//    Person person = new Person()
//        .setAge(55)
//        .setFirstName("Вася")
//        .setLastName(null);

    // then
    Person person1 = person.withLastName("Петрова");
    assertThat(person1.getAge()).isEqualTo(0);
    assertThat(person1.getFirstName()).isEqualTo(FIRST_NAME);
    assertThat(person1.getLastName()).isEqualTo("Петрова");

    assertThat(person.getAge()).isEqualTo(0);
    assertThat(person.getFirstName()).isEqualTo(FIRST_NAME);
    assertThat(Person.PI).isEqualTo(3.1415);
  }

}