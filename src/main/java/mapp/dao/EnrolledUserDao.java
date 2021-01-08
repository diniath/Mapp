
package mapp.dao;

import java.util.Optional;
import mapp.dto.EnrolledUserDto;
import mapp.entity.EnrolledUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EnrolledUserDao extends JpaRepository<EnrolledUser, Integer>{

//    @Query("Select c FROM EnrolledUser c WHERE c.address LIKE CONCAT('%',:address,'%')")
//    public EnrolledUser findByAddress(@Param("address") String address);
    
//    @Query("SELECT u FROM EnrolledUser u WHERE u.username = :username")
//    public EnrolledUser getEnrolledUserByUsername(@Param("username") String email);

    public Optional<EnrolledUser> findByUsername(String username);
    
    @Query("SELECT new mapp.dto.EnrolledUserDto(e.id, e.username, e.fname, e.lname, e.imageUrl) FROM EnrolledUser e WHERE e.username = :username")
    public List<EnrolledUserDto> retrieveUsernameAsDTO(@Param("username") String username);
    
}
