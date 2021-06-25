package com.example.demo.services;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Country;
import com.example.demo.controllers.AddResponse;
import com.example.demo.repositories.CountryRepository;

@Component
@Service
public class CountryService {

	/*
	 * static HashMap<Integer, Country> countryIdMap;
	 * 
	 * public CountryService() { countryIdMap = new HashMap<Integer, Country>();
	 * 
	 * Country indiaCountry = new Country(1, "India", "New Delhi"); Country
	 * usaCountry = new Country(2, "USA", "Washington"); Country ukCountry = new
	 * Country(3, "UK", "London");
	 * 
	 * countryIdMap.put(1, indiaCountry); countryIdMap.put(2, usaCountry);
	 * countryIdMap.put(3, ukCountry); }
	 */
	@Autowired
	CountryRepository countryRepo;
	
	public List<Country> getAllCountries() {
//		List countries=new ArrayList(countryIdMap.values());
//		return countries;
		return countryRepo.findAll();
	}
	
	public Country getCountryById(int countryId){
//		Country country=countryIdMap.get(countryId);
//		return country;
		return countryRepo.findById(countryId).get();
	}
	
	public Country getCountryByName(String countryName) {
//		Country country=null;
//		for(int i:countryIdMap.keySet()) {
//			if(countryIdMap.get(i).getCountryName().equals(countryName))
//				country=countryIdMap.get(i);
//		}
//		return country;
		List<Country> countries = countryRepo.findAll();
		Country country=null;
		for (Country con : countries) {
			if(con.getCountryName().equalsIgnoreCase(countryName))
				country=con;
		}
		return country;
	}
	
	public Country addNewCountry(Country country) {
//		country.setCountryId(getMaxId());
//		countryIdMap.put(country.getCountryId(), country);
//		return country;
		country.setCountryId(getMaxId());
		countryRepo.save(country);
		return country;
	}
	
	public Country updateCountry(Country country) {
//		if(country.getCountryId()>0)
//			countryIdMap.put(country.getCountryId(), country);
//		return country;
		countryRepo.save(country);
		return country;
	}
	
	public AddResponse deleteCountry(int countryId) {
//		countryIdMap.remove(countryId);
//		AddResponse response=new AddResponse();
//		response.setMessage("Country Deleted...");
//		response.setCountryId(countryId);
//		return response;
		countryRepo.deleteById(countryId);
		AddResponse response=new AddResponse();
		response.setMessage("Country Deleted...");
		response.setCountryId(countryId);
		return response;
	}
	
//	Utility Method to get Max Id
	public int getMaxId() {
//		int max=0;
//		for(int id:countryIdMap.keySet()) {
//			if(max<=id)
//				max=id;
//		}
//		return max+1;
		return countryRepo.findAll().size()+1;
	}

}
