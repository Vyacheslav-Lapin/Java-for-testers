package oop;

@ClassPreamble(
        author = "John Doe",
        date = "3/17/2002",
        currentRevision = 6,
        lastModified = "4/12/2004",
        lastModifiedBy = "Jane Doe",
        reviewers = {"Alice", "Bob", "Cindy"})
public final class AnnoExample {

  public static void main(String... __) {

    System.out.println(AnnoExample.class
        .getAnnotation(ClassPreamble.class)
        .reviewers()[1]); // "Bob"
  }
}
