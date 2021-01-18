package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.entity.Subcategory;
import mapp.service.SubcategoryServiceImpl;
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
@RequestMapping("/subcategory")
public class SubcategoryController {

    @Autowired
    private SubcategoryServiceImpl service;

    @GetMapping
    public List<Subcategory> getSubcategorys() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Subcategory getSubcategoryById(@PathVariable(value = "id") Integer subcategoryId) throws Exception {
        Optional<Subcategory> optionalSubcategory = service.findById(subcategoryId);
        return optionalSubcategory.orElseThrow(() -> new Exception("Subcategory not exists with id:" + subcategoryId));
    }

    @PostMapping
    public Subcategory createSubcategory(@RequestBody Subcategory subcategory) {
        return service.create(subcategory);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSubcategoryById(@PathVariable(value = "id") Integer subcategoryId) {
        service.delete(subcategoryId);
        return ResponseEntity.ok("Subcategory deleted successfully, ID:" + subcategoryId);
    }

    @PutMapping("/{id}")
    public void updateSubcategory(@PathVariable(value = "id") Integer subcategoryId,
            @RequestBody Subcategory newSubcategoryDetails) throws Exception {
        Optional<Subcategory> optionalSubcategory = service.findById(subcategoryId);
        optionalSubcategory.orElseThrow(() -> new Exception("Subcategory not exists with id:" + subcategoryId));
        newSubcategoryDetails.setId(subcategoryId);
        service.edit(newSubcategoryDetails);
    }

}
