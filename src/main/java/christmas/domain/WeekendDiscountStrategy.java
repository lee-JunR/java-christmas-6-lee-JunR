package christmas.domain;

import christmas.constant.Menu;
import christmas.constant.Menu.FoodCategory;
import java.util.Map;

public class WeekendDiscountStrategy implements DiscountStrategy {

  private static final int WEEKEND_DISCOUNT_AMOUNT = 2023;

  /**
   * 주말 할인(금요일, 토요일): 메인 메뉴를 메뉴 1개당 2,023원 할인합니다.
   *
   * @param foodItems 메뉴 항목과 수량을 담은 맵.
   * @return 적용된 총 할인 금액.
   */
  @Override
  public int applyDiscount(Map<Menu, Integer> foodItems) {
    int mainMenuCount = 0;
    // 메인 메뉴의 개수 산출
    for (Menu key : foodItems.keySet()) {
      if (key.getCategory() == FoodCategory.MAIN) {
        mainMenuCount += foodItems.get(key);
      }
    }
    return mainMenuCount * WEEKEND_DISCOUNT_AMOUNT;
  }
}
