package christmas.domain;

import java.util.Map;

public class Order {

  private Integer reservationDate;
  private Map<String, Integer> foodItems;  // 음식과 갯수를 매핑하는 맵

  public Order(Integer reservationDate, Map<String, Integer> foodItems) {
    validateDate(reservationDate);
    this.reservationDate = reservationDate;
    this.foodItems = foodItems;
  }

  public Integer getReservationDate() {
    return reservationDate;
  }

  public Map<String, Integer> getFoodItems() {
    return foodItems;
  }

  private void validateDate(Integer reservationDate) {
    if (reservationDate < 1 || reservationDate > 31) {
      throw new IllegalArgumentException("날짜는 1부터 31까지의 자연수여야 합니다.");
    }
  }
}