package com.example.demo.modules.test.service;

import java.util.List;

import com.example.demo.modules.test.entity.City;
import com.example.demo.modules.test.entity.Country;

public interface TestService {

	List<City> getCities(int countryId);
	
	Country getCountry(int countryId);
	
	Country getCountryByName(String countryName);
}