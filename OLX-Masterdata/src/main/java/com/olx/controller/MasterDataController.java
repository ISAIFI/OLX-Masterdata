package com.olx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.service.MasterDataService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("olx/masterdata")
public class MasterDataController {
	
	@Autowired
	MasterDataService masterDataService;
	
	@ApiOperation(value = "Get All Categories")
	@GetMapping(value = "/advertise/category", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public List<Category> getAllCategory(){
		return masterDataService.getAllCategory();
	}
	
	@ApiOperation(value = "Get All Status")
	@GetMapping(value = "/advertise/status", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public List<Status> getAllStatus(){
		return masterDataService.getAllStatus();
		
	}
	
	@ApiOperation(value = "Get Category by Id")
	@GetMapping(value = "/advertise/category/{categoryId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Category getCategory(@PathVariable("categoryId") int categoryId){
		return masterDataService.getCategory(categoryId);
	}
	
	@ApiOperation(value = "Get Status by Id")
	@GetMapping(value = "/advertise/status/{statusId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Status getStatus(@PathVariable("statusId") int statusId){
		return masterDataService.getStatus(statusId);
		
	}
}
