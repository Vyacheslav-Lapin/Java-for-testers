package oop.nested;

import lombok.experimental.FieldDefaults;
import lombok.experimental.Helper;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
public final class HelperExample {
//  int someMethod(int arg1) {
//    int localVar = 5;
//
//    @Helper
//    class Helpers {
//      int helperMethod(int arg) {
//        return arg + localVar;
//      }
//    }
//
//    return helperMethod(10);
//  }
}
