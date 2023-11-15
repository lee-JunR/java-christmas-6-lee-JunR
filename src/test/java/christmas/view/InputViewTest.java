package christmas.view;

import christmas.constant.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputViewTest {

  @Test
  @DisplayName("12월 중 식당 예상 방문 날짜 입력 테스트")
  void getExpectedVisitDateTest() {
    // Arrange
    String input = "15\n";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    // Act
    int result = InputView.getExpectedVisitDate();

    // Assert
    assertEquals(15, result);
  }

  @Test
  @DisplayName("주문 메뉴 입력 테스트")
  void getOrderMenuTest() {
    // Arrange
    String input = "해산물파스타-2,레드와인-1,초코케이크-1\n";
    InputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    // Act
    Map<Menu, Integer> result = InputView.getOrderMenu();

    // Assert
    assertEquals(3, result.size());
    assertEquals(2, result.get(Menu.SEAFOOD_PASTA));
    assertEquals(1, result.get(Menu.RED_WINE));
    assertEquals(1, result.get(Menu.CHOCO_CAKE));
  }
}
