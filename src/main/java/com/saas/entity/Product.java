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
public class Product {
    @Id
    @GeneratedValue
    Long id;
 
    @Column(name = "PRODUCT_NAME")
    String productName; 
 
    @Column(name = "PRICE")
    Long price;
 
    @Column(name = "RATE")
    double  rate;
    
    @Column(name = "PUBLISHED")
	private boolean published;
    
    @Column(name = "AUTHORIZED")
	private boolean authorized;
    
    @Column(name = "PURCHASE_DATE")
    LocalDate  purchaseDate;
    
    @Column(name = "RELEASE_DATE")
    LocalDate  releaseDate;
 
    public Product(String productName, Long price, double rate, boolean published, boolean authorized, LocalDate purchaseDate, LocalDate releaseDate) {
		this.productName = productName;
		this.price = price;
		this.rate = rate;
		this.published = published;
		this.authorized = authorized;
		this.purchaseDate = purchaseDate;
		this.releaseDate = releaseDate;
	}
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getProductName() {
        return productName;
    }
 
    public void setProductName(String productName) {
        this.productName = productName;
    }
 
    public Long getPrice() {
        return price;
    }
 
    public void setPrice(Long price) {
        this.price = price;
    }
    
    public double getRate() {
        return rate;
    }
 
    public void setRate(double rate) {
        this.rate = rate;
    }
    
    public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean isPublished) {
		this.published = isPublished;
	}
	
	public boolean isAuthorized() {
		return authorized;
	}
	public void setAuthorized(boolean isAuthorized) {
		this.authorized = isAuthorized;
	}
 
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
    
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
 
    public LocalDate getReleaseDate() {
        return  releaseDate;
    }
    
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    @Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + ", rate=" + rate + 
				", published=" + published + ", authorized=" + authorized + ", purchaseDate=" + purchaseDate + ", releaseDate=" + releaseDate +"]";
	}
}
