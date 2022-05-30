package dev.playlist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Playlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int playListId;

	private String playlistName;

	public Playlist() {
		super();
	}

	// »ý¼ºÀÚ
	public Playlist(String playlistName) {
		this.playlistName = playlistName;
	}

	public int getPlayListId() {
		return playListId;
	}

	public void setPlayListId(int playListId) {
		this.playListId = playListId;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylist_name(String playlistName) {
		this.playlistName = playlistName;
	}
}