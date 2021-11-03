package com.phamngoctruong.laptoppnt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phamngoctruong.laptoppnt.model.Information;
import com.phamngoctruong.laptoppnt.model.User;
import com.phamngoctruong.laptoppnt.repository.IinformationRespository;
import com.phamngoctruong.laptoppnt.security.AuthenticationFacade;

@Service
public class InformationServices {
@Autowired
private IinformationRespository iRespository;
@Autowired
private AuthenticationFacade authenticationFacade;
@Autowired 
private UserServiceImpl userServiceImpl;
public Information updateInfor(Information infor) {
	User user = userServiceImpl.findUserById(authenticationFacade.getIdUser());
	Information getInformation= user.getInformation();
	getInformation.setCompany(infor.getCompany());
	getInformation.setCountry(infor.getCountry());
	getInformation.setDateBrithday(infor.getDateBrithday());
	getInformation.setDistrict(infor.getDistrict());
	getInformation.setNote(infor.getNote());
	getInformation.setPhone(infor.getPhone());
	getInformation.setProvince(infor.getProvince());
	getInformation.setSex(infor.getSex());
	getInformation.setVillage(infor.getVillage());
	getInformation.setWard(infor.getWard());
	return iRespository.save(getInformation);
	
}
}
