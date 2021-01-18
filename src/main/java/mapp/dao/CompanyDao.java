
package mapp.dao;

import java.util.Optional;
import mapp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyDao extends JpaRepository<Company, Integer>{

    @Query("Select c FROM Company c WHERE c.address LIKE CONCAT('%',:address,'%')")
    public Company findByAddress(@Param("address") String address);
    
    // supports update operation 
    @Modifying
    @Query("update Company c set c.username = ?1, c.password = ?2, c.cname = ?3, "
            + "c.email = ?4, c.postalcode = ?5, c.address = ?6, c.city = ?7, "
            + "c.municipality = ?8, c.telephone = ?9, c.mobile = ?10, "
            + "c.vatnumber = ?11, c.vatservice = ?12, c.description = ?13, "
            + "c.representative = ?14, c.iban = ?15, c.rating = ?16, c.profile = ?17 "
            + "where c.id = ?18")
    void setCompanyInfoById(
            String username, String password, String cname, String email,
            Integer postalcode, String address, String city, String municipality, 
            String telephone, String mobile, String vatnumber, String vatservice,
            String description, String representative, String iban, Integer rating,
            String profile, 
            Integer id
    );

    public Optional<Company> findByUsername(String username);
    
}
