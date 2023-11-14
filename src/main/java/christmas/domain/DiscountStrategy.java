package christmas.domain;

import christmas.constant.Menu;
import java.util.Map;

public interface DiscountStrategy {

  /**
   * 메뉴 항목의 주문 수량에 따라 할인을 적용합니다.
   *
   * @param foodItems 메뉴 항목과 수량을 담은 맵.
   * @return 적용된 총 할인 금액.
   */
  int applyDiscount(Map<Menu, Integer> foodItems);
}
