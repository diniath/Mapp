package mapp.dao;

import java.util.Optional;
import mapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {
    
}
