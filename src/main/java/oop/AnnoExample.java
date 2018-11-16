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

    ClassPreamble annotation = AnnoExample.class
        .getAnnotation(ClassPreamble.class);

    System.out.println(annotation
        .reviewers()[1]); // "Bob"
  }
}
