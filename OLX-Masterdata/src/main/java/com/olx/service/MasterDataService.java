package com.olx.service;

import java.util.List;

import com.olx.dto.Category;
import com.olx.dto.Status;

public interface MasterDataService {

	public List<Category> getAllCategory();
	public List<Status> getAllStatus();
	public Category getCategory(int categoryId);
	public Status getStatus(int statusId);

}
