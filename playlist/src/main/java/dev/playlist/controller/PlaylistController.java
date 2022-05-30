package dev.playlist.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;
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
//	public List<Song> readSong() {
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
		
		for (Song song : resultSong) {
			System.out.println(song);
		}
		
		return resultSong;
	}
	
	
	
	//앨범 및 노래 추가
	@RequestMapping("/addsong")
	public void addSong(@RequestParam("album title") String albumTitle, @RequestParam("artist") String artist, 
						@RequestParam("genre") String genre, @RequestParam("releaseDate") String releaseDate, 
						@RequestParam("sing title") String singTitle, @RequestParam("length") String length)
	{
		tx.begin();
		
		Album album1 = new Album(albumTitle, artist, genre, LocalDate.parse(releaseDate, DATE_PATTERN));
		
		em.persist(album1);
		
		Song song1 = new Song(singTitle, length);
		song1.setArtist(album1.getArtist());
		
		em.persist(song1);
		tx.commit();
	}
	
	//플레이리스트 추가
	@RequestMapping("/addPlaylist")
	public void addPlaylist(@RequestParam("playList name") String playListName) {
		tx.begin();
		Playlist playlist1 = new Playlist(playListName);
		em.persist(playlist1);
		tx.commit();
	}
	
	//플레이리스트 이름 수정
	@RequestMapping("/updatePlaylist")
	public void updatePlaylist(@RequestParam("playList name") String playListName, @RequestParam("playList Id") int plId) {
		tx.begin();
		Playlist playlist1 = em.find(Playlist.class, plId);
		playlist1.setPlaylist_name(playListName);
		
		tx.commit();
	}
	
}


