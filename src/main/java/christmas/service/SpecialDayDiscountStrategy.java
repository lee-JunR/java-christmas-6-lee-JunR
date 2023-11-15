package christmas.service;

import christmas.constant.Menu;
import christmas.service.DiscountStrategy;
import java.util.Map;

public class SpecialDayDiscountStrategy implements DiscountStrategy {

  private static final int SPECIALDAY_DISCOUNT_AMOUNT = 1000;

  /**
   * 특별 할인: 이벤트 달력에 별이 있으면 주문 금액에서 1,000원 할인 (이벤트 달력에 별이 있는지 판단은 Service에서 적용.)
   *
   * @param foodItems 메뉴 항목과 수량을 담은 맵.
   * @return 적용된 총 할인 금액.
   */
  @Override
  public int applyDiscount(Map<Menu, Integer> foodItems) {
    return SPECIALDAY_DISCOUNT_AMOUNT;
  }
}
