package lk.customsProcessManagement.asset.item.entity;



import com.fasterxml.jackson.annotation.JsonFilter;
import lk.customsProcessManagement.asset.category.entity.Category;
import lk.customsProcessManagement.asset.item.entity.Enum.ItemStatus;
import lk.customsProcessManagement.asset.vezzalOrderItem.entity.VezzalOrderItem;
import lk.customsProcessManagement.util.audit.AuditEntity;
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

    @ManyToOne
    private Category category;

    @OneToMany( mappedBy = "item" )
    private List< VezzalOrderItem > vezzalOrderItems;

 /*   @OneToMany( mappedBy = "item" )
    private List< Ledger > ledgers;

    @OneToMany( mappedBy = "item" )
    private List< PurchaseOrderItem > purchaseOrderItems;*/
}
