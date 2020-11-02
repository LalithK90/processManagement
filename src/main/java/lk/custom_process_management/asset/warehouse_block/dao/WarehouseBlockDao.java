package lk.custom_process_management.asset.warehouse_block.dao;


import lk.custom_process_management.asset.warehouse_block.entity.WarehouseBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseBlockDao extends JpaRepository< WarehouseBlock, Integer> {
}