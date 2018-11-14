package pkg;

public class Program {

  public static void main(String[] args) {
//    System.out.println(MessageSource.getMessage());

//    Fibonacci.get(20).soutv
    System.out.println(Fibonacci.get(3) == 2); // true

    System.out.println(Factorial.get(3) == 6); // true

//    args.fori
    for (int i = 0; i < args.length; i++) {
//      args[i].sout
      System.out.println(args[i]);
    }

    System.out.println(" 6? - " + (Integer.parseInt(args[1]) + 3)); // 5
  }
}