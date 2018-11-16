package oop;

import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PUBLIC;

@UtilityClass
@FieldDefaults(level = PUBLIC, makeFinal = true)
public class Math {

  double PI = 3.14;

  public double sin(double v) {
    //kjhsd
    return 0.0;
  }
}
