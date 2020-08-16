package lk.customs.processManagement.asset.vezzal.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import lk.customs.processManagement.util.audit.AuditEntity;
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
@JsonFilter( "Customer" )
public class Vezzal extends AuditEntity {

    @Size( min = 5, message = "Your name cannot be accepted" )
    private String name;

    // ex. {yearLastTwo}{less than ten thousand}
    @Column( unique = true )
    private String code;

    //International Maritime Organization NUmber
    @Column( unique = true )
    private String imoNumber;

    //Maritime Mobile Service Identities
    @Column( unique = true )
    private String mmsiNumber;

    private String country;
}