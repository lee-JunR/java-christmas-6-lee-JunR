package christmas.service;

import christmas.constant.Menu;
import christmas.domain.Order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountServiceTest {

  @Test
  @DisplayName("할인 적용: 최소 주문 금액 초과")
  void calculateDiacountcheck_withDiscount() {
    DiscountService discountService = new DiscountService(1);

    // 최소 주문 금액을 초과하는 주문 생성
    Map<Menu, Integer> foodItems = new HashMap<>();
    foodItems.put(Menu.MUSHROOM_SOUP, 5);
    Order order = new Order(1, foodItems);

    int totalDiscount = discountService.calculateDiacountcheck(order);

    // 최소 주문 금액을 초과하면 할인이 적용되어야 함
    assertEquals(1100, totalDiscount);
  }

  @Test
  @DisplayName("할인 미적용: 최소 주문 금액 미만")
  void calculateDiacountcheck_withoutDiscount() {
    DiscountService discountService = new DiscountService(1);

    // 최소 주문 금액 미만인 주문 생성
    Map<Menu, Integer> foodItems = new HashMap<>();
    foodItems.put(Menu.MUSHROOM_SOUP, 1);
    Order order = new Order(1, foodItems);

    int totalDiscount = discountService.calculateDiacountcheck(order);

    // 최소 주문 금액 미만이면 할인이 적용되지 않아야 함
    assertEquals(0, totalDiscount);
  }
}
