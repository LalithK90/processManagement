package lk.custom_process_management.asset.report_management.model;

import lk.custom_process_management.asset.payment.entity.Payment;
import lk.custom_process_management.asset.vessel_order.entity.VesselOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VesselOrderDetail {
private VesselOrder vesselOrder;
private List< Payment > payments;
}
