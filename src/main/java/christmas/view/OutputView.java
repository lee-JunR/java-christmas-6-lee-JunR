package christmas.view;

import christmas.constant.Menu;
import java.util.List;
import java.util.Map;

public class OutputView {

  /**
   * 이벤트 안내 메시지를 출력합니다.
   */
  public static void printEvent() {
    System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
  }

  public static void showOrderMenu(Map<Menu, Integer> orderMenu) {
    System.out.println("<주문 메뉴>");
    for (Map.Entry<Menu, Integer> entry : orderMenu.entrySet()) {
      System.out.println(entry.getKey().getName() + " " + entry.getValue() + "개");
    }
  }
  /**
   * 할인 전 총 주문 금액을 출력합니다.
   *
   * @param totalOrderAmount 할인 전 총 주문 금액
   */
  public static void printTotalOrderAmount(int totalOrderAmount) {
    System.out.println("<할인 전 총주문 금액>");
    System.out.printf("%,d원\n", totalOrderAmount);
  }

  /**
   * 증정 메뉴를 출력합니다.
   *
   * @param freeItems 증정 메뉴 리스트
   */
  public static void printFreeItems(List<String> freeItems) {
    System.out.println("<증정 메뉴>");
    for (String freeItem : freeItems) {
      System.out.println(freeItem);
    }
  }

  /**
   * 혜택 내역을 출력합니다.
   *
   * @param benefits 혜택 내역 리스트
   */
  public static void printBenefits(List<String> benefits) {
    System.out.println("<혜택 내역>");
    for (String benefit : benefits) {
      System.out.println(benefit);
    }
  }

  /**
   * 총 혜택 금액을 출력합니다.
   *
   * @param totalBenefitAmount 총 혜택 금액
   */
  public static void printTotalBenefitAmount(int totalBenefitAmount) {
    System.out.println("<총혜택 금액>");
    System.out.printf("%,d원\n", totalBenefitAmount);
  }

  /**
   * 할인 후 예상 결제 금액을 출력합니다.
   *
   * @param discountedAmount 할인 후 예상 결제 금액
   */
  public static void printDiscountedAmount(int discountedAmount) {
    System.out.println("<할인 후 예상 결제 금액>");
    System.out.printf("%,d원\n", discountedAmount);
  }

  /**
   * 12월 이벤트 배지를 출력합니다.
   *
   * @param eventBadge 12월 이벤트 배지
   */
  public static void printEventBadge(String eventBadge) {
    System.out.println("<12월 이벤트 배지>");
    System.out.println(eventBadge);
  }
}
