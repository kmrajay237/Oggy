package com.example.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Country")
public class Country {

	@Id
	@Column(name="countryId")
	int countryId;
	
	@Column(name="countryName")
	String countryName;
	
	@Column(name="countryCapital")
	String countryCapital;
	
	public Country() {}

	public Country(int countryId, String countryName, String countryCapital) {
		this.countryId = countryId;
		this.countryName = countryName;
		this.countryCapital = countryCapital;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCapital() {
		return countryCapital;
	}

	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}

}
