package christmas.service;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChristmasDiscountStrategyTest {

  @Test
  void applyDiscount() {
    // Given
    int today = 10;  // 현재 날짜를 설정합니다.
    ChristmasDiscountStrategy discountStrategy = new ChristmasDiscountStrategy(today);

    // When
    int discountAmount = discountStrategy.applyDiscount(null);  // 메뉴 항목과 수량은 테스트에서 사용하지 않습니다.

    // Then
    int expectedDiscount = (today * 100) + 1000;  // 예상되는 할인 금액을 계산합니다.
    assertEquals(expectedDiscount, discountAmount, "크리스마스 할인이 올바르게 계산되어야 합니다.");
  }

  @Test
  void applyDiscountAfterChristmas() {
    // Given
    int today = 26;  // 크리스마스 이후의 날짜를 설정합니다.
    ChristmasDiscountStrategy discountStrategy = new ChristmasDiscountStrategy(today);

    // When
    int discountAmount = discountStrategy.applyDiscount(null);  // 메뉴 항목과 수량은 테스트에서 사용하지 않습니다.

    // Then
    assertEquals(0, discountAmount);
  }
}
