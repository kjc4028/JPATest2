package com.example.mvc.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.entity.City;
import com.example.mvc.entity.Person;
import com.example.mvc.entity.Region;
import com.example.mvc.repository.CityRepository;
import com.example.mvc.service.CityService;
import com.example.mvc.service.RegionService;

@Controller
@RequestMapping("/city" )
public class CityController {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(CityController.class);
    
    protected static final int DEFAULT_PAGE_NUM = 0;
    protected static final int DEFAULT_PAGE_SIZE = 5;
    
	@Autowired
	public CityService cityService;
	
	@Autowired
	public RegionService regionService;

    @RequestMapping(value = "/list")
    public String list(
            @RequestParam(value = "page", required = false) Integer page,
            Model model) {
        int pageNum = page != null ? page : DEFAULT_PAGE_NUM;
        Page<City> paging = cityService.findAll(pageNum, DEFAULT_PAGE_SIZE);
        model.addAttribute("page", paging);
        return "/city/list";
    }
    
/*    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String create(Model model){
    	List<Region> regionOption = regionService.findAllList();
    	model.addAttribute("regionOption",regionOption);
    	return "/city/form";
    }*/
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public @ModelAttribute
    City create(Model model) {
    	City city = new City();
    	List<Region> regionOption = regionService.findAllList();
    	model.addAttribute("regionOption",regionOption);
        return city;
    }
    

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String createOnSubmit(@Valid City city,
            BindingResult bindingResult, Model model) {
        LOGGER.debug("create city={}", city);
        if (bindingResult.hasErrors()) {
            LOGGER.warn("validation error={}", bindingResult.getModel());
            model.addAllAttributes(bindingResult.getModel());
            return "/city/form";
        }
        
        cityService.insert(city);
        return "redirect:/city/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Integer id, Model model) {
     	List<Region> regionOption = regionService.findAllList();
    	model.addAttribute("regionOption",regionOption);
        City city = cityService.findByCityId(id);
        model.addAttribute(city);
        return "/city/form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editOnSubmit(@Valid City city,
            BindingResult bindingResult, Model model) {
        LOGGER.debug("edit city={}", city);
        if (bindingResult.hasErrors()) {
            LOGGER.warn("validation error={}", bindingResult.getModel());
            model.addAllAttributes(bindingResult.getModel());
            return "/city/form";
        }
        cityService.update(city);
        return "redirect:/city/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(
            @RequestParam(value = "page", required = false) Integer page,
            @PathVariable("id") Integer id) {
        LOGGER.debug("delete id={}", id);
        cityService.deleteByCityId(id);
        return "redirect:/city/list";
    }

}
