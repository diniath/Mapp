package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.converter.ProductConverter;
import mapp.entity.Company;
import mapp.entity.Product;

import mapp.service.ProductServiceImpl;
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
import mapp.dto.ProductDto;
import mapp.entity.Subcategory;
import mapp.service.CompanyServiceImpl;
import mapp.service.SubcategoryServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl service;

    @Autowired
    private ProductConverter converter;

    @Autowired
    private CompanyServiceImpl compservice;

    @Autowired
    private SubcategoryServiceImpl subcservice;

    @GetMapping
    public List<Product> getProducts() {
        return service.findAll();
    }

    @GetMapping("/dto")
    public List<ProductDto> getCompaniesDto() {
        List<Product> findAll = service.findAll();
        return converter.entityToDto(findAll);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(value = "id") Integer productId) throws Exception {
        Optional<Product> optionalProduct = service.findById(productId);
        return optionalProduct.orElseThrow(() -> new Exception("Product not exists with id:" + productId));
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return service.create(product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProductById(@PathVariable(value = "id") Integer productId) {
        service.delete(productId);
        return ResponseEntity.ok("Product deleted successfully, ID:" + productId);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable(value = "id") Integer productId,
            @RequestBody Product newProductDetails) throws Exception {
        // retrieve product, company, subcategory ... 
        Optional<Product> optionalProduct = service.findById(productId);
        Optional<Company> optionalCompany = compservice.findById(optionalProduct.get().getCompany().getId());
        Optional<Subcategory> optionalSubcategory = subcservice.findById(optionalProduct.get().getSubcategory().getId());
        // exception handling ... 
        optionalProduct.orElseThrow(() -> new Exception("Product not exists with id:" + productId));
        Company companyToSet = optionalCompany.orElseThrow(() -> new Exception("Company not exists with id:" + productId));
        Subcategory subCategoryToSet = optionalSubcategory.orElseThrow(() -> new Exception("Subcategory not exists with id:" + productId));
        // set new product
        newProductDetails.setCompany(companyToSet);
        newProductDetails.setSubcategory(subCategoryToSet);
        newProductDetails.setId(productId);
        service.edit(newProductDetails);
    }

    @GetMapping("/search/subcategory/{id}")
    public List<Product> findBySubcategoryId(@PathVariable(value = "id") Integer id) {
        return service.findBySubcategoryId(id);
    }

    @GetMapping("/search/profile/{inputString}")
    public List<Product> findByProfile(@PathVariable(value = "inputString") String profile) {
        return service.findByProfile(profile);
    }
}
