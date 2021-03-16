package lk.custom_process_management.schedule;

import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lk.custom_process_management.asset.vessel_order.entity.enums.VesselOrderStatus;
import lk.custom_process_management.asset.vessel_order.service.VesselOrderService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableScheduling
public class VesselOrderSchedule {
  private final VesselOrderService vesselOrderService;

  public VesselOrderSchedule(VesselOrderService vesselOrderService) {
    this.vesselOrderService = vesselOrderService;
  }

  @Scheduled( cron = "0 0 0 * * *" )
  void fourthSchedule() {
    List< VesselOrder > vesselOrders = new ArrayList<>();
    vesselOrderService.findByVesselOrderStatus(VesselOrderStatus.PROCESSING)
        .stream()
        .filter(x -> x.getClosingDate().equals(LocalDate.now()))
        .collect(Collectors.toList())
        .forEach(x -> {
          x.setVesselOrderStatus(VesselOrderStatus.BIDEN);
          vesselOrders.add(x);
        });
    vesselOrderService.saveAll(vesselOrders);
  }


}
