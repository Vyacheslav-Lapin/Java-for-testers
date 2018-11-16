package oop.nested;

import lombok.experimental.FieldDefaults;
import lombok.val;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public final class Outer9 {

  int x = 3;

  static class Inner1 {
    public void method() {
      val out = new Outer9();
      System.out.println("out.x=" + out.x); // 3
    }
  }

}
