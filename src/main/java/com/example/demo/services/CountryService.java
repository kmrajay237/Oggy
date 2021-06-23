package com.example.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.demo.beans.Country;
import com.example.demo.controllers.AddResponse;

public class CountryService {

	static HashMap<Integer, Country> countryIdMap;

	public CountryService() {
		countryIdMap = new HashMap<Integer, Country>();

		Country indiaCountry = new Country(1, "India", "New Delhi");
		Country usaCountry = new Country(2, "USA", "Washington");
		Country ukCountry = new Country(3, "UK", "London");

		countryIdMap.put(1, indiaCountry);
		countryIdMap.put(2, usaCountry);
		countryIdMap.put(3, ukCountry);
	}
	
	public List getAllCountries() {
		List countries=new ArrayList(countryIdMap.values());
		return countries;
	}
	
	public Country getCountryById(int countryId){
		Country country=countryIdMap.get(countryId);
		return country;
	}
	
	public Country getCountryByName(String countryName) {
		Country country=null;
		for(int i:countryIdMap.keySet()) {
			if(countryIdMap.get(i).getCountryName().equals(countryName))
				country=countryIdMap.get(i);
		}
		return country;
	}
	
	public Country addNewCountry(Country country) {
		country.setCountryId(getMaxId());
		countryIdMap.put(country.getCountryId(), country);
		return country;
	}
	
	public Country updateCountry(Country country) {
		if(country.getCountryId()>0)
			countryIdMap.put(country.getCountryId(), country);
		return country;
	}
	
	public AddResponse deleteCountry(int countryId) {
		countryIdMap.remove(countryId);
		AddResponse response=new AddResponse();
		response.setMessage("Country Deleted...");
		response.setCountryId(countryId);
		return response;
	}
	
//	Utility Method to get Max Id
	public static int getMaxId() {
		int max=0;
		for(int id:countryIdMap.keySet()) {
			if(max<=id)
				max=id;
		}
		return max+1;
	}

}
