package lk.custom_process_management.schedule;

import lk.custom_process_management.asset.vezzal_order.entity.VezzalOrder;
import lk.custom_process_management.asset.vezzal_order.entity.enums.VezzalOrderStatus;
import lk.custom_process_management.asset.vezzal_order.service.VezzalOrderService;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VezzalOrderSchedule {
  private final VezzalOrderService vezzalOrderService;

  public VezzalOrderSchedule(VezzalOrderService vezzalOrderService) {
    this.vezzalOrderService = vezzalOrderService;
  }

  @Scheduled( cron = "0 1 0 * * *" )
  void fourthSchedule() {
    List< VezzalOrder > vezzalOrders = new ArrayList<>();
    vezzalOrderService.findByVezzalOrderStatusAndClosingDateBefore(VezzalOrderStatus.PROCESSING, LocalDate.now())
        .forEach(x -> {
          x.setVezzalOrderStatus(VezzalOrderStatus.INVALID);
          vezzalOrders.add(x);
        });
    vezzalOrderService.saveAll(vezzalOrders);
  }

  //Number of milliseconds to delay before the first execution of a {@link #fixedRate()} or {@link #fixedDelay()} task.

  // fixed rate give value in milisecound
//  @Scheduled( fixedRate = 1000 )
//  void fristSchedule() {
//    System.out.println(new Date().toString());
//
//  }


  // fixed delay give value in milisecound

//  @Scheduled( fixedDelay = 1000 )
//  void secondSchedule() {
//    System.out.println(new Date().toString());
//
//  }

// deference delay and fixed rate
  //execute as specific interval even though previous execution also running
  //but delay
  // after complete the previous execution and wait given time duration and execute again


  /*     * Number of milliseconds to delay before the first execution of a
   * {@link #fixedRate()} or {@link #fixedDelay()} task.
   * @return the initial delay in milliseconds as a String value, e.g. a placeholder
   * or a {@link java.time.Duration#parse java.time.Duration} compliant value
   * @since 3.2.2
   */
//  @Scheduled( fixedDelay = 2000, initialDelay = 4000 )
//  void thirdSchedule() {
//    System.out.println(new Date().toString());
//
//  }


  /*
   * An annotation that marks a method to be scheduled. Exactly one of
   * the {@link #cron()}, {@link #fixedDelay()}, or {@link #fixedRate()}
   * attributes must be specified.
   */
//  @Scheduled(cron ="{every second(*)},{every minute(*)}, {every hour(*)}, {every day(*)},{every month(*)},{every
//  year(?)}" )
  // above crone execute in every one second
  //@Scheduled(cron ="* * * * * ?")
  //@Scheduled( cron = "20 08 17 * * ?" )  // every day every month 5.08.20 pm will be execute
//  void fourthSchedule() {
//    System.out.println(new Date().toString());
//
//  }

//  @Scheduled( fixedRate = 1000 )
//  void fiveSchedule() throws InterruptedException {
//    Thread.sleep(1000);
//    System.out.println(new Date().toString());
//
//  }

  /*
   # At 12:00 pm (noon) every day:- @Schedule(0 12 * * ?)

   # Every 5 minutes starting at 1 pm and ending on 1:55 pm and then starting at 6 pm and ending at 6:55 pm, every
   day:- @Schedule(0/5 13,18 * * ?)

   # Every minute starting at 1 pm and ending on 1:05 pm, every day:- @Schedule(0-5 13 * * ?)

   # At 1:15 pm and 1:45 pm every Tuesday in the month of June:- @Schedule(15,45 13 ? 6 Tue)

   # At 9:30 am every Monday, Tuesday, Wednesday, Thursday, and Friday:- @Schedule(30 9 ? * MON-FRI)

   # At 9:30 am on 15th day of every month:- @Schedule(30 9 15 * ?)

   # At 6 pm on the last day of every month:- @Schedule(0 18 L * ?)

   # At 6 pm on the 3rd to last day of every month:- @Schedule(0 18 L-3 * ?)

   # At 10:30 am on the last Thursday of every month:- @Schedule(30 10 ? * 5L)

   # At 10 am on the third Monday of every month:- @Schedule(0 10 ? * 2#3)

   # At 12 am midnight on every day for five days starting on the 10th day of the month:- @Schedule(0 0 10/5 * ?)


   */
}
