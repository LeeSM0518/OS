package schedulingproject;

public class Process{

  private String name;
  private int arrivalTime;
  private int priority;
  private int burstTime;
  private int waitingTime;

  public Process(String name, int arrivalTime, int priority, int burstTime, int waitingTime) {
    this.name = name;
    this.arrivalTime = arrivalTime;
    this.priority = priority;
    this.burstTime = burstTime;
    this.waitingTime = waitingTime;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(int arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public int getBurstTime() {
    return burstTime;
  }

  public void setBurstTime(int burstTime) {
    this.burstTime = burstTime;
  }

  public int getWaitingTime() {
    return waitingTime;
  }

  public void setWaitingTime(int waitingTime) {
    this.waitingTime = waitingTime;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Process{");
    sb.append("name='").append(name).append('\'');
    sb.append(", arrivalTime=").append(arrivalTime);
    sb.append(", priority=").append(priority);
    sb.append(", burstTime=").append(burstTime)
    .append("}");
    return sb.toString();
  }

}
