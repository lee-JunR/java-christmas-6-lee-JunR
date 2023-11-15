package christmas.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("EventBadgeService 테스트")
public class EventBadgeServiceTest {

  @Test
  @DisplayName("산타 배지 확인")
  public void determineEventBadge_SantaBadge() {
    // Given
    int totalBenefitAmount = 25000;

    // When
    String badge = EventBadgeService.determineEventBadge(totalBenefitAmount);

    // Then
    assertEquals("산타", badge);
  }

  @Test
  @DisplayName("트리 배지 확인")
  public void determineEventBadge_TreeBadge() {
    // Given
    int totalBenefitAmount = 15000;

    // When
    String badge = EventBadgeService.determineEventBadge(totalBenefitAmount);

    // Then
    assertEquals("트리", badge);
  }

  @Test
  @DisplayName("별 배지 확인")
  public void determineEventBadge_StarBadge() {
    // Given
    int totalBenefitAmount = 7000;

    // When
    String badge = EventBadgeService.determineEventBadge(totalBenefitAmount);

    // Then
    assertEquals("별", badge);
  }

  @Test
  @DisplayName("이벤트 배지 없음 확인")
  public void determineEventBadge_NoBadge() {
    // Given
    int totalBenefitAmount = 3000;

    // When
    String badge = EventBadgeService.determineEventBadge(totalBenefitAmount);

    // Then
    assertEquals("없음", badge);
  }
}
