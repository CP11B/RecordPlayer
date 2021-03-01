package com.project.recordPlayer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		private Long id;
		private String title;
		private String artist;
		private String imgSrc;
		private String playSrc;
		private int releaseYear;
		
		public Album(Long id, String title, String artist, String imgSrc, String playSrc, int releaseYear) {
			super();
			this.id = id;
			this.setTitle(title);
			this.setArtist(artist);
			this.setImgSrc(imgSrc);
			this.setPlaySrc(playSrc);
			this.setReleaseYear(releaseYear);
		}
		
		public Album(String title, String artist, String imgSrc, String playSrc, int releaseYear) {
			super();
			this.setTitle(title);
			this.setArtist(artist);
			this.setImgSrc(imgSrc);
			this.setPlaySrc(playSrc);
			this.setReleaseYear(releaseYear);
		}
		
		public Album() {
			super();
		}
		
		// getters and setters for each thing in album

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getArtist() {
			return artist;
		}

		public void setArtist(String artist) {
			this.artist = artist;
		}

		public String getImgSrc() {
			return imgSrc;
		}

		public void setImgSrc(String imgSrc) {
			this.imgSrc = imgSrc;
		}

		public String getPlaySrc() {
			return playSrc;
		}

		public void setPlaySrc(String playSrc) {
			this.playSrc = playSrc;
		}

		public int getReleaseYear() {
			return releaseYear;
		}

		public void setReleaseYear(int releaseYear) {
			this.releaseYear = releaseYear;
		}
	
}
