package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import christmas.constant.Menu;
import java.util.HashMap;
import java.util.Map;

/**
 * InputView 클래스는 사용자로부터 입력을 받는 기능을 제공합니다.
 */
public class InputView {

  /**
   * 12월 중 식당 예상 방문 날짜를 입력받습니다.
   *
   * @return 사용자가 입력한 날짜
   */
  public static int getExpectedVisitDate() {
    while (true) {
      try {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!): ");
        String input = Console.readLine();
        return parseAndValidateVisitDate(input);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  /**
   * 주문하실 메뉴와 수량을 입력받습니다.
   *
   * @return 주문 메뉴와 수량을 담은 Map 객체
   */
  public static Map<Menu, Integer> getOrderMenu() {
    while (true) {
      try {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1): ");
        String orderInput = Console.readLine();
        return parseAndValidateOrderMenu(orderInput);
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private static int parseAndValidateVisitDate(String input) {
    try {
      int visitDate = Integer.parseInt(input);

      if (visitDate < 1 || visitDate > 31) {
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
      }
      return visitDate;
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
  }

  private static Map<Menu, Integer> parseAndValidateOrderMenu(String orderInput) {
    Map<Menu, Integer> orderMap = new HashMap<>();
    String[] orders = orderInput.split(",");

    for (String order : orders) {
      String[] menuAndQuantity = order.split("-");
      if (menuAndQuantity.length != 2) {
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
      }

      Menu menu = stringToMenu(menuAndQuantity[0].trim());

      // Try parsing quantity as an integer
      int quantity;
      try {
        quantity = Integer.parseInt(menuAndQuantity[1].trim());
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
      }

      if (quantity < 1) {
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
      }

      if (orderMap.containsKey(menu)) {
        throw new IllegalArgumentException("[ERROR] 중복 메뉴를 입력했습니다. 다시 입력해 주세요.");
      }

      orderMap.put(menu, quantity);
    }

    return orderMap;
  }
  private static Menu stringToMenu(String menuName) {
    for (Menu menu : Menu.values()) {
      if (menu.getName().equalsIgnoreCase(menuName)) {
        return menu;
      }
    }
    throw new IllegalArgumentException("[ERROR] 메뉴에 없는 주문입니다. 다시 입력해 주세요.");
  }
}