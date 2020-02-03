package thread;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class UserInterface {

  Scanner scanner = new Scanner(System.in);

  public String mainMenu() {
    System.out.print("============ Min's Music Player ============\n" +
            "1. 음악 리스트 보기\n" +
            "2. 음악 재생하기\n" +
            "3. 음악 정지\n" +
            "4. 프로그램 종료\n" +
            "============================================\n" +
            ">> ");
    return scanner.nextLine();
  }

  private void borderPrint(final Consumer<Scanner> consumer) {
    System.out.println("============================================");
    consumer.accept(scanner);
    System.out.println("============================================");
    System.out.println();
  }

  public void printList(final List<Music> musicList) {
    borderPrint(sc -> {
      for (int i = 0; i < musicList.size(); i++) {
        System.out.println(i + ". 이름: " + musicList.get(i).getFilename());
      }
    });
  }

  public String playMusic(final List<Music> musicList) {
    printList(musicList);
    System.out.print("재생할 음악의 번호를 입력해주세요 >> ");
    return scanner.nextLine();
  }

  public void stopMusic() {
    borderPrint(sc -> System.out.println("음악 정지"));
  }

  public void exit() {
    borderPrint(sc -> System.out.println("종료합니다."));
  }

}
