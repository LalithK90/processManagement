package lk.customs.processManagement.asset.chandlerLicense.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lk.customs.processManagement.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "Item" )
public class ChandlerLicense extends AuditEntity {
}
