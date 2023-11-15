package christmas.controller;

import christmas.constant.Menu;
import christmas.domain.Order;
import christmas.service.DiscountService;
import christmas.service.EventBadgeService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class ChristmasEventController {


  private Order order;

  public void init() {
    // 사용자로부터 입력 받기
    int visitDate = InputView.getExpectedVisitDate();

    Map<Menu, Integer> orderMenu = InputView.getOrderMenu();

    // 주문 객체 생성
    this.order = new Order(visitDate, orderMenu);
    int totalMenuPrice = order.calculateTotalPrice();

    // 날짜에 따른 할인을 적용하는 서비스 생성
    DiscountService discountService = new DiscountService(order.getReservationDate());

    OutputView.printEvent(order.getReservationDate());
    OutputView.showOrderMenu(order.getFoodItems());
    OutputView.printTotalOrderAmount(totalMenuPrice);
    OutputView.printFreeReward(order.calculateTotalPrice());
    OutputView.printBenefits();
    int totalDiscount = discountService.calculateDiacountcheck(order);
    OutputView.printTotalBenefitAmount(totalDiscount);
    if (discountService.isapplyChampagneDiscount(totalMenuPrice)){
      OutputView.printDiscountedAmount(totalMenuPrice - totalDiscount+ 25000);
    }
    else{
      OutputView.printDiscountedAmount(totalMenuPrice - totalDiscount);
    }
    OutputView.printEventBadge(EventBadgeService.determineEventBadge(totalDiscount));
  }
}
