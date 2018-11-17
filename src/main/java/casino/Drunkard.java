package casino;

import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.MathArrays;

import java.util.Comparator;

import static lombok.AccessLevel.PRIVATE;

enum Value {
  SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

  static Value get(int cardId) {
    return values()[cardId % 9];
  }
}

enum Suit {
  HEARTS, DIAMONDS, SPADES, CLUBS;

  static Suit get(int cardId) {
    return values()[cardId / 9];
  }
}

@FieldDefaults(level = PRIVATE)
class IntArrayQueue {
  int[] values;
  int[] counters = new int[2]; // [head, tail]

  IntArrayQueue(int[] src, int start, int length, int maxLength) {
    values = new int[maxLength];
    System.arraycopy(src, start, values, 0, length);
    counters[1] = length;
  }

  @SuppressWarnings("WeakerAccess")
  public int get() {
    int head = incrementCounter(0);
    return values[head];
  }

  @SuppressWarnings("WeakerAccess")
  public void set(int cardId) {
    int tail = incrementCounter(1);
    values[tail] = cardId;
  }

  @SuppressWarnings("WeakerAccess")
  public boolean isFullOrEmpty() {
    return counters[0] == counters[1];
  }

  /**
   * @param counterId 0 - head, 1 - tail
   * @return counter++
   */
  private int incrementCounter(int counterId) {
    int result;
    result = counters[counterId]++;
    counters[counterId] %= values.length;
    return result;
  }
}

@Slf4j
@UtilityClass
@FieldDefaults(level = PRIVATE, makeFinal = true)
public final class Drunkard {

  int CARDS_LENGTH;
  int CARDS_HALF_LENGTH;
  IntArrayQueue[] playersCards = new IntArrayQueue[2];

  static {
    int[] cardIds = {
        0, 1, 2, 3, 4, 5, 6, 7, 8, // черви
        9, 10, 11, 12, 13, 14, 15, 16, 17, // бубны
        18, 19, 20, 21, 22, 23, 24, 25, 26, // пики
        27, 28, 29, 30, 31, 32, 33, 34, 35 // трефы (крести)
    };

    CARDS_LENGTH = cardIds.length;
    CARDS_HALF_LENGTH = CARDS_LENGTH / 2;

    MathArrays.shuffle(cardIds);

    playersCards[0] = new IntArrayQueue(cardIds, 0, CARDS_HALF_LENGTH, CARDS_LENGTH);
    playersCards[1] = new IntArrayQueue(cardIds, CARDS_HALF_LENGTH, CARDS_LENGTH, CARDS_LENGTH);
  }

  public static void main(String... __) {

    boolean isFirstPlayerLastWin = true;

    do {
      int card1 = playersCards[0].get();
      int card2 = playersCards[0].get();



    } while (!playersCards[0].isFullOrEmpty());

    log.info(isFirstPlayerLastWin ?
        "Вы выиграли! Поздравляем! :)))"
        : "Вы проиграли! Соболезнуем... :(");
  }

  private static String toString(int cardId) {
    return Value.get(cardId) + " " + Suit.get(cardId);
  }

  public int compare(Integer o1, Integer o2) {
    return 0;
  }
}