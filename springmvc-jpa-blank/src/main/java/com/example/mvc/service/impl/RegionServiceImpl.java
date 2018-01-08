package com.example.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mvc.entity.Region;
import com.example.mvc.repository.RegionRepository;
import com.example.mvc.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService {
	
	@Autowired
	protected RegionRepository regionRepository; 
	
	@Override
	@Transactional(readOnly = true)
	public Page<Region> findAll(int page, int size) {
		Pageable pageable = new PageRequest(page, size);
		Page<Region> regions = regionRepository.findAll(pageable);
		return regions;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Region> findAllList() {
		return regionRepository.findAll();
	}


	@Override
	@Transactional(readOnly = true)
	public Region findById(Integer id) {
		Region region = regionRepository.findOne(id);
		return region;
	}

	@Override
	@Transactional
	public Region insert(Region region) {
		return regionRepository.save(region);
	}

	@Override
	@Transactional
	public Region update(Region region) {
		return regionRepository.save(region);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		regionRepository.delete(id);
	}

}
