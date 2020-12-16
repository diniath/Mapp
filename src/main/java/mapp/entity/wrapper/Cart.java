/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapp.entity.wrapper;

import java.time.LocalDate;
import mapp.entity.Company;
import mapp.entity.Ordering;
import mapp.entity.Product;

/**
 *
 * @author Hello Java !
 */
public class Cart {

    private Ordering ordering;
    private Product product;
    private Company company;
    private short endDate;
    private short startDate;
    private LocalDate appointmentDate;

    public Cart() {
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public void setOrdering(Ordering ordering) {
        this.ordering = ordering;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public short getEndDate() {
        return endDate;
    }

    public void setEndDate(short endDate) {
        this.endDate = endDate;
    }

    public short getStartDate() {
        return startDate;
    }

    public void setStartDate(short startDate) {
        this.startDate = startDate;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
    
    
}
