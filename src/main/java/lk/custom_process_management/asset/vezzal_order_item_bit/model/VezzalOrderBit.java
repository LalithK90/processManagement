package lk.custom_process_management.asset.vezzal_order_item_bit.model;

import lk.custom_process_management.asset.vezzal_order_item_bit.entity.VezzalOrderItemBit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VezzalOrderBit {
  @NotNull
  private int id;

  private List< VezzalOrderItemBit > vezzalOrderItemBits;

}
