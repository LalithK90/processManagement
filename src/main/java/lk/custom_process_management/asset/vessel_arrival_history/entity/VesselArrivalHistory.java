package lk.custom_process_management.asset.vessel_arrival_history.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.asset.ship_agent.entity.ShipAgent;
import lk.custom_process_management.asset.vessel.entity.Vessel;
import lk.custom_process_management.asset.vessel_arrival_history.entity.enums.VesselDepartureArrivalStatus;
import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lk.custom_process_management.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "VesselArrivalHistory" )
public class VesselArrivalHistory extends AuditEntity {

  private String captainName;

  private String cargoTonnage;

  private String anchorageTerminal;

  private String purposeOfVisit;

  private String numberOfCrewMembers;

  private String numberOfPassengers;

  private String onePreviousHarbourName;

  private String twoPreviousHarbourName;

  private String threePreviousHarbourName;

  @NotBlank
  private String nextHarbour;

  @Enumerated( EnumType.STRING )
  private VesselDepartureArrivalStatus vesselDepartureArrivalStatus;

  @DateTimeFormat( iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime anchorageDateAndTime;

  @DateTimeFormat( pattern = "yyyy-MM-dd" )
  private LocalDate sailingDate;

  @ManyToOne
  private ShipAgent shipAgent;

  @ManyToOne
  private Vessel vessel;

  @OneToMany( mappedBy = "vesselArrivalHistory" )
  private List< VesselOrder > vesselOrders;
}
