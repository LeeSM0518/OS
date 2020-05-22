package memory;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDateTime;

public class Test {
  public static void main(String[] args) {
    LocalDateTime localDateTime = LocalDateTime.now();
    System.out.println(localDateTime);
    System.out.println(localDateTime.toLocalDate().toString());
    System.out.println(localDateTime.toLocalTime().toString());

    String date = localDateTime.toLocalDate().toString() + " " + localDateTime.toLocalTime().toString();
    System.out.println(date);
  }
}
