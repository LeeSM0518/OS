package schedulingproject.scheduling;

import schedulingproject.Process;

import java.util.*;
import java.util.stream.IntStream;

public class RoundRobing extends Scheduling {

  @Override
  Map<String, Object> scheduleProcess(Queue<Process> processes) throws CloneNotSupportedException {
    Map<String, Object> map = new HashMap<>();
    Queue<Process> cloneQueue = new LinkedList<>();
    cloneProcess(cloneQueue, processes);
    Queue<Process> queue = new LinkedList<>();

    int totalProcessingTime = cloneQueue.stream().mapToInt(Process::getBurstTime).sum();
    double averageLatency = 0;
    int processCount = processes.size();

    Process process = null;
    int time = 0;
    int timeDivision = 3;

    while (!queue.isEmpty() || !cloneQueue.isEmpty() || process != null) {
      System.out.println("time: " + time + "\tQueue: " + queue);
      int finalTime = time;
      Process arrivalProcess =
          cloneQueue.stream().filter(pro -> pro.getArrivalTime() == finalTime).findFirst().orElse(null);
      if (arrivalProcess != null) {
        cloneQueue.remove(arrivalProcess);
        queue.add(arrivalProcess);
      }
      if (process == null) {
        process = queue.poll();
      }
      System.out.println("Process: " + process);

      process.setBurstTime(process.getBurstTime() - 1);


      if (process.getBurstTime() == 0) {
        if (queue.isEmpty() && cloneQueue.isEmpty()) break;
        process = queue.poll();
        timeDivision = 3;
      }

      Process finalProcess = process;
      averageLatency += queue.stream().filter(pro -> !pro.getName().equals(finalProcess.getName())).count();
      System.out.println("averageLatency: " + averageLatency);
      System.out.println();

      time++;
      timeDivision--;
      if (timeDivision == 0) {
        queue.add(process);
        process = queue.poll();
        timeDivision = 3;
      }
    }

    averageLatency /= processCount;

    map.put("totalProcessingTime", totalProcessingTime);
    map.put("averageLatency", averageLatency);

    return map;
  }

  private void cloneProcess(Queue<Process> queue1, Queue<Process> queue2) throws CloneNotSupportedException {
    for (Process process : queue2) {
      queue1.add((Process) process.clone());
    }
  }
}
