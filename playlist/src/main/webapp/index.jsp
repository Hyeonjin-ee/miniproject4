<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="song">song</a><br/>
	
	<form action="AlbumInSong">
		<label for="name">앨범 수록곡 : </label><br>
		<input id="name" type="text" name="album_id"><br> 
		<input type="submit">
	</form>
	
	<form action="addAlbum">
		<label for="name">앨범 타이틀 : </label><br>
		<input id="name" type="text" name="album_title"><br> 
		<label for="author">아티스트 : </label><br>
		<input id="author" type="text" name="artist"><br>
		<label for="author">장르 : </label><br>
		<input id="author" type="text" name="genre"><br>
		<label for="author">발매일 : </label><br>
		<input id="author" type="text" name="releaseDate"><br>
		<input type="submit">        
	</form>
	
	<form action="addSong">
		<label for="author">노래 제목 : </label><br>
		<input id="author" type="text" name="song_title"><br>
		<label for="author">재생 시간 : </label><br>
		<input id="author" type="text" name="length"><br>
		<label for="author">앨범 ID </label><br>
		<input id="author" type="text" name="album_id"><br>
		<input type="submit">  
	</form>
	
	<form action="addPlaylist">
		<label for="name">플레이리스트 명칭 : </label><br>
		<input id="name" type="text" name="playlist_Name"><br> 
		<input type="submit">     
	</form>
	
	<form action="updatePlaylist">
		<label for="name">플레이리스트 변경 : </label><br>
		<input id="name" type="text" name="playlist_Name"><br> 
		<label for="name">플레이리스트 ID : </label><br>
		<input id="name" type="text" name="playlist_Id"><br>
		<input type="submit">     
		
	</form>
		<form action="deletePlaylist">
		<label for="name">플레이리스트 삭제 </label><br>
		<label for="name">플레이리스트 ID : </label><br>
		<input id="name" type="text" name="playListId"><br>
		<input type="submit">     
	</form>
	
</body>
</html>