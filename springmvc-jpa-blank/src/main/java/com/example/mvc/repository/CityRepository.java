package com.example.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.mvc.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {
	
	
	@Query("select c from City c where c.regionId.regionId = ?1")
	List<City> findByCityList(Integer regionId);
	
	@Query("select count(*) from City")
	Long countByCityTotal();
	
	/*@Query("select c from City c where c.cityName = ?1")*/
	City findByCityName(String cityName);
	
	
}
