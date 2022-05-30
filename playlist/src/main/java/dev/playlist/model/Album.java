package dev.playlist.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int albumId;
	private String albumTitle;
	private String artist;
	private String albumGenre;
	private LocalDate releaseDate;

	
	//»ý¼ºÀÚ
	public Album() {}
	
	
	public Album(String albumTitle, String artist, String albumGenre, LocalDate releaseDate) {
		this.albumTitle = albumTitle;
		this.artist = artist;
		this.albumGenre = albumGenre;
		this.releaseDate = releaseDate;
	}
	
	
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public String getAlbum_title() {
		return albumTitle;
	}
	public void setAlbum_title(String albumTitle) {
		this.albumTitle = albumTitle;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbumGenre() {
		return albumGenre;
	}
	public void setalbumGenre(String albumGenre) {
		this.albumGenre = albumGenre;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setRelease_date(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
}
