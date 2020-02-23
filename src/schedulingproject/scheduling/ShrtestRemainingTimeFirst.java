package schedulingproject.scheduling;

import schedulingproject.Process;

import java.util.*;

public class ShrtestRemainingTimeFirst extends Scheduling {
  @Override
  Map<String, Object> scheduleProcess(Queue<Process> processes) {
    Map<String, Object> map = new HashMap<>();
    Queue<Process> queue = new LinkedList<>(processes);
    TreeSet<Process> treeSet = new TreeSet<>(((o1, o2) -> {
      if (o1.getBurstTime() < o2.getBurstTime()) return -1;
      else if (o1.getName().equals(o2.getName())) return 0;
      else return 1;
    }));

    int totalProcessingTime = treeSet.stream().mapToInt(Process::getBurstTime).sum();
    double averageLatency = 0;
    int processCount = treeSet.size();

    Process process;
    int time = 0;

    while (!treeSet.isEmpty() && !queue.isEmpty()) {
      treeSet.add(queue.poll());
    }

    averageLatency /= processCount;

    map.put("totalProcessingTime", totalProcessingTime);
    map.put("averageLatency", averageLatency);
    return map;
  }
}
