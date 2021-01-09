package mapp.dao;

import java.time.LocalDate;
import java.util.Optional;
import mapp.dto.EnrolledUserDto;
import mapp.entity.EnrolledUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import mapp.entity.Appointment;
import mapp.entity.ImageUrl;
import mapp.entity.Ordering;
import mapp.entity.Role;
import org.springframework.data.jpa.repository.Modifying;

@Repository
public interface EnrolledUserDao extends JpaRepository<EnrolledUser, Integer> {

//    @Query("Select c FROM EnrolledUser c WHERE c.address LIKE CONCAT('%',:address,'%')")
//    public EnrolledUser findByAddress(@Param("address") String address);
//    @Query("SELECT u FROM EnrolledUser u WHERE u.username = :username")
//    public EnrolledUser getEnrolledUserByUsername(@Param("username") String email);
    public Optional<EnrolledUser> findByUsername(String username);

    @Query("SELECT new mapp.dto.EnrolledUserDto(e.id, e.username, e.fname, e.lname, e.imageUrl) FROM EnrolledUser e WHERE e.username = :username")
    public List<EnrolledUserDto> retrieveUsernameAsDTO(@Param("username") String username);

    // supports update operation 
    @Modifying
    @Query("update EnrolledUser e set e.username = ?1, e.password = ?2, e.fname = ?3, "
            + "e.lname = ?4, e.email = ?5, e.dateofbirth = ?6, e.postalcode = ?7, "
            + "e.address = ?8, e.city = ?9, e.municipality = ?10, e.telephone = ?11, "
            + "e.mobile = ?12 where e.id = ?13")
    void setEnrolledUserInfoById(
            String username, String password, String fname, String lname,
            String email, LocalDate dateofbirth, Integer postalcode, String address,
            String city, String municipality, String telephone, String mobile,
            Integer id
    );

}
