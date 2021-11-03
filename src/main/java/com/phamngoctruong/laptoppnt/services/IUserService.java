package com.phamngoctruong.laptoppnt.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.phamngoctruong.laptoppnt.dto.AccountDto;
import com.phamngoctruong.laptoppnt.model.User;

public interface IUserService extends UserDetailsService{
	User save(AccountDto accountDto);
}
