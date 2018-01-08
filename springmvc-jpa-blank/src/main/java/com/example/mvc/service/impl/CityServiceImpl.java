package com.example.mvc.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mvc.entity.City;
import com.example.mvc.repository.CityRepository;
import com.example.mvc.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	@Autowired
	public CityRepository cityRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<City> findAll(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        Page<City> citys = cityRepository.findAll(pageable);
        return citys;
    }

    @Override
    @Transactional(readOnly = true)
    public City findByCityId(Integer id) {
        City city = cityRepository.findOne(id);
        return city;
    }

    @Override
    @Transactional
    public City insert(City city) {
        return cityRepository.save(city);
    }

    @Override
    @Transactional
    public City update(City city) {
        return cityRepository.save(city);
    }

    @Override
    @Transactional
    public void deleteByCityId(Integer id) {
        cityRepository.delete(id);
    }

	@Override
	public List<City> findAllList() {
		return cityRepository.findAll();
	}

	@Override
	public List<City> findByCityList(Integer regionId) {
		return cityRepository.findByCityList(regionId);
	}


}
