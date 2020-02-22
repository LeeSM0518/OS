package schedulingproject;

import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Consumer;

public class UserInterface {

  private Scanner scanner = new Scanner(System.in);

  public void initMenu(Consumer<Scanner> sc) {
    System.out.println("================================");
    System.out.println("CPU 스케줄링");
    sc.accept(scanner);
    System.out.println("================================");
  }

  public String selectProcessCount() {
    initMenu(sc -> {
      System.out.println("프로세스 개수를 입력해주세요.");
    });
    return scanner.nextLine();
  }

  public String mainMenu(Map<String, Object> map) {
    Queue<Process> queue = (Queue<Process>) map.get("queue");
    initMenu(sc -> {
      System.out.println("프로세스 정보");
      queue.forEach(process -> System.out.println(process.toString()));

      System.out.println("\n스케줄링을 선택해주세요.");
      System.out.println("1. 선입선처리 (비선점)");
      System.out.println("2. 최단 작업 우선 (비선점)");
      System.out.println("3. 최소 잔여시간 우선 (선점)");
      System.out.println("4. 우선 순위 (비선점)");
      System.out.println("5. 우선 순위 (선점)");
      System.out.println("6. 라운드 로빈 (비선점)");
      System.out.println("7. 다단계 큐");
      System.out.println("8. 다단계 피드백 큐");
      System.out.println("9. 이전으로");
      System.out.println("10. 종료하기");
    });
    return scanner.nextLine();
  }

  public void printSchedulingResult(Map<String, Object> map) {
    int totalProcessingTime = (int) map.get("totalProcessingTime");
    int averageLatency = (int) map.get("averageLatency");
    initMenu(sc -> {
      System.out.println("총 처리 시간: " + totalProcessingTime);
      System.out.println("평균 대기 시간: " + averageLatency);
    });
  }

}
