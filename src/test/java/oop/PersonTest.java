package oop;// import oop.Person

import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lombok.AccessLevel.PRIVATE;
import static org.assertj.core.api.Assertions.assertThat;

@FieldDefaults(level = PRIVATE, makeFinal = true)
class PersonTest {
  @Test
  @SneakyThrows
  @DisplayName("\"GetAge\" method works correctly")
  void testGetAge() {
    // given
    Person person = new Person();

    // when
    person.setAge(55);

    // then
    assertThat(person.getAge()).isEqualTo(55);
    assertThat(Person.PI).isEqualTo(3.1415);

  }

}