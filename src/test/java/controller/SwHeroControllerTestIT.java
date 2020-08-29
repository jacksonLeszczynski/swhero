package controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc; 

import com.swheroes.api.SwHeroesApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SwHeroesApplication.class)
@AutoConfigureMockMvc
public class SwHeroControllerTestIT {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testSwHeroEndpoint() throws Exception {
		mockMvc.perform(get("/characters/1")).andExpect(status().isOk());
	}
	
	@Test
	public void testSwHeroesListEndpoint() throws Exception {
		mockMvc.perform(get("/characters?page=1")).andExpect(status().isOk());
	}

}
