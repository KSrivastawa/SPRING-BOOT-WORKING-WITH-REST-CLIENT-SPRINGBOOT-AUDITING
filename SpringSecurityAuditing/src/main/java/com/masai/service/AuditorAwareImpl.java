package com.masai.service;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("aware")
public class AuditorAwareImpl implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		
		String currentUser= SecurityContextHolder.getContext().getAuthentication().getName();
		
		return Optional.of(currentUser);
		
		
	}

}
