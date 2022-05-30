package dev.playlist.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "album_id")
	private int albumId;
	private String albumTitle;
	private String artist;
	private String albumGenre;
	private LocalDate releaseDate;

	@OneToMany(mappedBy = "album")
	private List<Song> song = new ArrayList<>();

	
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
	public String getAlbumTitle() {
		return albumTitle;
	}
	public void setAlbumTitle(String albumTitle) {
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
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
//	public List<Song> getSong() {
//		return song;
//	}
//	public void setSong(List<Song> song) {
//		this.song = song;
//	}
	
}
