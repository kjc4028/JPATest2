package com.example.mvc.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.entity.Region;
import com.example.mvc.service.CityService;
import com.example.mvc.service.RegionService;

@Controller
@RequestMapping("/region")
public class RegionController {
	
    private static final Logger LOGGER = LoggerFactory
            .getLogger(RegionController.class);
    
    protected static final int DEFAULT_PAGE_NUM = 0;
    protected static final int DEFAULT_PAGE_SIZE = 5;
    
    
	@Inject
	protected RegionService regionService;
	
	@Inject
	protected CityService cityService;
	
    @RequestMapping(value = "/list")
    public String list(
            @RequestParam(value = "page", required = false) Integer page,
            Model model) {
        int pageNum = page != null ? page : DEFAULT_PAGE_NUM;
        Page<Region> paging = regionService.findAll(pageNum, DEFAULT_PAGE_SIZE);
        model.addAttribute("page", paging);
        return "/region/list";
    }
    
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public @ModelAttribute
    Region create(Model model) {
    	Region region = new Region();
        return region;
    }
    

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String createOnSubmit(@Valid Region region,
            BindingResult bindingResult, Model model) {
        LOGGER.debug("create region={}", region);
        if (bindingResult.hasErrors()) {
            LOGGER.warn("validation error={}", bindingResult.getModel());
            model.addAllAttributes(bindingResult.getModel());
            return "/region/form";
        }
        
        regionService.insert(region);
        return "redirect:/region/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Integer id, Model model) {
        Region region = regionService.findById(id);
        model.addAttribute(region);
        return "/region/form";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editOnSubmit(@Valid Region region,
            BindingResult bindingResult, Model model) {
        LOGGER.debug("edit region={}", region);
        if (bindingResult.hasErrors()) {
            LOGGER.warn("validation error={}", bindingResult.getModel());
            model.addAllAttributes(bindingResult.getModel());
            return "/region/form";
        }
        regionService.update(region);
        return "redirect:/region/list";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(
            @RequestParam(value = "page", required = false) Integer page,
            @PathVariable("id") Integer id) {
        LOGGER.debug("delete id={}", id);
        regionService.deleteById(id);
        return "redirect:/region/list";
    }
}
