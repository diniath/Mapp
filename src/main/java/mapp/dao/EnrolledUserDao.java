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
import org.springframework.data.jpa.repository.Modifying;

@Repository
public interface EnrolledUserDao extends JpaRepository<EnrolledUser, Integer> {

    public Optional<EnrolledUser> findByUsername(String username);

    @Query("SELECT new mapp.dto.EnrolledUserDto(e.id, e.username, e.fname, e.lname, "
            + "e.email, e.dateofbirth, e.postalcode, e.address, e.city, "
            + "e.municipality, e.telephone, e.mobile, e.imageUrl) FROM EnrolledUser e "
            + "WHERE e.username = :username")
    public List<EnrolledUserDto> retrieveUsernameAsDTO(@Param("username") String username);

    // supports update operation 
    @Modifying
    @Query("update EnrolledUser e set e.username = ?1, e.fname = ?2, "
            + "e.lname = ?3, e.email = ?4, e.dateofbirth = ?5, e.postalcode = ?6, "
            + "e.address = ?7, e.city = ?8, e.municipality = ?9, e.telephone = ?10, "
            + "e.mobile = ?11 where e.id = ?12")
    void setEnrolledUserInfoById(
            String username, String fname, String lname,
            String email, LocalDate dateofbirth, Integer postalcode, String address,
            String city, String municipality, String telephone, String mobile,
            Integer id
    );

}
