package com.phamngoctruong.laptoppnt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.phamngoctruong.laptoppnt.dto.AccountDto;
import com.phamngoctruong.laptoppnt.services.UserServiceImpl;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {
	@Autowired
	private IAuthenticationFacade authenticationFacade;
	@Autowired
	private UserServiceImpl userService;

	@Override
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	public String getNameUser() {
		Authentication authentication = authenticationFacade.getAuthentication();

		return authentication.getName();

	}

	public long getIdUser() {
		AccountDto account = userService.getUserByUsername(getNameUser());
		return account.getId();

	}

}
