package lk.custom_process_management.asset.vessel.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.asset.common_asset.model.enums.LiveDead;
import lk.custom_process_management.asset.vessel_arrival_history.entity.VesselArrivalHistory;
import lk.custom_process_management.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "Vessel" )
public class Vessel extends AuditEntity {

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

    @Enumerated( EnumType.STRING )
    private LiveDead liveDead;

    @OneToMany(mappedBy = "vessel")
    private List< VesselArrivalHistory > vesselArrivalHistories;
}
