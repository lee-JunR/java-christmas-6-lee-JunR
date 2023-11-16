package christmas.domain;

import christmas.constant.Menu;

import java.util.Map;

public class Order {

  private static final int MAX_MENU_COUNT = 20;

  private Integer reservationDate;
  private Map<Menu, Integer> foodItems;  // 음식과 갯수를 매핑하는 맵

  /**
   * Order : 예약 일자와 Map(Menu, 갯수) 를 가지고 있음.
   */
  public Order(Integer reservationDate, Map<Menu, Integer> foodItems) {
    validateDate(reservationDate);
    validateOrderItems(foodItems);
    this.reservationDate = reservationDate;
    this.foodItems = foodItems;
  }

  public Integer getReservationDate() {
    return reservationDate;
  }

  public Map<Menu, Integer> getFoodItems() {
    return foodItems;
  }

  public void validateDate(Integer reservationDate) {
    try {
      if (reservationDate < 1 || reservationDate > 31) {
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
      }
    } catch (IllegalArgumentException e) {
      System.err.println("Validation Error: " + e.getMessage());
      // Handle the exception as needed, e.g., log it or throw a different exception
    }
  }

  private void validateOrderItems(Map<Menu, Integer> foodItems) {
    try {
      if (containsOnlyBeverages(foodItems)) {
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
      }

      if (totalMenuCount(foodItems) > MAX_MENU_COUNT) {
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
      }
    } catch (IllegalArgumentException e) {
      System.err.println("Validation Error: " + e.getMessage());
      // Handle the exception as needed, e.g., log it or throw a different exception
    }
  }


  private boolean containsOnlyBeverages(Map<Menu, Integer> foodItems) {
    return foodItems.keySet().stream().allMatch(menu -> menu.getCategory() == Menu.FoodCategory.BEVERAGE);
  }

  private int totalMenuCount(Map<Menu, Integer> foodItems) {
    return foodItems.values().stream().mapToInt(Integer::intValue).sum();
  }

  public int calculateTotalPrice() {
    int totalPrice = 0;

    for (Map.Entry<Menu, Integer> entry : foodItems.entrySet()) {
      totalPrice += entry.getKey().getPrice() * entry.getValue();
    }

    return totalPrice;
  }
}
