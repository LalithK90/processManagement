package lk.customsProcessManagement.asset.chandler.dao;



import lk.customsProcessManagement.asset.chandler.entity.Chandler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ChandlerDao extends JpaRepository< Chandler, Integer> {
    Chandler findFirstByOrderByIdDesc();
/*

    Supplier findByIdAndItemSupplierStatus(Integer supplierId, ItemSupplierStatus itemSupplierStatus);
*/
}
