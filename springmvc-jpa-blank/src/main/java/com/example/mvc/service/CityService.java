package com.example.mvc.service;


import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.example.mvc.entity.City;

public interface CityService {

	Page<City> findAll(int page, int size);
	
	List<City> findAllList();

	City findByCityId(Integer id);

	City insert(City city);

	City update(City city);

	void deleteByCityId(Integer id);
	
	List<City> findByCityList(Integer regionId);
	
	Long countByCityTotal();
	
}
