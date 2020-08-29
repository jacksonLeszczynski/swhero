package controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.swheroes.api.ResponseWrapper;
import com.swheroes.api.model.SwHero;

import repository.SwheroRepository;

@ExtendWith(MockitoExtension.class)
public class SwHeroControllerTest {
	
	@InjectMocks
	private SwheroController controller;
	@Mock
	private SwheroRepository repository;
	
	private MockHttpServletRequest request;
	
	@BeforeEach()
    public void setUp() {
		request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        MockitoAnnotations.initMocks(this);      
	}
	
	private SwHero getSingleSwHero() {
		SwHero swHero = new SwHero();
		swHero.setId(1L);
        swHero.setName("Skywalker");
        
        return swHero;
	}
	
	private List<SwHero> getSwHeroList() {
		List<SwHero> swHeroList = new ArrayList<SwHero>();
		SwHero swHero1 = new SwHero();
		swHero1.setId(1L);
		swHero1.setName("Skywalker");
        swHeroList.add(swHero1);
        SwHero swHero2 = new SwHero();
        swHero2.setId(2L);
        swHero2.setName("Obi-Wan");
        swHeroList.add(swHero2);
        
		return swHeroList;
	}
	
	@Test
	public void getSwHeroeTest() {
		//given
		when(repository.findById(1L)).thenReturn(Optional.of(getSingleSwHero()));
		
		//when
		ResponseEntity<SwHero> response = controller.getSwHeroe(1L);
		
		//then
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertThat(response.getBody().getName()).isEqualTo(getSingleSwHero().getName());
	}
	
	@Test
	public void getSwHeroesListTest() {
		//given
		Page<SwHero> heroesList = new PageImpl<>(getSwHeroList());
		when(repository.findAll(PageRequest.of(0, 5))).thenReturn(heroesList);
				
		//when
		ResponseEntity<ResponseWrapper> response = controller.getSwHeroesList(1);
				
		//then
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		assertEquals(response.getBody().getElements().size(), 2);
		assertThat(response.getBody().getElements().get(1).getName()).isEqualTo("Obi-Wan");
	}

}
