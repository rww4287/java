<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 좋아요 Ranking</h1>

	<table>
		<tr>
			<th>Title</th>
			<th>가수</th>
			<th>좋아요</th>
		</tr>
	<c:forEach items="${musiclist}" var="music">
	<tr>
		<td><a href="/melon/music/detail?musicId=${music.musicId}">${music.title}</a></td>
		<td>${music.musician}</td>
		<td>${music.likeCount}</td>
	</c:forEach>
	</table>



</body>
</html>