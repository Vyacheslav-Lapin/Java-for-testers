package casino;

import lombok.experimental.FieldDefaults;
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
public final class Drunkard {

  static int[] cardIds1 = new int[36];
  static int[] cardIds2 = new int[36];

  static {
    int[] cardIds = {
        0, 1, 2, 3, 4, 5, 6, 7, 8, // черви
        9, 10, 11, 12, 13, 14, 15, 16, 17, // бубны
        18, 19, 20, 21, 22, 23, 24, 25, 26, // пики
        27, 28, 29, 30, 31, 32, 33, 34, 35 // трефы (крести)
    };

    MathArrays.shuffle(cardIds);

    System.arraycopy(cardIds, 0, cardIds1, 0, 18);
    System.arraycopy(cardIds, 18, cardIds2, 0, 18);

//    for (int cardId : cardIds1) System.out.print(toString(cardId) + ", ");
//    System.out.println();
//    for (int cardId : cardIds2) System.out.print(toString(cardId) + ", ");

  }

//  static int[][] counts = {{0, 18}, {0, 18}};

  static int head1; // = 0
  static int head2; // = 0

  static int tail1 = 18;
  static int tail2 = 18;

  public static void main(String... __) {

    boolean isFirstPlayerLastWin = true;

    do {
      // TODO: 2018-11-16 решить задачу - написать логику игры
    } while(!isFinished());

    if (isFirstPlayerLastWin) {
      System.out.println("Вы выиграли! Поздравляем! :)))");
    } else {
      System.out.println("Вы проиграли! Соболезнуем... :(");
    }
  }

  private static String toString(int cardId) {
    return Value.get(cardId) + " " + Suit.get(cardId);
  }

  private static int getCardId(int player) {
    int head = incrementHead(player);
    return player == 0 ? cardIds1[head] : cardIds2[head];
  }

  private static void setCardId(int player, int cardId) {
    if (player == 0) cardIds1[incrementTail(player)] = cardId;
    else cardIds2[incrementTail(player)] = cardId;
  }

  private static boolean isFinished() {
    return head1 == tail1;
  }

  private static int incrementHead(int player) {
    int result;
    if (player == 0) {
      result = head1++;
      head1 %= 36;
    } else {
      result = head2++;
      head2 %= 36;
    }

    return result;
  }

  private static int incrementTail(int player) {
    int result;

    if (player == 0) {
      result = tail1++;
      tail1 %= 36;
    } else {
      result = tail2++;
      tail2 %= 36;
    }

    return result;
  }
}