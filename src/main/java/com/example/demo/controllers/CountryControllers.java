package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Country;
import com.example.demo.services.CountryService;

@RestController
public class CountryControllers {
	
	@Autowired
	CountryService countryService;
	
	@GetMapping("/getcountries")
	public List getCountries(){
		return countryService.getAllCountries();
	}
	
	@GetMapping("/getcountries/{id}")
	public Country getCountryById(@PathVariable(value="id") int id){
		return countryService.getCountryById(id);
	}
	
	@GetMapping("/getcountries/countryname")
	public Country getCountryByName(@RequestParam(value="name") String countryName){
		return countryService.getCountryByName(countryName);
	}
	
	@PostMapping("/addcountry")
	public Country addCountry(@RequestBody Country country) {
		return countryService.addNewCountry(country);
	}
	
	@PutMapping("/updatecountry")
	public Country updateCountry(@RequestBody Country country) {
		return countryService.updateCountry(country);
	}
	
	@DeleteMapping("/deletecountry/{id}")
	public AddResponse deleteCountry(@PathVariable(value="id") int id) {
		return countryService.deleteCountry(id);
	}

}
