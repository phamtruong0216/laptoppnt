package com.phamngoctruong.laptoppnt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamngoctruong.laptoppnt.model.Category;
import com.phamngoctruong.laptoppnt.repository.ICategoryRepository;

@Service
public class CategoryServices {
	@Autowired
	private ICategoryRepository iCategoryRepository;

	public List<Category> findAllCategory() {
		return iCategoryRepository.findAll();

	}

	public Category findCategoryById(long idC) {
		// TODO Auto-generated method stub
		return iCategoryRepository.findCategoryById(idC);
	}

	public void deleteCategoryById(long idC) {
		iCategoryRepository.deleteById(idC);;
	}

	public Category saveCategory(Category category) {
		return iCategoryRepository.save(category);
		// TODO Auto-generated method stub
		
	}

	public List<Category> findAllCategoryBy() {
		// TODO Auto-generated method stub
		return iCategoryRepository.findAllCategoy();
	}

}
