package casino;

public final class Slot {

  private final static int BARABAN_LENGTH = 7;

  public static void main(String[] args) {

    int money = Integer.parseInt(args[0]);

    while (money > 0) {

      money -= 10;

      int usilie1 = (int) Math.round(Math.random() * 100);
      int usilie2 = (int) Math.round(Math.random() * 100);
      int usilie3 = (int) Math.round(Math.random() * 100);

      int baraban1Position = usilie1 % BARABAN_LENGTH;
      int baraban2Position = usilie2 % BARABAN_LENGTH;
      int baraban3Position = usilie3 % BARABAN_LENGTH;

      if (baraban1Position == baraban2Position
          && baraban1Position == baraban3Position) {
        money += 10_000;
        break;
      }
    }

    if (money > 0) {
      System.out.println("Вы выиграли! Забирайте свои деньги: $" + money);
    } else {
      System.out.println("Вы проиграли! Соболезнуем...");
    }
  }
}
