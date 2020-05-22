package schedulingproject;

import schedulingproject.scheduling.Type;

public class MultiProcess extends Process {

  private Type type;

  public MultiProcess(String name, int arrivalTime, int priority, int burstTime, int waitingTime, Type type) {
    super(name, arrivalTime, priority, burstTime, waitingTime);
    this.type = type;
  }

  public MultiProcess(Process process, Type type) {
    super(process.getName(), process.getArrivalTime(), process.getPriority(),
        process.getBurstTime(), process.getWaitingTime());
    this.type = type;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("");
    sb.append(", type=").append(type);
    sb.append('}');
    return super.toString() + sb.toString();
  }
}
