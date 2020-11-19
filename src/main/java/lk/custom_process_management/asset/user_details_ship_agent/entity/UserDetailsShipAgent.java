package lk.custom_process_management.asset.user_details_ship_agent.entity;

import lk.custom_process_management.asset.ship_agent.entity.ShipAgent;
import lk.custom_process_management.asset.user_details.entity.UserDetails;
import lk.custom_process_management.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsShipAgent extends AuditEntity {

  @OneToOne
  private UserDetails userDetails;

  @ManyToOne
  private ShipAgent shipAgent;
}
