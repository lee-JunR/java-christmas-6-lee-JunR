package christmas.constant;

public enum Menu {

  // 애피타이저
  MUSHROOM_SOUP("양송이수프", 6000, FoodCategory.APPETIZER),
  TAPAS("타파스", 5500, FoodCategory.APPETIZER),
  CAESAR_SALAD("시저샐러드", 8000, FoodCategory.APPETIZER),

  // 메인
  T_BONE_STEAK("티본스테이크", 55000, FoodCategory.MAIN),
  BBQ_RIBS("바비큐립", 54000, FoodCategory.MAIN),
  SEAFOOD_PASTA("해산물파스타", 35000, FoodCategory.MAIN),
  CHRISTMAS_PASTA("크리스마스파스타", 25000, FoodCategory.MAIN),

  // 디저트
  CHOCO_CAKE("초코케이크", 15000, FoodCategory.DESSERT),
  ICE_CREAM("아이스크림", 5000, FoodCategory.DESSERT),

  // 음료
  ZERO_COLA("제로콜라", 3000, FoodCategory.BEVERAGE),
  RED_WINE("레드와인", 60000, FoodCategory.BEVERAGE),
  CHAMPAGNE("샴페인", 25000, FoodCategory.BEVERAGE);

  private final String name;
  private final int price;
  private final FoodCategory category;

  Menu(String name, int price, FoodCategory category) {
    this.name = name;
    this.price = price;
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }

  public FoodCategory getCategory() {
    return category;
  }

  public enum FoodCategory {
    APPETIZER,
    MAIN,
    DESSERT,
    BEVERAGE
  }
}
