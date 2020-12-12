package lk.custom_process_management.asset.vezzal_order_item_bid.model;

import lk.custom_process_management.asset.vezzal_order_item_bid.entity.VezzalOrderItemBid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VezzalOrderBid {
  @NotNull
  private int id;

  private List< VezzalOrderItemBid > vezzalOrderItemBids;

}
