
package mapp.dao;

import mapp.entity.ImageUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageUrlDao extends JpaRepository<ImageUrl, Integer>{

//    @Query("Select c FROM ImageUrl c WHERE c.address LIKE CONCAT('%',:address,'%')")
//    public ImageUrl findByAddress(@Param("address") String address);
    
}
