
package mapp.dao;

import mapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import mapp.entity.EnrolledUser;


@Repository
public interface RoleDao extends JpaRepository<Role, Integer>{

//    @Query("Select c FROM Role c WHERE c.address LIKE CONCAT('%',:address,'%')")
//    public Role findByAddress(@Param("address") String address);
    
//     public List<Role> findByEnrolledUserList_EnrolledUser(EnrolledUser enrolledUser);
}
