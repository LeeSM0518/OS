package thread;

import javazoom.jl.player.Player;

import javax.sound.sampled.*;
import java.io.*;
import java.util.Scanner;

public class Music {

  private String filename;
  private BufferedInputStream buffer;

  public Music(String filename) {
    this.filename = filename;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public BufferedInputStream getBuffer() throws FileNotFoundException {
    return new BufferedInputStream(
            new FileInputStream("src/thread/music-files/" + filename + ".mp3"));
  }

}
