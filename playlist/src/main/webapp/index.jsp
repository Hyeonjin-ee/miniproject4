<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="song">song</a>

	<form action="addsong">
		<label for="name">앨범 타이틀 : </label><br>
		<input id="name" type="text" name="album title"><br> 
		<label for="author">아티스트 : </label><br>
		<input id="author" type="text" name="artist"><br>
		<label for="author">장르 : </label><br>
		<input id="author" type="text" name="genre"><br>
		<label for="author">발매일 : </label><br>
		<input id="author" type="text" name="releaseDate"><br>
		<label for="author">노래 제목 : </label><br>
		<input id="author" type="text" name="sing title"><br>
		<label for="author">재생 시간 : </label><br>
		<input id="author" type="text" name="length"><br>
		<input type="submit">        
	</form>
	<form action="addPlaylist">
		<label for="name">플레이리스트 명칭 : </label><br>
		<input id="name" type="text" name="album title"><br> 
		<input type="submit">     
	</form>
	
	<a href="updatePlaylist">수정 플레이리스트</a>
	
</body>
</html>