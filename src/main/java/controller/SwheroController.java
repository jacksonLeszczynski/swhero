package controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.swheroes.api.RequestView;
import com.swheroes.api.ResponseWrapper;
import com.swheroes.api.exception.SwHeroNotFoundException;
import com.swheroes.api.model.SwHero;

import repository.SwheroRepository;

@RequestMapping(path = "/characters", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class SwheroController {
	
	Logger logger = LoggerFactory.getLogger(SwheroController.class);
	
	public static final int PAGE_SIZE = 5;
	
	@Autowired
	private SwheroRepository repository;
	
	@GetMapping
	@JsonView(RequestView.SwHeroGetList.class)
    public ResponseEntity<ResponseWrapper> getSwHeroesList(@RequestParam(value = "page", defaultValue = "1") int page) {
		PageRequest pageRequest = PageRequest.of(page - 1, PAGE_SIZE);
		Page<SwHero> heroesList = repository.findAll(pageRequest);
		int count = (int) heroesList.getContent().stream().count();
		if(heroesList.isEmpty()) {
			throw new SwHeroNotFoundException();
		} else {
			logger.debug("Request: characters?page=" + page + ": " + HttpStatus.OK);
			return ResponseEntity.ok(new ResponseWrapper(heroesList.getContent(), count, page));
		}
    }
	
	@GetMapping(value = "/{id}")
	@JsonView(RequestView.SwHeroGetOne.class)
    public ResponseEntity<SwHero> getSwHeroe(@PathVariable("id") long id) { 
		Optional<SwHero> swHero = repository.findById(id);
		if(swHero.isPresent()) {
			logger.debug("Request 'characters/" + id +": " + HttpStatus.OK);
			return ResponseEntity.ok(swHero.get());
		} else {
			throw new SwHeroNotFoundException(id);
		}
    }
}
