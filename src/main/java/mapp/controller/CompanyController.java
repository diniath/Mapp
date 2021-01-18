package mapp.controller;

import java.util.List;
import java.util.Optional;
import mapp.converter.CompanyConverter;
import mapp.converter.CompanySearchConverter;
import mapp.dto.CompanySearchDto;
import mapp.dto.CompanyDto;
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

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl service;

    @Autowired
    private CompanyConverter converter;

    @Autowired
    private CompanySearchConverter sconverter;

    @GetMapping("/search/dto")
    public List<CompanySearchDto> getCompaniesSearchDto() {
        List<Company> findAll = service.findAll();
        return sconverter.entityToDto(findAll);
    }

    @GetMapping("/dto")
    public List<CompanyDto> getCompaniesDto() {
        List<Company> findAll = service.findAll();
        return converter.entityToDto(findAll);
    }

    @GetMapping("/dto/{id}")
    public CompanyDto getCompanyDto(@PathVariable(value = "id") Integer companyId) {
        Company findById = service.findById(companyId).get();
        return converter.entityToDto(findById);
    }

    @GetMapping
    public List<Company> getCompanies() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable(value = "id") Integer companyId) throws Exception {
        Optional<Company> optionalCompany = service.findById(companyId);
        return optionalCompany.orElseThrow(() -> new Exception("Company not exists with id:" + companyId));
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return service.create(company);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCompanyById(@PathVariable(value = "id") Integer companyId) {
        service.delete(companyId);
        return ResponseEntity.ok("Company deleted successfully, ID:" + companyId);
    }

    @PutMapping("/dto/{id}")
    public void updateCompany(@PathVariable(value = "id") Integer companyId,
            @RequestBody Company newCompanyDetails) throws Exception {
        Optional<Company> optionalCompany = service.findById(companyId);
        optionalCompany.orElseThrow(() -> new Exception("Company not exists with id:" + companyId));
        newCompanyDetails.setId(companyId);
        service.edit(newCompanyDetails);
    }

    @GetMapping("/searchBy/{address}")
    public Company getCompanyByAddress(@PathVariable(value = "address") String address) {
        return service.findCompanyByAddress(address);
    }

        @GetMapping("/search/{username}")
    public CompanyDto findCompanyByUsername(@PathVariable(value = "username") String username) {
        return converter.entityToDto(service.findCompanyByUsername(username).get());
    }
    
}
