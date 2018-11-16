package oop;// import oop.Person

import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Set;

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
    //    Person person = new Person(FIRST_NAME,
//        "Иванова",
//        0,
//        dob,
//        true);

    Person person = Person.builder()
        .age(58)
        .lastName("Иванова")
        .dob(new Date())
//        .contacts(Set.of("222-33-22", "kljghdfg@kjsd.ru"))
        .contact("222-33-22")
        .contact("kljghdfg@kjsd.ru")
        .firstName(FIRST_NAME)
        .build();

//    Person person = new Person()
//        .setAge(55)
//        .setFirstName("Вася")
//        .setLastName(null);

    // then
    Person person1 = person
        .withLastName("Петрова")
//        .withAge(15)
//        .withTester(false)
        ;

    Person person2 = Person.builder()
        .lastName("Иванова")
        .dob(new Date())
        .firstName(FIRST_NAME)
        .build();

    assertThat(person1.getAge()).isEqualTo(58);
    assertThat(person1.getFirstName()).isEqualTo(FIRST_NAME);
    assertThat(person1.getLastName()).isEqualTo("Петрова");

    assertThat(person.getAge()).isEqualTo(58);
//    assertThat(person.getAge()).isEqualTo(0);
    assertThat(person.getFirstName()).isEqualTo(FIRST_NAME);
    assertThat(Person.PI).isEqualTo(3.1415);

    assertThat(person2.getAge()).isEqualTo(55);
  }

}