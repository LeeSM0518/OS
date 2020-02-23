package schedulingproject.scheduling;

import schedulingproject.Process;

import java.util.*;
import java.util.stream.Collectors;

public class FirstComeFirstServed extends Scheduling {

  @Override
  Map<String, Object> scheduleProcess(Queue<Process> processes) {
    Map<String, Object> map = new HashMap<>();
    Queue<Process> queue = new LinkedList<>(processes);
    int totalProcessingTime = queue.stream().mapToInt(Process::getBurstTime).sum();
    double averageLatency = 0;
    int processCount = queue.size();

    Process process;
    int time = 0;
    while (!queue.isEmpty()) {
      process = queue.poll();
      averageLatency += time - process.getArrivalTime();
      time += process.getBurstTime();
    }
    averageLatency /= processCount;

    map.put("totalProcessingTime", totalProcessingTime);
    map.put("averageLatency", averageLatency);
    return map;
  }

}
