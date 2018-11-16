package oop.interfaces;

public interface Interface1 {

  int x = 5;

  void m1();

  void m2();

  default void m3() {
    m();
    // ...
  }

  default void m4() {
    m();
    // ...
  }

  private void m() {
    System.out.println("Hello, World inside Interface1.m2!");
  }

  static void main(String... __) {
    CInt1 cInt1 = new CInt1();
    cInt1.m1();
    cInt1.m2();
//    cInt1.m();
  }
}

interface Interface2 {
  default void m2() {
    System.out.println("Hello, World inside Interface2.m2!");
  }
}

class CInt1 implements Interface1, Interface2 {
  @Override
  public void m1() {
    System.out.println("Hello, World!");
  }

  @Override
  public void m2() {
    Interface2.super.m2();
  }
}