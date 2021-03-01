package com.project.recordPlayer.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.recordPlayer.domain.Album;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AlbumControllerIntegrationTest {
	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {

		Album newAlbum = new Album("Hotspot and the Bimbles", "www.google.com", "www.askjeeves.com", "EARWIGS", 2019);

		String newAlbumAsJSON = this.mapper.writeValueAsString(newAlbum);

		RequestBuilder mockRequest = post("/album")
				.contentType(MediaType.APPLICATION_JSON)
				.content(newAlbumAsJSON);

		Album savedAlbum = new Album(1L, "Hotspot and the Bimbles", "www.google.com", "www.askjeeves.com", "EARWIGS", 2019); // want a 201
		String savedAlbumAsJSON = this.mapper.writeValueAsString(savedAlbum);

		ResultMatcher matchStatus = status().isCreated();
		
		ResultMatcher matchBody = content().json(savedAlbumAsJSON);

		this.mockMVC.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
	}
}
