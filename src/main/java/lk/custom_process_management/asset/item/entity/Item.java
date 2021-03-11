package lk.custom_process_management.asset.item.entity;



import com.fasterxml.jackson.annotation.JsonFilter;
import lk.custom_process_management.asset.category.entity.Category;
import lk.custom_process_management.asset.common_asset.model.enums.LiveDead;
import lk.custom_process_management.asset.item.entity.enums.ItemStatus;
import lk.custom_process_management.asset.vessel_order_item.entity.VesselOrderItem;
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
@JsonFilter( "Item" )
public class Item extends AuditEntity {

    @Size( min = 5, message = "Your name cannot be accepted" )
    private String name;

    @Column( unique = true )
    private String code;

    @Enumerated( EnumType.STRING )
    private ItemStatus itemStatus;

    @Enumerated( EnumType.STRING )
    private LiveDead liveDead;

    @ManyToOne
    private Category category;

    @OneToMany( mappedBy = "item" )
    private List< VesselOrderItem > vesselOrderItems;

}
