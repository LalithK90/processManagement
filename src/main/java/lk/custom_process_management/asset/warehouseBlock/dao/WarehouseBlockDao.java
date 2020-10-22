package lk.custom_process_management.asset.warehouseBlock.dao;


import lk.custom_process_management.asset.warehouseBlock.entity.WarehouseBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseBlockDao extends JpaRepository< WarehouseBlock, Integer> {
}