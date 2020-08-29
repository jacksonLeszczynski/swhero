package com.swheroes.api.exception;

import org.springframework.http.HttpStatus;

public class SwHeroNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private final HttpStatus status = HttpStatus.NOT_FOUND;

	public SwHeroNotFoundException(Long idSwhero) {
		super("SwHero not found: " + idSwhero);
	}
	
	public SwHeroNotFoundException() {
		super("SwHero List not found");
	}

	public HttpStatus getStatus() {
		return status;
	}
}
