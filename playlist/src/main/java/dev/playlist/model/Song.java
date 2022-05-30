package dev.playlist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int songId;
	private String title;
	
	// Song과 Album의 관계 ????? ㅠㅠ
	@JoinColumn(name="album_id")
	private String artist;
	
	private String length;
	
	
	//생성자
	public Song() {}

	public Song(String title, String length) {
		this.title = title;
		this.length = length;
	}
	
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
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
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}

}