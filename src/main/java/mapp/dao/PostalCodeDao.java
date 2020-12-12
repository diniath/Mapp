package mapp.dao;


import mapp.entity.PostalCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostalCodeDao extends JpaRepository<PostalCode, Integer>{

//    @Query("Select c FROM Company c WHERE c.address LIKE CONCAT('%',:address,'%')")
//    public Company findByAddress(@Param("address") String address);
    
}