package christmas.domain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderTest {

  @Test
  void createOrderWithValidDate() {
    // Arrange
    Integer validDate = 15;
    Map<String, Integer> foodItems = new HashMap<>();
    foodItems.put("양송이수프", 2);
    foodItems.put("티본스테이크", 1);

    // Act
    Order order = new Order(validDate, foodItems);

    // Assert
    assertEquals(validDate, order.getReservationDate());
    assertEquals(foodItems, order.getFoodItems());
  }

  @Test
  @DisplayName("날짜가 31일을 초과하면 에러가 발생한다.")
  void createOrderWithInvalidDate() {
    // Arrange
    Integer invalidDate = 32;
    Map<String, Integer> foodItems = new HashMap<>();
    foodItems.put("양송이수프", 2);
    foodItems.put("티본스테이크", 1);

    // Act & Assert
    assertThrows(IllegalArgumentException.class, () -> new Order(invalidDate, foodItems));
  }
}
