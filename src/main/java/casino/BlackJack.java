package casino;

import lombok.SneakyThrows;
import org.apache.commons.math3.util.MathArrays;

import java.io.IOException;

public final class BlackJack {

  static final String LINE_SEPARATOR = System.lineSeparator();

  @SneakyThrows
  static char getCharacterFromUser() {
    byte[] input = new byte[1 + LINE_SEPARATOR.length()];
    if (System.in.read(input) != input.length)
      throw new RuntimeException("Что-то не так с вводом");
    return (char) input[0];
  }

  public static void main(String... __) {
//    System.out.println("Введи число");
//    System.out.println(Character.isDigit(getCharacterFromUser()));

    int[] cardIds = {
        0, 1, 2, 3, 4, 5, 6, 7, 8, // черви
        9, 10, 11, 12, 13, 14, 15, 16, 17, // бубны
        18, 19, 20, 21, 22, 23, 24, 25, 26, // пики
        27, 28, 29, 30, 31, 32, 33, 34, 35 // трефы (крести)
    };


    MathArrays.shuffle(cardIds);

    boolean isFirstIteration = true;
    int counter = 0;

    //noinspection ConstantConditions
    do {
      int card = cardIds[counter++]; // взяли карту

      // TODO: 2018-11-17 реализовать логику игры

    } while ((isFirstIteration && !(isFirstIteration = false))
        || (true)); // todo - написать реальное условие


  }
}
