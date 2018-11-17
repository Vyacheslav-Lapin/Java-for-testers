package casino;// import casino.Slot

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SlotTest {

  @Test
  @DisplayName("Мама мыла раму")
  void testPlay() {
    // given
    Random mock = mock(Random.class);

    when(mock.nextInt(100))
        .thenReturn(55);

    // when
    int money = Slot.play(mock, 1_000);

    // then
    assertEquals(10_990, money);
  }

  @ParameterizedTest
  @ValueSource(strings = { "Hello", "World" })
  void testWithStringParameter(String argument) {
    assertNotNull(argument);
  }
}