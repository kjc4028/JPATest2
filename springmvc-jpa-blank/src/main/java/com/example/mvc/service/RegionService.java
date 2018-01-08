package com.example.mvc.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.mvc.entity.Person;
import com.example.mvc.entity.Region;

public interface RegionService {

	Page<Region> findAll(int page, int size);
	
	List<Region> findAllList();

	Region findById(Integer id);

	Region insert(Region region);

	Region update(Region region);

	void deleteById(Integer id);
}
