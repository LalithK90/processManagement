package lk.custom_process_management.asset.user_details.dao;


import lk.custom_process_management.asset.user_details.entity.UserDetails;
import lk.custom_process_management.asset.user_details.entity.UserDetailsFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsFilesDao extends JpaRepository< UserDetailsFiles, Integer > {
    List< UserDetailsFiles > findByUserDetails(UserDetails userDetails);

    UserDetailsFiles findByName(String filename);

    UserDetailsFiles findByNewName(String filename);

    UserDetailsFiles findByNewId(String filename);
}
