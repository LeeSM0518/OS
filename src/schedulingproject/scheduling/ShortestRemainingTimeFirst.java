package schedulingproject.scheduling;

import schedulingproject.Process;

import java.util.*;

public class ShortestRemainingTimeFirst extends Scheduling {
  @Override
  Map<String, Object> scheduleProcess(Queue<Process> processes) throws CloneNotSupportedException {
    Map<String, Object> map = new HashMap<>();
    Queue<Process> queue = new LinkedList<>();
    cloneProcess(queue, processes);
    TreeSet<Process> treeSet = new TreeSet<>(((o1, o2) -> {
      if (o1.getBurstTime() < o2.getBurstTime()) return -1;
      else if (o1.getName().equals(o2.getName())) return 0;
      else return 1;
    }));

    int totalProcessingTime = queue.stream().mapToInt(Process::getBurstTime).sum();
    double averageLatency = 0;
    int processCount = processes.size();

    Process process = null;
    int time = 0;

    while (!treeSet.isEmpty() || !queue.isEmpty() || process != null) {
      System.out.println("Queue: " + treeSet);
      int finalTime = time;
      Process arrivalProcess =
          queue.stream().filter(pro -> pro.getArrivalTime() == finalTime).findFirst().orElse(null);
      if (arrivalProcess != null) {
        queue.remove(arrivalProcess);
        treeSet.add(arrivalProcess);
      }
      if (process == null) {
        process = treeSet.first();
      }
      if (!treeSet.isEmpty() && process != treeSet.first()) {
        process = treeSet.first();
      }
      if (process.getBurstTime() == 0) {
        treeSet.remove(process);
        if (treeSet.isEmpty() && queue.isEmpty()) break;
        process = treeSet.first();
      }
      process.setBurstTime(process.getBurstTime() - 1);
      Process finalProcess = process;
      averageLatency += treeSet.stream().filter(pro -> !pro.getName().equals(finalProcess.getName())).count();
      time++;
    }

    averageLatency = averageLatency / processCount;

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
