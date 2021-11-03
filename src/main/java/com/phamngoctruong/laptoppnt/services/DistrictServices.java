package com.phamngoctruong.laptoppnt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamngoctruong.laptoppnt.dto.DistrictDto;
import com.phamngoctruong.laptoppnt.repository.IDistrictDtoRespository;

@Service
public class DistrictServices {
	@Autowired
	private IDistrictDtoRespository iDistrictDtoRespository;

	public List<DistrictDto> findAllDistrict() {
		return iDistrictDtoRespository.findAll();

	}

	public DistrictDto findDistrictById(String id) {
		return iDistrictDtoRespository.findById(id).orElse(null);
	}

	public List<DistrictDto> findAllDistrictByIDP(String province) {
		// TODO Auto-generated method stub
		return iDistrictDtoRespository.findAllDistrictByID(province);
	}
}
