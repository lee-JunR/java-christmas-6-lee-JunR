package christmas.domain;

import christmas.constant.Menu;
import christmas.constant.Menu.FoodCategory;
import java.util.Map;

public class WeekdayDiscountStrategy implements DiscountStrategy {

  private static final int WEEKDAY_DISCOUNT_AMOUNT = 2023;

  /**
   * 평일 할인(일요일~목요일): 디저트 메뉴를 메뉴 1개당 2,023원 할인합니다.
   *
   * @param foodItems 메뉴 항목과 수량을 담은 맵.
   * @return 적용된 총 할인 금액.
   */
  @Override
  public int applyDiscount(Map<Menu, Integer> foodItems) {
    int DesertMenuCount = 0;
    // 디저트 메뉴의 개수 산출
    for (Menu key : foodItems.keySet()) {
      if (key.getCategory() == FoodCategory.DESSERT) {
        DesertMenuCount += foodItems.get(key);
      }
    }
    return DesertMenuCount * WEEKDAY_DISCOUNT_AMOUNT;
  }

}
