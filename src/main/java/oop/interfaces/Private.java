package oop.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Ребята не используйте метод который помечен этой аннотацией!!!!
 * А когда будете перезодить на Java 9, то замените её на private!
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface Private {
}
