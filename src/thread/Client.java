package thread;

import java.util.Scanner;

public class Client {

  private UserInterface ui = new UserInterface();
  private MusicPlayer musicPlayer = new MusicPlayer();
  private Scanner scanner = new Scanner(System.in);

  public Client() {
    musicPlayer.add("Ant_Fire", "For_The_Love_Of", "Pila_Pala_Paradise", "Silky_Smooth", "Slug_Love_87");
  }

  private void playMusic(final int index) {
    if (musicPlayer.getStatus().equals(Status.PLAYING)) {
      musicPlayer.stop();
    }
    musicPlayer.play(index);
  }

  private void stopMusic() {
    musicPlayer.stop();
  }

  public void execute() {
    while (true) {
      String menu = ui.mainMenu();
      switch (menu) {
        case "1":
          ui.printList(musicPlayer.getList());
          break;
        case "2":
          String music = ui.playMusic(musicPlayer.getList());
          playMusic(Integer.parseInt(music));
          break;
        case "3":
          ui.stopMusic();
          stopMusic();
          break;
        case "4":
          ui.exit();
          return;
        default:
          System.out.println("잘못된 입력입니다.");
      }
    }
  }

  public static void main(String[] args) {
    Client client = new Client();
    client.execute();
  }

}
