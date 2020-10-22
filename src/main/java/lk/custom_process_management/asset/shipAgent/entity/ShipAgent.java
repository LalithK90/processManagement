package lk.custom_process_management.asset.shipAgent.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "ShipAgent" )
public class ShipAgent extends AuditEntity {

    @Size( min = 5, message = "Your name cannot be accepted" )
    private String name;

    @Size(max = 12, min = 10, message = "NIC number is contained numbers between 9 and X/V or 12 ")
    @Column(unique = true)
    private String nic;

    @Column( unique = true )
    private String code;

    @Column(unique = true) //custom house agent
    private String chaNumber;

    @Size(max = 10, message = "Mobile number length should be contained 10 and 9")
    private String mobileOne;

    private String mobileTwo;

    private String land;

    @Column(unique = true)
    private String email;

    @Column(columnDefinition = "VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_bin NULL", length = 255)
    private String address;

//    @OneToMany(mappedBy = "shipAgent")
//    private List< VezzalOrder > vezzalOrders;
}
