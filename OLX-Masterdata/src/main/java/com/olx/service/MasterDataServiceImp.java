package com.olx.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.entity.CategoryEntity;
import com.olx.entity.StatusEntity;
import com.olx.repo.CategoryRepo;
import com.olx.repo.StatusRepo;

@Service
public class MasterDataServiceImp implements MasterDataService{

	@Autowired
	StatusRepo statusRepo;
	@Autowired
	CategoryRepo categoryRepo;
	@Autowired
	ModelMapper modelMapper;
	@Override
	public List<Category> getAllCategory() {
		
		List<CategoryEntity> categoryList = categoryRepo.findAll();
		return getCategoryDtoListFromEntityList(categoryList);
		
//		List<Category> categories = new ArrayList<Category>();
//		categories.add(new Category(1, "Furniture"));
//		categories.add(new Category(2, "Real Estate"));
//		return categories;
	}

	@Override
	public List<Status> getAllStatus() {
		
		List<StatusEntity> categoryList = statusRepo.findAll();
		return getStatusDtoListFromEntityList(categoryList);
		
//		List<Status> allStatus = new ArrayList<Status>();
//		allStatus.add(new Status(1, "OPEN"));
//		allStatus.add(new Status(2, "CLOSE"));
//		return allStatus;
	}
	
	private Status getStatusFromEntity(StatusEntity statusEntity) {
		
		Status status = this.modelMapper.map(statusEntity, Status.class);
		return status;
	}

	private StatusEntity getStatusEntityFromDto(Status status) {
		
		StatusEntity statusEntity = this.modelMapper.map(status, StatusEntity.class);
		return statusEntity;
	}
	
	private List<Status> getStatusDtoListFromEntityList(List<StatusEntity> statusEntityList) {
		// TODO Auto-generated method stub
		List<Status> statusList = new ArrayList<>();
		
		for (StatusEntity statusEntity : statusEntityList) {
			
			statusList.add(getStatusFromEntity(statusEntity));
		}
		return statusList;
	}

	private Category getCategoryFromEntity(CategoryEntity categoryEntity) {
		
		Category category = this.modelMapper.map(categoryEntity, Category.class);
		return category;
	}

	private CategoryEntity getCategoryEntityFromDto(Category category) {
		
		CategoryEntity categoryEntity = this.modelMapper.map(category, CategoryEntity.class);
		return categoryEntity;
	}
	
	private List<Category> getCategoryDtoListFromEntityList(List<CategoryEntity> categoryEntityList) {
		// TODO Auto-generated method stub
		List<Category> categoryList = new ArrayList<>();
		
		for (CategoryEntity categoryEntity : categoryEntityList) {
			
			categoryList.add(getCategoryFromEntity(categoryEntity));
		}
		return categoryList;
	}

	@Override
	public Category getCategory(int categoryId) {
		Optional<CategoryEntity> categoryOptional = categoryRepo.findById(categoryId);
		if (categoryOptional.isPresent()) {
			CategoryEntity categoryEntity = categoryOptional.get();
			return getCategoryFromEntity(categoryEntity);
		}
		return null;
	}

	@Override
	public Status getStatus(int statusId) {
		Optional<StatusEntity> statusOptional = statusRepo.findById(statusId);
		if (statusOptional.isPresent()) {
			StatusEntity statusEntity = statusOptional.get();
			return getStatusFromEntity(statusEntity);
		}
		return null;
	}
}
