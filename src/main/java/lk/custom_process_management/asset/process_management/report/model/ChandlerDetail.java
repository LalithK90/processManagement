package lk.custom_process_management.asset.process_management.report.model;

import lk.custom_process_management.asset.chandler.entity.Chandler;
import lk.custom_process_management.asset.item.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChandlerDetail {
private Chandler chandler;
private Long biddenCount;
private Long  approveCount;
private List< Item >  providedItems;
private BigDecimal totalAmount;
}
