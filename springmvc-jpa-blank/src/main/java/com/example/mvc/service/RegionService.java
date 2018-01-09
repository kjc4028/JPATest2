package com.example.mvc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Async;

import com.example.mvc.entity.Region;

public interface RegionService {

	Page<Region> findAll(int page, int size);
	
	List<Region> findAllList();

	Region findById(Integer id);

	Region insert(Region region);

	Region update(Region region);
	
	//�񵿱� ���� �׽�Ʈ
	@Async
	void deleteById(Integer id);
	
	
}
