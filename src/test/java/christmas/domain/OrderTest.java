package christmas.domain;

import christmas.constant.Menu;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

  @Test
  void testOrderCreation() {
    // 예약 일자와 음식 주문 맵 생성
    Integer reservationDate = 10;
    Map<Menu, Integer> foodItems = new HashMap<>();
    foodItems.put(Menu.T_BONE_STEAK, 2);
    foodItems.put(Menu.CHOCO_CAKE, 1);

    // 주문 생성
    Order order = new Order(reservationDate, foodItems);

    // 생성된 주문의 예약 일자와 음식 주문 맵 확인
    assertEquals(reservationDate, order.getReservationDate());
    assertEquals(foodItems, order.getFoodItems());
  }

  @Test
  void testInvalidReservationDate() {
    // 잘못된 예약 일자로 주문 생성 시 예외 발생 확인
    Integer invalidReservationDate = 40;
    Map<Menu, Integer> foodItems = new HashMap<>();
    foodItems.put(Menu.T_BONE_STEAK, 2);

    assertThrows(IllegalArgumentException.class, () -> new Order(invalidReservationDate, foodItems));
  }
}