package com.saas.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Accessors(fluent = true, chain = true)
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Manufacturer")
public class Customer {
    @Id
    @GeneratedValue
    Long id;
 
    @Column(name = "CUSTOMER_NAME")
    String customerName; 
 
    @Column(name = "CAPITAL")
    int capital;
 
    @Column(name = "RATE")
    double  rate;
    
    @Column(name = "PURCHASE_DATE")
    LocalDate  purchaseDate;
 
    public Customer(String customerName, int capital, double rate, LocalDate purchaseDate) {
		this.customerName = customerName;
		this.capital = capital;
		this.rate = rate;
		this.purchaseDate = purchaseDate;
	}
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getCustomerName() {
        return customerName;
    }
 
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
 
    public int getCapital() {
        return capital;
    }
 
    public void setCapital(int capital) {
        this.capital = capital;
    }
    
    public double getRate() {
        return rate;
    }
 
    public void setRate(double rate) {
        this.rate = rate;
    }
 
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
 
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
    @Override
	public String toString() {
		return "Product [id=" + id + ", customerName=" + customerName + ", capital=" + capital + ", rate=" + rate + 
				 ", purchaseDate=" + purchaseDate +"]";  }
}