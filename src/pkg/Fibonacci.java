package pkg;

public class Fibonacci {

  public static int get(int i) {
    switch (i) {
      case 0: return 0;
      case 1: return 1;
      default: return get(i - 1) + get(i - 2);
    }
  }
}
