package oop;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;

import java.sql.Connection;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public final class PooledConnection implements Connection {

  @Delegate(excludes = AutoCloseable.class)
  Connection connection;

  public void close() {
    //kjhsdg
  }
}
