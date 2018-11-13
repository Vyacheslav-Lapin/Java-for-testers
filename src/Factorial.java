
public class Factorial {

  public static long get(int i) {
    return i == 0 ? 1 : i * get(i - 1);
  }
}
