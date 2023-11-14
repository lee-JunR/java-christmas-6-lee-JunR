package christmas.constant;

public enum Calendar {

  // 2023년 12월의 달력
  DECEMBER_2023(new DayType[]{ DayType.WEEKEND, DayType.WEEKEND,
      DayType.SPECIAL, DayType.WEEKDAY, DayType.WEEKDAY, DayType.WEEKDAY, DayType.WEEKDAY, DayType.WEEKEND, DayType.WEEKEND,
      DayType.SPECIAL, DayType.WEEKDAY, DayType.WEEKDAY, DayType.WEEKDAY, DayType.WEEKDAY, DayType.WEEKEND, DayType.WEEKEND,
      DayType.SPECIAL, DayType.WEEKDAY, DayType.WEEKDAY, DayType.WEEKDAY, DayType.WEEKDAY, DayType.WEEKEND, DayType.WEEKEND,
      DayType.SPECIAL, DayType.SPECIAL, DayType.WEEKDAY, DayType.WEEKDAY, DayType.WEEKDAY, DayType.WEEKEND, DayType.WEEKEND,
      DayType.SPECIAL}, // 25일은 특별 할인 날
      new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
          24, 25, 26, 27, 28, 29, 30, 31}); // 날짜 배열

  private final DayType[] dayTypes; // 각 날짜의 요일 타입
  private final int[] days; // 날짜 배열

  Calendar(DayType[] dayTypes, int[] days) {
    this.dayTypes = dayTypes;
    this.days = days;
  }

  public DayType getDayType(int day) {
    return dayTypes[day - 1];
  }

  public static Calendar getDecember2023() {
    return DECEMBER_2023;
  }

  public enum DayType {
    WEEKDAY, // 주중
    WEEKEND, // 주말
    SPECIAL // 특별 할인 날
  }
}

