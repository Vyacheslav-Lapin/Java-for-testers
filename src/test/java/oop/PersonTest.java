package oop;// import oop.Person

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Date;

import static lombok.AccessLevel.PRIVATE;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
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

    val person = Person.builder()
        .age(58)
        .lastName("Иванова")
        .dob(new Date())
//        .contacts(Set.of("222-33-22", "kljghdfg@kjsd.ru"))
        .contact("222-33-22")
        .contact("kljghdfg@kjsd.ru")
        .firstName(FIRST_NAME)
        .build();

//    var person = new Person()
//        .setAge(55)
//        .setFirstName("Вася")
//        .setLastName(null);

    // then
    var person1 = person
        .withLastName("Петрова")
//        .withAge(15)
//        .withTester(false)
        ;

    var person2 = Person.builder()
        .lastName("Иванова")
        .dob(new Date())
        .firstName(FIRST_NAME)
        .build();

    var x = 59L; // int

    assertThat(x).isEqualTo(59);

//    try {
    Class.forName("java.lang.String");
//    } catch (ClassNotFoundException e) {
//      e.printStackTrace();
//      log.warn("Что-то пошло не так!.. :(((");
//    }

    assertThat(person1.getAge()).isEqualTo(58);
    assertThat(person1.getFirstName()).isEqualTo(FIRST_NAME);
    assertThat(person1.getLastName()).isEqualTo("Петрова");

    assertThat(person.getAge()).isEqualTo(58);
//    assertThat(person.getAge()).isEqualTo(0);
    assertThat(person.getFirstName()).isEqualTo(FIRST_NAME);
    assertThat(Person.PI).isEqualTo(3.1415);

    assertThat(person2.getAge()).isEqualTo(55);

    @Cleanup InputStream resourceAsStream = PersonTest.class
        .getResourceAsStream("/log4j2.xml");

//    try
////        (InputStream resourceAsStream = PersonTest.class
////        .getResourceAsStream("/log4j2.xml"))
//    {
//
//    } finally {
//      if (resourceAsStream != null) {
//        resourceAsStream.close();
//      }
//    }


  }

}