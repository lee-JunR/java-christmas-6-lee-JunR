package christmas.service;

import christmas.constant.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpecialDayDiscountStrategyTest {

  @Test
  @DisplayName("특별 할인이 올바르게 적용되는지 확인")
  void applyDiscount() {
    // Given
    SpecialDayDiscountStrategy specialDayDiscountStrategy = new SpecialDayDiscountStrategy();
    Map<Menu, Integer> foodItems = Collections.emptyMap();

    // When
    int discountAmount = specialDayDiscountStrategy.applyDiscount(foodItems);

    // Then
    assertEquals(1000, discountAmount, "특별 할인이 올바르게 적용되지 않았습니다.");
  }
}
