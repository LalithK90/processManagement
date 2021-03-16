package lk.custom_process_management.asset.payment.dao;


import lk.custom_process_management.asset.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao extends JpaRepository< Payment, Integer> {
  Payment findFirstByOrderByIdDesc();
}
