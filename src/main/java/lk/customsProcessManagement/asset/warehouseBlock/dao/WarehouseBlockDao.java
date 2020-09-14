package lk.customsProcessManagement.asset.warehouseBlock.dao;


import lk.customsProcessManagement.asset.warehouseBlock.entity.WarehouseBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseBlockDao extends JpaRepository< WarehouseBlock, Integer> {
}