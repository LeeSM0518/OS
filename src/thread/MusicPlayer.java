package thread;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MusicPlayer {

  private Player player;
  private List<Music> musicList;
  private Status status;
  private Thread thread;

  public MusicPlayer() {
    musicList = new ArrayList<>();
    status = Status.STOP;
  }

  public void play(final int index) {
    try {
      player = new Player(musicList.get(index).getBuffer());
      status = Status.PLAYING;
      thread = new Thread(() -> {
        try {
          player.play();
        } catch (JavaLayerException e) {
          e.printStackTrace();
        }
      });
      thread.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void stop() {
    status = Status.STOP;
    player.close();
    thread.interrupt();
  }

  public void add(String... names) {
    for (String name : names) {
      musicList.add(new Music(name));
    }
  }

  public Status getStatus() {
    return status;
  }

  public List<Music> getList() {
    return musicList;
  }
}
