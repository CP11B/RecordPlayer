package com.project.recordPlayer.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.recordPlayer.domain.Album;
import com.project.recordPlayer.service.AlbumService;

@RestController
public class AlbumController {

	private AlbumService service;
	
	public AlbumController(AlbumService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/createalbum")
	public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
		return new ResponseEntity<Album>(this.service.createAlbum(album), HttpStatus.CREATED);
	}

	@GetMapping("/getalbums")
	public ResponseEntity<List<Album>> getAlbum() {
		return ResponseEntity.ok(this.service.getAlbum());
	}

	@GetMapping("/getalbum/{id}")
	public Album getAlbumById(@PathVariable Long id) {
		return this.service.getAlbumById(id);
	}
	
	@GetMapping("/getalbumbyname/{title}")
	public Album getAlbumByName(@PathVariable String title) {
		return this.service.getAlbumByTitle(title);
	}

	@DeleteMapping("/removealbum/{id}")
	public boolean removeAlbum(@PathVariable Long id) {
		return this.service.removeAlbum(id);
	}
	
	@PutMapping("/updatealbum/{id}")
	public Album updateAlbum(@PathVariable Long id, @RequestBody Album newAlbum) {
		return this.service.updateAlbum(id, newAlbum);
	}
	

}