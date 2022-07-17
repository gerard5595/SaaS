package com.saas.entity;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDate;


@Accessors(fluent = true, chain = true)
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue
    Long id;
 
    @Column(name = "MANUFACTURER_NAME")
    String manufacturerName; 
 
    @Column(name = "CAPITAL")
    Long capital;
 
    @Column(name = "RATE")
    double  rate;
    
    @Column(name = "RELEASE_DATE")
    LocalDate  releaseDate;
 
    public Manufacturer(String manufacturerName, Long capital, double rate, LocalDate releaseDate) {
		this.manufacturerName = manufacturerName;
		this.capital = capital;
		this.rate = rate;
		this.releaseDate = releaseDate;
	}
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getManufacturerName() {
        return manufacturerName;
    }
 
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
 
    public Long getCapital() {
        return capital;
    }
 
    public void setCapital(Long capital) {
        this.capital = capital;
    }
    
    public double getRate() {
        return rate;
    }
 
    public void setRate(double rate) {
        this.rate = rate;
    }
 
    public LocalDate getReleaseDate() {
        return releaseDate;
    }
 
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    @Override
   	public String toString() {
   		return "Product [id=" + id + ", manufacturerName=" + manufacturerName + ", capital=" + capital + ", rate=" + rate + 
   				 ", releaseDate=" + releaseDate +"]";  }
}
