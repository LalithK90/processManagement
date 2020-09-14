package lk.customsProcessManagement.asset.employee.dao;


import lk.customsProcessManagement.asset.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository< Employee, Integer> {
    Employee findFirstByOrderByIdDesc();

    Employee findByNic(String nic);
}
