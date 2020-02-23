package schedulingproject;

import schedulingproject.scheduling.Scheduling;

import java.util.*;

public class Client {

  UserInterface ui = new UserInterface();
  Queue<Process> queue = new LinkedList<>();
  Map<String, Object> map = new HashMap<>();

  private void createProcesses(int count) {
    for (int i = 0; i < count; i++) {
      Process process = new Process(
          "P" + i,
          i,
          (int) (Math.random() * 10) + 1,
          (int) (Math.random() * 10) + 1,
          0);
      queue.add(process);
    }
  }

  public void run() {
    while (true) {
      int processCount;
      try {
        processCount = Integer.parseInt(ui.selectProcessCount());
        createProcesses(processCount);
        map.put("queue", queue);
      } catch (NumberFormatException e) {
        System.out.println("잘못된 입력입니다.");
        processCount = -1;
      }
      while (processCount != -1) {
        String menu = ui.mainMenu(map);
        Technique technique = Technique.findByQualifier(menu);
        if (technique != null) {
          technique.getScheduling().run(queue);
        } else if ("9".equals(menu)) {
          queue.clear();
          break;
        } else if ("10".equals(menu)) {
          return;
        } else {
          System.out.println("잘못된 입력입니다.");
        }
      }
    }
  }

}