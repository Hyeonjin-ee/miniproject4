package playlist;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import dev.playlist.model.Album;
import dev.playlist.model.Playlist;
import dev.playlist.model.Song;

public class AppTest {
	private final static DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy.MM.dd");
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("playlist");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	List<Album> albumList = new ArrayList<>();
	List<Song> songList = new ArrayList<>();
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void readSong() {
		String selectQuery = "Select * from song";
		List<Song> resultSong = em.createQuery(selectQuery, Song.class).getResultList();

		for (Song song : resultSong) {
			System.out.println(song);
		}
		
	}
	
	@Test
	public void testSave() {
		tx.begin();
		
		Album album1 = new Album("TOMBOY", "IDLE", "��/��Ż, R&B/Soul, ��, ��/����", LocalDate.parse("2022.03.14", DATE_PATTERN));
		
		em.persist(album1);
		
		Song song1 = new Song("TOMBOY", "3:14");
		song1.setArtist(album1.getArtist());
		
		em.persist(song1);
		tx.commit();
	}
	
	@Test //�÷��̸���Ʈ �߰�
	public void addPlaylist() {
		tx.begin();
		Playlist playlist1 = new Playlist("playlist_1");
		em.persist(playlist1);
		tx.commit();
	}
	
	
	@Test //�÷��̸���Ʈ ����
	public void deletePlaylist() {
		
	}
	
//	@Test //�÷��̸���Ʈ ��ȸ
//	public void readPlaylist(int playlistId) {
//		Playlist choicePlayList = em.find(Playlist.class, playlistId);
//		List<Playlist> allPlayList = choicePlayList.get
//	}
	
	@Test //�÷��̸�Ʈ�� �̸� ����
	public void updatePlaylist() {
		tx.begin();
		Playlist playlist1 = em.find(Playlist.class, 1);
		playlist1.setPlaylist_name("����� �÷��̸���Ʈ");
		
		tx.commit();
	}
	
	@Test //�÷��̸���Ʈ song �� �߰�
	public void addPlayListSong() {
		
	}
	
	@Test //�÷��̸���Ʈ song �� ����
	public void deletePlayListSong() {
		
	}
	

}
