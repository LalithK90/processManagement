package lk.custom_process_management.asset.user_details.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.asset.common_asset.model.FileInfo;
import lk.custom_process_management.asset.common_asset.model.enums.Gender;
import lk.custom_process_management.asset.common_asset.model.enums.LiveDead;
import lk.custom_process_management.asset.common_asset.model.enums.Title;
import lk.custom_process_management.asset.user_details.entity.enums.RelevantParty;
import lk.custom_process_management.asset.user_details_chandler.entity.UserDetailsChandler;
import lk.custom_process_management.asset.user_details_ship_agent.entity.UserDetailsShipAgent;
import lk.custom_process_management.util.audit.AuditEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "UserDetails" )
@ToString
public class UserDetails extends AuditEntity {

  @Size( min = 5, message = "Your name cannot be accepted" )
  private String name;

  @Column( nullable = false )
  private String number;

  @Size( min = 5, message = "At least 5 characters should be included calling name" )
  private String callingName;

  @Size( max = 12, min = 10, message = "NIC number is contained numbers between 9 and X/V or 12 " )
  @Column( unique = true )
  private String nic;

  @Size( max = 10, message = "Mobile number length should be contained 10 and 9" )
  private String mobileOne;

  private String mobileTwo;

  private String land;

  @Column( unique = true )
  private String email;

  @Column( unique = true )
  private String officeEmail;

  @Column( columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin NULL", length = 255 )
  private String address;

  @Enumerated( EnumType.STRING )
  private Title title;

  @Enumerated( EnumType.STRING )
  private Gender gender;

  @Enumerated( EnumType.STRING )
  private RelevantParty relevantParty;

  @Enumerated( EnumType.STRING )
  private LiveDead liveDead;

  @DateTimeFormat( pattern = "yyyy-MM-dd" )
  private LocalDate dateOfBirth;

  @OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private UserDetailsChandler userDetailsChandler;


  @OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private UserDetailsShipAgent userDetailsShipAgent;

  @Transient
  private MultipartFile file;

  @Transient
  private FileInfo fileInfo;

  @Transient
  private int relevantPartyId;

}
