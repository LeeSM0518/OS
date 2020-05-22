package schedulingproject.scheduling;

import schedulingproject.MultiProcess;
import schedulingproject.Process;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MultilevelQueue extends Scheduling {

  @Override
  Map<String, Object> scheduleProcess(Queue<Process> processes) throws CloneNotSupportedException {
    Map<String, Object> map = new HashMap<>();
    Queue<Process> cloneQueue = cloneProcess(processes);

    Queue<MultiProcess> multiProcessQueue = new LinkedList<>();
    Queue<MultiProcess> foregroundQueue = new LinkedList<>();
    Queue<MultiProcess> backgroundQueue = new LinkedList<>();

    int totalProcessingTime = cloneQueue.stream().mapToInt(Process::getBurstTime).sum();
    double averageLatency = 0;
    int processCount = processes.size();

    for (Process process : cloneQueue) {
      if ((int)(Math.random() * 2) == 0) {
        multiProcessQueue.add(new MultiProcess(process, Type.FOREGROUND));
      } else {
        multiProcessQueue.add(new MultiProcess(process, Type.BACKGROUND));
      }
    }

    Process process = null;
    int time = 0;
    int timeDivision = 3;


    System.out.println(multiProcessQueue);

    map.put("totalProcessingTime", totalProcessingTime);
    map.put("averageLatency", averageLatency);

    return map;
  }

  private Queue<Process> cloneProcess(Queue<Process> queue2) throws CloneNotSupportedException {
    Queue<Process> queue1 = new LinkedList<>();
    for (Process process : queue2) {
      queue1.add((Process) process.clone());
    }
    return queue1;
  }

}
