package lk.custom_process_management.schedule;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

public class VezzalOrderStatusChange {
  //Number of milliseconds to delay before the first execution of a {@link #fixedRate()} or {@link #fixedDelay()} task.

  // fixed rate give value in milisecound
  @Scheduled( fixedRate = 1000 )
  void fristSchedule() {
    System.out.println(new Date().toString());

  }


  // fixed delay give value in milisecound

  @Scheduled( fixedDelay = 1000 )
  void secondSchedule() {
    System.out.println(new Date().toString());

  }

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
  @Scheduled( fixedDelay = 2000, initialDelay = 4000 )
  void thirdSchedule() {
    System.out.println(new Date().toString());

  }


  /*
   * An annotation that marks a method to be scheduled. Exactly one of
   * the {@link #cron()}, {@link #fixedDelay()}, or {@link #fixedRate()}
   * attributes must be specified.
   */
//  @Scheduled(cron ="{every second(*)},{every minute(*)}, {every hour(*)}, {every day(*)},{every month(*)},{every
//  year(?)}" )
  // above crone execute in every one second
  //@Scheduled(cron ="* * * * * ?")
  @Scheduled( cron = "20 08 17 * * ?" )
  // every day every month 5.08.20 pm will be execute
  void fourthSchedule() {
    System.out.println(new Date().toString());

  }

  @Scheduled( fixedRate = 1000 )
  void fiveSchedule() throws InterruptedException {
    Thread.sleep(1000);
    System.out.println(new Date().toString());

  }
}
