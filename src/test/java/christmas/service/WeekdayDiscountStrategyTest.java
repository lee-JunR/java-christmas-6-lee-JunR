package christmas.service;

import christmas.constant.Menu;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeekdayDiscountStrategyTest {

  @Test
  void applyDiscount() {
    WeekdayDiscountStrategy strategy = new WeekdayDiscountStrategy();
    Map<Menu, Integer> foodItems = new HashMap<>();
    foodItems.put(Menu.CHOCO_CAKE, 2);
    foodItems.put(Menu.SEAFOOD_PASTA, 1);
    foodItems.put(Menu.ICE_CREAM, 3);

    int discountAmount = strategy.applyDiscount(foodItems);

    // 디저트 메뉴의 개수: 2 + 3 = 5
    // 할인 금액: 5 * 2023 = 10115
    assertEquals(10115, discountAmount);
  }
}
