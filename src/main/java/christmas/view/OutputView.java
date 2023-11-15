package christmas.view;

import christmas.constant.Menu;
import java.util.Map;

public class OutputView {

  /**
   * 이벤트 안내 메시지를 출력합니다.
   */
  public static void printEvent(int reservationDate) {
    System.out.printf("\n12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n", reservationDate);
  }

  public static void showOrderMenu(Map<Menu, Integer> orderMenu) {
    System.out.println("\n<주문 메뉴>");
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
    System.out.println("\n<할인 전 총주문 금액>");
    System.out.printf("%,d원\n", totalOrderAmount);
  }

  /**
   * 증정 메뉴를 출력합니다.
   *
   * @param freeItems 증정 메뉴 리스트
   */
  public static void printFreeReward(int totalPrice) {
    System.out.println("\n<증정 메뉴>");
    System.out.println(checkFreeReward(totalPrice));
  }

  private static String checkFreeReward(int totalPrice) {
    if (totalPrice >= 120_000) {
      return "샴페인 1개";
    }
    return "없음";
  }

  /**
   * 혜택 내역을 출력합니다.
   *
   * @param benefits 혜택 내역 리스트
   */
  public static void printBenefits() {
    System.out.println("\n<혜택 내역>");
  }

  /**
   * 총 혜택 금액을 출력합니다.
   *
   * @param totalBenefitAmount 총 혜택 금액
   */
  public static void printTotalBenefitAmount(int totalBenefitAmount) {
    System.out.println("\n<총혜택 금액>");
    System.out.printf("-%,d원\n", totalBenefitAmount);
  }

  /**
   * 할인 후 예상 결제 금액을 출력합니다.
   *
   * @param discountedAmount 할인 후 예상 결제 금액
   */
  public static void printDiscountedAmount(int discountedAmount) {
    System.out.println("\n<할인 후 예상 결제 금액>");
    System.out.printf("%,d원\n", discountedAmount);
  }

  /**
   * 12월 이벤트 배지를 출력합니다.
   *
   * @param eventBadge 12월 이벤트 배지
   */
  public static void printEventBadge(String eventBadge) {
    System.out.println("\n<12월 이벤트 배지>");
    System.out.println(eventBadge);
  }
}
