package schedulingproject;

import schedulingproject.scheduling.*;

import java.util.Arrays;

public enum Technique {

  FCFS("1", new FirstComeFirstServed()),
  SJF("2", new ShortestJob()),
  SRTF("3", new ShrtestRemainingTimeFirst()),
  NON_PREEMPTIVE_PRIORITY("4", new NonPreemptivePriority()),
  PREEMPTIVE_PRIORITY("5", new PreemptivePriority()),
  RR("6", new RoundRobing()),
  MQ("7", new MultilevelQueue()),
  MFQ("8", new MultilevelFeedbackQueue());

  String qualifier;
  Scheduling scheduling;

  Technique(String s, Scheduling scheduling) {
    qualifier = s;
    this.scheduling = scheduling;
  }

  public String getQualifier() {
    return qualifier;
  }

  public void setQualifier(String qualifier) {
    this.qualifier = qualifier;
  }

  public Scheduling getScheduling() {
    return scheduling;
  }

  public void setScheduling(Scheduling scheduling) {
    this.scheduling = scheduling;
  }

  public static Technique findByQualifier(String qualifier) {
    return Arrays.stream(Technique.values())
        .filter(technique -> technique.getQualifier().equals(qualifier))
        .findAny()
        .orElse(null);
  }

}
