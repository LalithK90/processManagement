package lk.custom_process_management.asset.vezzal_arrival_history.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.asset.ship_agent.entity.ShipAgent;
import lk.custom_process_management.asset.vezzal.entity.Vezzal;
import lk.custom_process_management.asset.vezzal_arrival_history.entity.enums.VezzalDepartureArrivalStatus;
import lk.custom_process_management.asset.vezzal_order.entity.VezzalOrder;
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
@JsonFilter( "VezzalArrivalHistory" )
public class VezzalArrivalHistory extends AuditEntity {

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
  private VezzalDepartureArrivalStatus vezzalDepartureArrivalStatus;

  @DateTimeFormat( iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime anchorageDateAndTime;

  @DateTimeFormat( pattern = "yyyy-MM-dd" )
  private LocalDate sailingDate;

  @ManyToOne
  private ShipAgent shipAgent;

  @ManyToOne
  private Vezzal vezzal;

  @OneToMany( mappedBy = "vezzalArrivalHistory" )
  private List< VezzalOrder > vezzalOrders;
}
