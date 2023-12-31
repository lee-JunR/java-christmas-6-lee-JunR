package christmas.service;

import christmas.constant.Menu;
import java.util.Map;

public class ChristmasDiscountStrategy implements DiscountStrategy {

  private static final int CHRISTMAS_DAY = 25;
  private static final int INITIAL_DISCOUNT_AMOUNT = 1000;
  private static final int DAILY_DISCOUNT_INCREASE = 100;

  private final int today;

  public ChristmasDiscountStrategy(int today) {
    this.today = validate(today);
  }

  /**
   * 크리스마스 D-day 할인(2023.12.1 ~ 2023.12.25): 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
   *
   * @param foodItems 메뉴 항목과 수량을 담은 맵.
   * @return 적용된 총 할인 금액.
   */
  @Override
  public int applyDiscount(Map<Menu, Integer> foodItems) {
    if (today == 0) {
      System.out.println("크리스마스 이후로는 할인이 적용되지 않습니다.");
      return 0;
    }

    int discountPrice = (today * DAILY_DISCOUNT_INCREASE) + INITIAL_DISCOUNT_AMOUNT;
    System.out.printf("크리스마스 디데이 할인: -%d원\n", discountPrice);
    return discountPrice;
  }

  private int validate(int today) {
    if (today > CHRISTMAS_DAY) {
      return 0;
    }
    return today;
  }
}
