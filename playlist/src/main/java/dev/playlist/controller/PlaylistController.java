package dev.playlist.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.playlist.model.Album;
import dev.playlist.model.Playlist;
import dev.playlist.model.Song;


@RestController
public class PlaylistController {
	private final static DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy.MM.dd");
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("playlist");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	
	//노래 리스트 조회
	@RequestMapping("/song")
	public List<Song> readSong() {
		String selectQuery = "SELECT s FROM Song as s";
		List<Song> resultSong = em.createQuery(selectQuery, Song.class).getResultList();
		try {
			tx.begin();
			em.persist(resultSong);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return resultSong;
	}
	
	//앨범 수록곡 확인
	@RequestMapping("/AlbumInSong")
	public List<Object[]> readAlbumInSong(@RequestParam("album_id") int albumId) {
		String selectQuery = ("SELECT s, a.albumId FROM Song as s JOIN Album as a ON a.albumId = s.album WHERE a.albumId = " + albumId);
		List<Object[]> resultSong = em.createQuery(selectQuery, Object[].class).getResultList();

		try {
			tx.begin();
			em.persist(resultSong);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultSong;
	}
	
	
	
	
	//앨범 추가
	@RequestMapping("/addAlbum")
	public void addAlbum(@RequestParam("album_title") String albumTitle, @RequestParam("artist") String artist, 
						@RequestParam("genre") String genre, @RequestParam("releaseDate") String releaseDate)
	{
		tx.begin();
		
		Album album1 = new Album(albumTitle, artist, genre, LocalDate.parse(releaseDate, DATE_PATTERN));
		
		em.persist(album1);
		tx.commit();
	}
	
	//노래 추가
	@RequestMapping("/addSong")
	public void addAlbum(@RequestParam("song_title") String singTitle, @RequestParam("length") String length, @RequestParam("album_id") int albumId)
	{
		tx.begin();
		Album album = em.find(Album.class, albumId);
		Song song1 = new Song(singTitle, length);
		song1.setArtist(album.getArtist());
		song1.setAlbum(album);
		em.persist(song1);
		tx.commit();
	}
	
	//플레이리스트 추가
	@RequestMapping("/addPlaylist")
	public void addPlaylist(@RequestParam("playlist_Name") String playListName) {
		tx.begin();
		Playlist playlist1 = new Playlist(playListName);
		em.persist(playlist1);
		tx.commit();
	}
	
	//플레이리스트 이름 수정
	@RequestMapping("/updatePlaylist")
	public void updatePlaylist(@RequestParam("playlist_Name") String playListName, @RequestParam("playlist_Id") int plId) {
		tx.begin();
		Playlist playlist1 = em.find(Playlist.class, plId);
		playlist1.setPlaylist_name(playListName);
		
		tx.commit();
	}
	
	// 플레이리스트 삭제
	@RequestMapping("/deletePlaylist")
	public void deletePlaylist(@RequestParam("playListId") int playlistId) {
		tx.begin();
		Playlist playlist = em.find(Playlist.class, playlistId);
		em.remove(playlist);
		tx.commit();
	}
}


