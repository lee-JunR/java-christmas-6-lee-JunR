package christmas.service;

import christmas.constant.Menu;
import christmas.constant.Menu.FoodCategory;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeekendDiscountStrategyTest {

  @Test
  void applyDiscount() {
    WeekendDiscountStrategy strategy = new WeekendDiscountStrategy();
    Map<Menu, Integer> foodItems = new HashMap<>();
    foodItems.put(Menu.CHRISTMAS_PASTA, 2);
    foodItems.put(Menu.CHOCO_CAKE, 1);
    foodItems.put(Menu.SEAFOOD_PASTA, 3);

    int discountAmount = strategy.applyDiscount(foodItems);

    // 메인 메뉴의 개수: 2 + 3 = 5
    // 할인 금액: 5 * 2023 = 10115
    assertEquals(10115, discountAmount);
  }
}
