package com.phamngoctruong.laptoppnt.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
@Configurable
public interface IAuthenticationFacade {
Authentication getAuthentication();
}

