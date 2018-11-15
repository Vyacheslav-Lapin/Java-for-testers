package oop;

public final class VarArgsDemo {

  static void printArgCount(Integer[]... args) { // 2
    System.out.println("2");
  }

  static void printArgCount(Object... args) { // 1
    System.out.println("1");
  }

  static void printArgCount(int... args) { // 3
    System.out.print("3");
  }

  public static void main(String... __) {

    Integer[] i = {1, 2, 3, 4, 5};

    printArgCount(7,"No",true,null); // 1

    printArgCount(i, i, i); // 2

    printArgCount(i, 4,71); // 1

    printArgCount(i); // 1

//    printArgCount(5,7);
  }
}
