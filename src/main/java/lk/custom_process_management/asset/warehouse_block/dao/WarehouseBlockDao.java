package lk.custom_process_management.asset.warehouse_block.dao;


import lk.custom_process_management.asset.warehouse_block.entity.WarehouseBlock;
import lk.custom_process_management.asset.warehouse_block.entity.enums.WarehouseBlockStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WarehouseBlockDao extends JpaRepository< WarehouseBlock, Integer > {

  List< WarehouseBlock > findByWarehouseBlockStatus(WarehouseBlockStatus warehouseBlockStatus);
}