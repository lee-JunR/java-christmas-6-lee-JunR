package christmas.service;

public class EventBadgeService {

  private static final int SANTA_THRESHOLD = 20000;
  private static final int TREE_THRESHOLD = 10000;
  private static final int STAR_THRESHOLD = 5000;

  private static final String NO_BADGE = "없음";
  private static final String SANTA_BADGE = "산타";
  private static final String TREE_BADGE = "트리";
  private static final String STAR_BADGE = "별";

  /**
   * 총혜택 금액에 따라 이벤트 배지를 결정합니다.
   *
   * @param totalBenefitAmount 총혜택 금액
   * @return 이벤트 배지
   */
  public static String determineEventBadge(int totalBenefitAmount) {
    if (totalBenefitAmount >= SANTA_THRESHOLD) {
      return SANTA_BADGE;
    }
    if (totalBenefitAmount >= TREE_THRESHOLD && totalBenefitAmount < SANTA_THRESHOLD) {
      return TREE_BADGE;
    }
    if (totalBenefitAmount >= STAR_THRESHOLD && totalBenefitAmount < TREE_THRESHOLD) {
      return STAR_BADGE;
    }

    return NO_BADGE;
  }
}