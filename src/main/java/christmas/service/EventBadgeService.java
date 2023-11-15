package christmas.service;

public class EventBadgeService {

  /**
   * 총혜택 금액에 따라 이벤트 배지를 결정합니다.
   *
   * @param totalBenefitAmount 총혜택 금액
   * @return 이벤트 배지
   */
  public static String determineEventBadge(int totalBenefitAmount) {
    String eventBadge = "없음";

    if (totalBenefitAmount >= 20000) {
      eventBadge = "산타";
    }
    if (totalBenefitAmount >= 10000 && totalBenefitAmount < 20000) {
      eventBadge = "트리";
    }
    if (totalBenefitAmount >= 5000 && totalBenefitAmount < 10000) {
      eventBadge = "별";
    }

    return eventBadge;
  }
}
