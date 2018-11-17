package casino;

import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.util.MathArrays;

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

  public int cardsCount() {
    int head = incrementCounter(0);
    int tail = incrementCounter(1);
    return tail - head + (head < tail ? 0 : values.length);
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
    playersCards[1] = new IntArrayQueue(cardIds, CARDS_HALF_LENGTH, CARDS_HALF_LENGTH, CARDS_LENGTH);
  }

  public static void main(String... __) {

    Boolean isFirstPlayerLastWin = true;

    for (int counter = 1; !playersCards[0].isFullOrEmpty(); counter++) {
      int card1 = playersCards[0].get();
      int card2 = playersCards[0].get();

      int compare = compare(card1, card2);

      if (compare == 0) {
        playersCards[0].set(card1);
        playersCards[1].set(card2);
        log.info("Раунд №{}; Результат - спор. Карта игрока №1 {}, кол-во карт {}; карта игрока №2 - {}, кол-во карт {}",
            counter,
            toString(card1),
            playersCards[0].cardsCount(),
            toString(card2),
            playersCards[1].cardsCount());
        isFirstPlayerLastWin = null;
      } else if (compare > 0) {
        playersCards[0].set(card1);
        playersCards[0].set(card2);
        log.info("Раунд №{}; Результат - выиграл игрок №1. Карта игрока №1 {}, кол-во карт {}; карта игрока №2 - {}, кол-во карт {}",
            counter,
            toString(card1),
            playersCards[0].cardsCount(),
            toString(card2),
            playersCards[1].cardsCount());
        isFirstPlayerLastWin = true;
      } else {
        playersCards[1].set(card1);
        playersCards[1].set(card2);
        log.info("Раунд №{}; Результат - выиграл игрок №2. Карта игрока №1 {}, кол-во карт {}; карта игрока №2 - {}, кол-во карт {}",
            counter,
            toString(card1),
            playersCards[0].cardsCount(),
            toString(card2),
            playersCards[1].cardsCount());
        isFirstPlayerLastWin = false;
      }
    }

    assert isFirstPlayerLastWin != null;

    log.info(isFirstPlayerLastWin ?
        "Вы выиграли! Поздравляем! :)))"
        : "Вы проиграли! Соболезнуем... :(");
  }

  private static String toString(int cardId) {
    return Value.get(cardId) + " " + Suit.get(cardId);
  }

  public int compare(int card1Id, int card2Id) {
    int value1 = Value.get(card1Id).ordinal(); // card1Id % 9;
    int value2 = Value.get(card2Id).ordinal(); // card2Id % 9;

    int partialResult = value1 - value2;
    return Math.abs(partialResult) == 8 ? -partialResult : partialResult;
  }
}