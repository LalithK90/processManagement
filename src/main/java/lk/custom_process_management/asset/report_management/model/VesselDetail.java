package lk.custom_process_management.asset.report_management.model;

import lk.custom_process_management.asset.vessel.entity.Vessel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VesselDetail {
private Vessel vessel;
private long arrivalCount;
}
