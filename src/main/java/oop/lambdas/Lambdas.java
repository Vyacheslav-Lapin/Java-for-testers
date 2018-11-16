package oop.lambdas;

import java.util.Date;
import java.util.function.Supplier;

public interface Lambdas {

  static void main(String... __) {

    Supplier<String> stringSupplier = () ->
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    Supplier<Date> dateSupplier = Date::new;

    Supplier<String> stringSupplier1 = dateSupplier.get()::toString;

    Runnable runnable = () ->
        System.out.println(stringSupplier.get());

    Runnable runnable1 = () ->
        System.out.println(stringSupplier1.get());


    runRunnable(runnable);
    runRunnable(runnable1);
  }

  static void runRunnable(Runnable runnable) {
    runnable.run();
  }
}
