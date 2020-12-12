
package mapp.service;

import java.util.List;
import java.util.Optional;
import mapp.dao.ImageUrlDao;
import mapp.entity.ImageUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ImageUrlServiceImpl{
    
    @Autowired
    private ImageUrlDao dao;
    
    public List<ImageUrl> findAll() {
        return dao.findAll();
    }
    
    public ImageUrl create(ImageUrl imageUrl) {
        ImageUrl comp = dao.save(imageUrl);
        return comp;
    }
    
    public void edit(ImageUrl imageUrl) {
        dao.saveAndFlush(imageUrl);
    }

    public void delete(int id) {
        dao.deleteById(id);
    }

    public Optional<ImageUrl> findById(int id) {
        Optional<ImageUrl> imageUrl = dao.findById(id);
        return imageUrl;
    }
    
//    public ImageUrl findImageUrlByAddress(@PathVariable(value = "address") String address){
//        return dao.findByAddress(address);
//    }
}
