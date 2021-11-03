package com.phamngoctruong.laptoppnt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamngoctruong.laptoppnt.dto.ProvinceDto;
import com.phamngoctruong.laptoppnt.repository.IProvinceDtoRespository;

@Service
public class ProvinceServices {
	@Autowired
	private IProvinceDtoRespository dtoRespository;

	public List<ProvinceDto> findAllProvince() {
		return dtoRespository.findAll();
	}
	public ProvinceDto FindByIdProvince(String id) {
		return dtoRespository.findById(id).orElse(null);
		
	}
}
