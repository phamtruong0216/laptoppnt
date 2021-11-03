package com.phamngoctruong.laptoppnt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamngoctruong.laptoppnt.model.Brand;
import com.phamngoctruong.laptoppnt.repository.IBrandRepository;

@Service
public class BrandServices {
	@Autowired
	private IBrandRepository iBrandRepository;

	public List<Brand> findAllBrand() {

		return iBrandRepository.findAll();

	}

	public Brand saveBrand(Brand brand) {
		
		return iBrandRepository.save(brand);

	}

	public boolean deleteBrandById(long idB) {
		iBrandRepository.deleteById(idB);
		return true;
	}

	public Brand findBrandById(long idBa) {
		// TODO Auto-generated method stub
		return iBrandRepository.findById(idBa).orElse(null);
	}
	public Brand findBrandByName(String name) {
		return iBrandRepository.findBrandByName(name);
		
		
	}

	

}
