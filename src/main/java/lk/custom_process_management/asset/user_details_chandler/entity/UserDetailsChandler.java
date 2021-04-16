package lk.custom_process_management.asset.user_details_chandler.entity;

import lk.custom_process_management.asset.chandler.entity.Chandler;
import lk.custom_process_management.asset.user_details.entity.UserDetails;
import lk.custom_process_management.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsChandler extends AuditEntity {

  @OneToOne
  @MapsId
  @JoinColumn(name = "user_details_id")
  private UserDetails userDetails;

  @ManyToOne
  private Chandler chandler;
}
