
package mapp.dao;

import mapp.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubcategoryDao extends JpaRepository<Subcategory, Integer>{

//    @Query("Select c FROM Subcategory c WHERE c.address LIKE CONCAT('%',:address,'%')")
//    public Subcategory findByAddress(@Param("address") String address);
    
}
