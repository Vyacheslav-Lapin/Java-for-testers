package oop;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface ClassPreamble {
  String author();

  String date();

  int currentRevision() default 1;

  String lastModified() default "N/A";

  String lastModifiedBy() default "N/A";

  String[] reviewers();
}
