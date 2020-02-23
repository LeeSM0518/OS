package schedulingproject.scheduling;

import schedulingproject.Process;

import java.util.*;

public class ShortestJob extends Scheduling {
  @Override
  Map<String, Object> scheduleProcess(Queue<Process> processes) {
    Map<String, Object> map = new HashMap<>();
    TreeSet<Process> queue = new TreeSet<>((o1, o2) -> {
      if (o1.getBurstTime() < o2.getBurstTime()) return -1;
      else if (o1.getName().equals(o2.getName())) return 0;
      else return 1;
    });
    queue.addAll(processes);
    int totalProcessingTime = queue.stream().mapToInt(Process::getBurstTime).sum();
    double averageLatency = 0;
    int processCount = queue.size();

    Process process;
    int time = 0;
    while (!queue.isEmpty()) {
      int finalTime = time;
      process = queue.stream().filter(proc -> proc.getArrivalTime() <= finalTime).findFirst().get();
      String processName = process.getName();
      queue.removeIf(proc -> proc.getName().equals(processName));
      averageLatency += time - process.getArrivalTime();
      time += process.getBurstTime();
    }
    averageLatency /= processCount;

    map.put("totalProcessingTime", totalProcessingTime);
    map.put("averageLatency", averageLatency);
    return map;
  }
}
