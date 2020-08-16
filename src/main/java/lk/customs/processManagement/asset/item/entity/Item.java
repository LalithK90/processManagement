package lk.customs.processManagement.asset.item.entity;



import com.fasterxml.jackson.annotation.JsonFilter;
import lk.customs.processManagement.asset.category.entity.Category;
import lk.customs.processManagement.asset.item.entity.Enum.ItemStatus;
import lk.customs.processManagement.util.audit.AuditEntity;
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

    @Column( unique = true )
    private String code;

    @Enumerated( EnumType.STRING )
    private ItemStatus itemStatus;

    @ManyToOne
    private Category category;

    /*@OneToMany( mappedBy = "item" )
    private List< SupplierItem > supplierItems;

    @OneToMany( mappedBy = "item" )
    private List< Ledger > ledgers;

    @OneToMany( mappedBy = "item" )
    private List< PurchaseOrderItem > purchaseOrderItems;*/
}
