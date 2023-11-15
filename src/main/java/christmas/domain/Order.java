package christmas.domain;

import christmas.constant.Menu;
import java.util.Map;

public class Order {

  private Integer reservationDate;
  private Map<Menu, Integer> foodItems;  // 음식과 갯수를 매핑하는 맵

  /** Order : 예약 일자와 Map(Menu, 갯수) 를 가지고 있음.*/
  public Order(Integer reservationDate, Map<Menu, Integer> foodItems) {
    validateDate(reservationDate);
    this.reservationDate = reservationDate;
    this.foodItems = foodItems;
  }

  public Integer getReservationDate() {
    return reservationDate;
  }

  public Map<Menu, Integer> getFoodItems() {
    return foodItems;
  }

  private void validateDate(Integer reservationDate) {
    if (reservationDate < 1 || reservationDate > 31) {
      throw new IllegalArgumentException("날짜는 1부터 31까지의 자연수여야 합니다.");
    }
  }
  public int calculateTotalPrice() {
    int totalMenuPrice = 0;

    for (Map.Entry<Menu, Integer> entry : foodItems.entrySet()) {
      totalMenuPrice += entry.getKey().getPrice() * entry.getValue();
    }

    return totalMenuPrice;
  }


}