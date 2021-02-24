package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.entity.ImageUrl;
import mapp.service.ImageUrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imageUrl")
public class ImageUrlController {

    @Autowired
    private ImageUrlServiceImpl service;

    @GetMapping
    public List<ImageUrl> getImageUrls() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ImageUrl getImageUrlById(@PathVariable(value = "id") Integer imageUrlId) throws Exception {
        Optional<ImageUrl> optionalImageUrl = service.findById(imageUrlId);
        return optionalImageUrl.orElseThrow(() -> new Exception("ImageUrl not exists with id:" + imageUrlId));
    }

    @PostMapping
    public ImageUrl createImageUrl(@RequestBody ImageUrl imageUrl) {
        return service.create(imageUrl);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteImageUrlById(@PathVariable(value = "id") Integer imageUrlId) {
        service.delete(imageUrlId);
        return ResponseEntity.ok("ImageUrl deleted successfully, ID:" + imageUrlId);
    }

    @PutMapping("/{id}")
    public void updateImageUrl(@PathVariable(value = "id") Integer imageUrlId,
            @RequestBody ImageUrl newImageUrlDetails) throws Exception {
        Optional<ImageUrl> optionalImageUrl = service.findById(imageUrlId);
        optionalImageUrl.orElseThrow(() -> new Exception("ImageUrl not exists with id:" + imageUrlId));
        newImageUrlDetails.setId(imageUrlId);
        service.edit(newImageUrlDetails);
    }

}
