package casino;

import java.util.Random;

public final class Slot {

  private final static int BARABAN_LENGTH = 25;

  public static void main(String[] args) {

    Random random = new Random();
    int money = Integer.parseInt(args[0]);

    money = play(random, money);

    if (money > 0) {
      System.out.println("Вы выиграли! Забирайте свои деньги: $" + money);
    } else {
      System.out.println("Вы проиграли! Соболезнуем...");
    }
  }

  static int play(Random random, int money) {
    while (money > 0) {

      money -= 10;

      int usilie1 = random.nextInt(100);
      int usilie2 = random.nextInt(100);
      int usilie3 = random.nextInt(100);

      int baraban1Position = usilie1 % BARABAN_LENGTH;
      int baraban2Position = usilie2 % BARABAN_LENGTH;
      int baraban3Position = usilie3 % BARABAN_LENGTH;

      if (baraban1Position == baraban2Position
          && baraban1Position == baraban3Position) {
        money += 10_000;
        break;
      }
    }
    return money;
  }
}
