package pkg;

class Num { }
class Int extends Num { }
class LongInt extends Int { }

public class Mathematica {

  public Mathematica(Num obj) {
    System.out.println(1);
  }
  public Mathematica(Int obj) {
    System.out.println(2);
  }
  public Mathematica(Num obj1, Int obj2) {
    System.out.println(3);
  }
  public Mathematica(Int obj1, Int obj2) {
    System.out.println(4);
  }

  public static void main(String[] args) {
    Num num0 = new Num();
    Num num1 = new Int();
    Int anInt = new Int();
    LongInt longInt = new LongInt();

    Mathematica m1 = new Mathematica(num0); // 1
    Mathematica m2 = new Mathematica(anInt); // 2
    Mathematica m3 = new Mathematica(longInt); // 2
    Mathematica m4 = new Mathematica(num1); // 1
    Mathematica m5 = new Mathematica(num0, anInt); // 3
    Mathematica m6 = new Mathematica(longInt, anInt); // 4
//    Mathematica m7 = new Mathematica(num0, num1);//error
//    Mathematica m8 = new Mathematica(longInt, num1);//error
  }
}
