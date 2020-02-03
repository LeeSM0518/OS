package thread;

import javazoom.jl.player.Player;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Music {

  private String filename;
  private Player player;

  public Music(String filename) {
    this.filename = filename;
  }

  public void play() {
    try {
      BufferedInputStream buffer = new BufferedInputStream(
          new FileInputStream(filename));
      player = new Player(buffer);
      player.play();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void stop() {
    player.close();
  }

  public static void main(String[] args) {
    Music music = new Music("src/thread/music-files/Ant_Fire.mp3");
    Thread thread = new Thread(music::play);
    thread.start();
    Scanner scanner = new Scanner(System.in);
    String value = scanner.nextLine();
    if (value.equals("1")) {
      music.stop();
    }
  }

}
