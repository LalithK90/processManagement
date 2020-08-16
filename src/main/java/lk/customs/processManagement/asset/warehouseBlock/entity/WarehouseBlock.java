package lk.customs.processManagement.asset.warehouseBlock.entity;


import lk.customs.processManagement.asset.warehouseBlock.entity.Enum.WarehouseBlockStatus;
import lk.customs.processManagement.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseBlock extends AuditEntity {

    @Size( min = 5, message = "Your name cannot be accepted" )
    private String name;

    @NotEmpty
    private String area;

/*    @Enumerated( EnumType.STRING)
    private WarehouseBlockStatus warehouseBlockStatus;*/
}

