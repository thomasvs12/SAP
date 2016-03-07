package com.penninkhof.odata.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shoebox")
public class Shoebox {

	@Id
	long barcode;
	String email;
	String naam;

	public Shoebox() {}
	
	public Shoebox(long barcode, String email, String naam) {
		this.barcode = barcode;
		this.email = email;
		this.naam = naam;
	}
	
	public long getBarcode() {
		return barcode;
	}
	
	public void setBarcode(long barcode) {
		this.barcode = barcode;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNaam() {
		return naam;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
}
