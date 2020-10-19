package lk.customsProcessManagement.asset.vezzalArrivalHistory.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import lk.customsProcessManagement.asset.shipAgent.entity.ShipAgent;
import lk.customsProcessManagement.asset.vezzal.entity.Vezzal;
import lk.customsProcessManagement.asset.vezzalArrivalHistory.entity.Enum.VezzalDepartureArrivalStatus;
import lk.customsProcessManagement.asset.vezzalOrder.entity.VezzalOrder;
import lk.customsProcessManagement.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
