package schedulingproject.scheduling;

import schedulingproject.Process;
import schedulingproject.UserInterface;

import java.util.Map;
import java.util.Queue;

public abstract class Scheduling {

  private UserInterface userInterface = new UserInterface();

  public void run(Queue<Process> processes) throws CloneNotSupportedException {
    userInterface.printSchedulingResult(scheduleProcess(processes));
  }

  abstract Map<String, Object> scheduleProcess(Queue<Process> processes) throws CloneNotSupportedException;

}
