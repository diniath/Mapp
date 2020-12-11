
package mapp.dao;

import mapp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyDao extends JpaRepository<Company, Integer>{

    @Query("Select c FROM Company c WHERE c.address LIKE CONCAT('%',:address,'%')")
    public Company findByAddress(@Param("address") String address);
    
}
