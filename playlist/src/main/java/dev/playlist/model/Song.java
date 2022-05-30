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
	
	// Song°ú AlbumÀÇ °ü°è ????? ¤Ð¤Ð
	@JoinColumn(name="album_id")
	private String artist;
	
	private String length;
	
	@ManyToOne // 양방향 연관관계 설정을 위한 ManyToOne
	@JoinColumn(name = "playlist_song_id")
	private PlaylistSong playlistsong;
	
	// PlaylistSong이 세팅될 때 List<Song> 동시에 값을 넣어주는 메서드 정의
	public void insertSong(PlaylistSong playlistsong) {
		this.playlistsong = playlistsong;
		playlistsong.getSong().add(this);
	}
	
	//»ý¼ºÀÚ
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
