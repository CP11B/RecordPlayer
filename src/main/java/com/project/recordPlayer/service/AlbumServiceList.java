package com.project.recordPlayer.service;

import java.util.List;

import com.project.recordPlayer.domain.Album;

public class AlbumServiceList implements AlbumService{
	
	private List<Album> albums;

	public AlbumServiceList(List<Album> albums) {
		super();
		this.albums = albums;
	}

	@Override
	public Album createAlbum(Album album) {
		this.albums.add(album);
		Album added = this.albums.get(this.albums.size() - 1);
		return added;
	}

	@Override
	public List<Album> getAlbum() {
		return this.albums;
	}

	@Override
	public Album getAlbumById(Long id) {
		return this.albums.get(id.intValue());
	}

	@Override
	public boolean removeAlbum(Long id) {
		return this.albums.remove(id);
	}
}
