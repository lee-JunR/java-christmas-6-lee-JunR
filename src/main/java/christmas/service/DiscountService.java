package christmas.service;

import christmas.constant.Calendar;
import christmas.constant.Calendar.DayType;
import christmas.domain.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscountService {

  private final Map<DayType, List<DiscountStrategy>> discountStrategies;

  public DiscountService(int today) {
    discountStrategies = new HashMap<>();
    initializeStrategies(today);
  }

  private void initializeStrategies(int today) {
    discountStrategies.put(DayType.WEEKDAY, List.of(new WeekdayDiscountStrategy(), new ChristmasDiscountStrategy(today)));
    discountStrategies.put(DayType.WEEKEND, List.of(new WeekendDiscountStrategy(), new ChristmasDiscountStrategy(today)));
    discountStrategies.put(DayType.SPECIAL_WEEKDAY, List.of(new WeekendDiscountStrategy(), new SpecialDayDiscountStrategy(), new ChristmasDiscountStrategy(today)));
  }

  /**
   * 할인 전략을 결정하고 주문에 해당 전략을 적용하여 할인 가격을 계산합니다.
   *
   * @param order 주문 객체
   * @return 적용된 할인 가격
   */
  public int calculateDiscount(Order order) {
    // 주문일자에 따라 할인 전략을 선택합니다.
    DayType dayType = getDayType(order.getReservationDate());
    List<DiscountStrategy> strategies = discountStrategies.get(dayType);

    // 선택된 할인 전략을 적용하여 할인 가격을 계산합니다.
    int totalDiscount = 0;
    for (DiscountStrategy strategy : strategies) {
      totalDiscount += strategy.applyDiscount(order.getFoodItems());
    }

    return totalDiscount;
  }

  /**
   * 주문 일자에 따라 해당 날짜 타입을 반환합니다.
   *
   * @param reservationDate 주문 일자
   * @return 날짜 타입
   */
  private DayType getDayType(Integer reservationDate) {
    return Calendar.getDecember2023().getDayType(reservationDate);
  }
}
