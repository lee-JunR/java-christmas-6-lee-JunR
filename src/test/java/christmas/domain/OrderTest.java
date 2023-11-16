package christmas.domain;

import christmas.constant.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

  @Test
  @DisplayName("생성된 주문의 예약 일자와 음식 주문 맵 확인")
  void testOrderCreation() {
    // 예약 일자와 음식 주문 맵 생성
    Integer reservationDate = 10;
    Map<Menu, Integer> foodItems = new HashMap<>();
    foodItems.put(Menu.T_BONE_STEAK, 2);
    foodItems.put(Menu.CHOCO_CAKE, 1);

    // 주문 생성
    Order order = new Order(reservationDate, foodItems);

    assertEquals(reservationDate, order.getReservationDate());
    assertEquals(foodItems, order.getFoodItems());
  }

}