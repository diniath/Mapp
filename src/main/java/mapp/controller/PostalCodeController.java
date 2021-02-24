package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.entity.PostalCode;
import mapp.service.PostalCodeServiceImpl;
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
@RequestMapping("/postalCode")
public class PostalCodeController {

    @Autowired
    private PostalCodeServiceImpl service;

    @GetMapping
    public List<PostalCode> getPostalCodes() {
        return service.findAll();
    }

    @GetMapping("/{myvariable}")
    public PostalCode getPostalCodeById(@PathVariable(value = "myvariable") Integer postalCodeId) throws Exception {
        Optional<PostalCode> optionalPostalCode = service.findById(postalCodeId);
        return optionalPostalCode.orElseThrow(() -> new Exception("PostalCode not exists with id:" + postalCodeId));
    }

    @PostMapping
    public PostalCode createPostalCode(@RequestBody PostalCode postalCode) {
        return service.create(postalCode);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePostalCodeById(@PathVariable(value = "id") Integer postalCodeId) {
        service.delete(postalCodeId);
        return ResponseEntity.ok("PostalCode deleted successfully, ID:" + postalCodeId);
    }

    @PutMapping("/{id}")
    public void updatePostalCode(@PathVariable(value = "id") Integer postalCodeId,
            @RequestBody PostalCode newPostalCodeDetails) throws Exception {
        Optional<PostalCode> optionalPostalCode = service.findById(postalCodeId);
        optionalPostalCode.orElseThrow(() -> new Exception("PostalCode not exists with id:" + postalCodeId));
        newPostalCodeDetails.setId(postalCodeId);
        service.edit(newPostalCodeDetails);
    }

}
