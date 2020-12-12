
package mapp.dao;

import mapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

//    @Query("Select c FROM Service c WHERE c.address LIKE CONCAT('%',:address,'%')")
//    public Service findByAddress(@Param("address") String address);
    
}
