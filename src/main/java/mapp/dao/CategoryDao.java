
package mapp.dao;

import mapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>{

//    @Query("Select c FROM Category c WHERE c.address LIKE CONCAT('%',:address,'%')")
//    public Category findByAddress(@Param("address") String address);
    
}
