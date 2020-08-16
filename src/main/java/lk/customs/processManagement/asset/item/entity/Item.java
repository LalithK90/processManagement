package lk.customs.processManagement.asset.item.entity;


import J_N_Super_Pvt_Ltd.asset.PurchaseOrder.entity.PurchaseOrderItem;
import J_N_Super_Pvt_Ltd.asset.category.entity.Category;
import J_N_Super_Pvt_Ltd.asset.item.entity.Enum.ItemStatus;
import J_N_Super_Pvt_Ltd.asset.ledger.entity.Ledger;
import J_N_Super_Pvt_Ltd.asset.supplierItem.entity.SupplierItem;
import J_N_Super_Pvt_Ltd.util.audit.AuditEntity;
import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
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

    @NotEmpty
    private String rop;

    @Column( unique = true )
    private String code;

    @Column( nullable = false, precision = 10, scale = 2 )
    private BigDecimal sellPrice;

    @Enumerated( EnumType.STRING )
    private ItemStatus itemStatus;

    @ManyToOne
    private Category category;

    @OneToMany( mappedBy = "item" )
    private List< SupplierItem > supplierItems;

    @OneToMany( mappedBy = "item" )
    private List< Ledger > ledgers;

    @OneToMany( mappedBy = "item" )
    private List< PurchaseOrderItem > purchaseOrderItems;
}
