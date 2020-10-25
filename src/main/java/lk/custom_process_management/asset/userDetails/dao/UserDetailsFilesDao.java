package lk.custom_process_management.asset.userDetails.dao;


import lk.custom_process_management.asset.userDetails.entity.UserDetails;
import lk.custom_process_management.asset.userDetails.entity.UserDetailsFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsFilesDao extends JpaRepository< UserDetailsFiles, Integer > {
    List< UserDetailsFiles > findByEmployeeOrderByIdDesc(UserDetails userDetails);

    UserDetailsFiles findByName(String filename);

    UserDetailsFiles findByNewName(String filename);

    UserDetailsFiles findByNewId(String filename);
}
