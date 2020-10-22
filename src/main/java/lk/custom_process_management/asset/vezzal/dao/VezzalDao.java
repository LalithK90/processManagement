package lk.custom_process_management.asset.vezzal.dao;


import lk.custom_process_management.asset.vezzal.entity.Vezzal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VezzalDao extends JpaRepository< Vezzal, Integer> {
    Vezzal findFirstByOrderByIdDesc();
}
