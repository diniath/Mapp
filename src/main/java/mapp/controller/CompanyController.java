/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.entity.Company;
import mapp.service.CompanyServiceImpl;
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

/**
 *
 * @company Hello Java !
 */
@RestController//@RestController = @Controller + @ResponseBody
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl service;

    
    @GetMapping
    public List<Company> getCompanies() {
        return service.findAll();
    }

    @GetMapping("/{myvariable}")
    public Company getCompanyById(@PathVariable(value = "myvariable") Integer companyId) throws Exception {
        Optional<Company> optionalCompany = service.findById(companyId);
        return optionalCompany.orElseThrow(() -> new Exception("Company not exists with id:" + companyId));
        //return optionalCompany.get();
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return service.create(company);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCompanyById(@PathVariable(value = "id") Integer companyId) {
        service.delete(companyId);
        return ResponseEntity.ok("Company deleted successfully, ID:" + companyId);
    }

    @PutMapping("/{id}")
    public void updateCompany(@PathVariable(value = "id") Integer companyId,
            @RequestBody Company newCompanyDetails) throws Exception {
        Optional<Company> optionalCompany = service.findById(companyId);
        Company companyToUpdate = optionalCompany.orElseThrow(() -> new Exception("Company not exists with id:" + companyId));
        
        companyToUpdate.setAddress(newCompanyDetails.getAddress());
        service.edit(companyToUpdate);
    }
    
    @GetMapping("/search/{address}")
    public Company getCompanyByAddress(@PathVariable(value = "address") String address){
        return service.findCompanyByAddress(address);
    }

}
