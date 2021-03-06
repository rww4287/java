<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/melon/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		// 클릭 이벤트를 isAdminUser 이거나 isOperatorUser일때만 할수 있게한다.
		<c:if test="${isAdminUser || isOperatorUser}">
		$("input[type=button]").click(function(){
			
			var writeDiv = $("<div id='writeDiv'></div>");
			
			writeDiv.css({
				position: 'absolute',
				top: '50%',
				left: '50%',
				width: '170px',
				height: '100px',
				'margin-top': '-57.5px',
				'margin-left': '-92.5px',
				border: '1px solid #333333',
				padding: '15px',
				'z-index': 3,
				'background-color' :'#FFFFFF'
			
			});
			
			writeDiv.load("/melon/artist/write"); 
			$(this).before(writeDiv);

		});
		</c:if>

	});
</script>
<title>Insert title here</title>
</head>
<body>

	<!-- isNormalUser 일땐 보여주지 않게 처리 -->
	<c:choose>
		<c:when test="${isAdminUser || isOperatorUser}">
			<input type="button" value="아티스트 등록"/>
		</c:when>
	</c:choose>
	<p>${artistCount}명의 아티스트가 검색되었습니다.</p>
	<table>
		<tr>
			<th>번호</th>
			<th>아티스트명</th>
			<th>데뷔년도</th>
		</tr>
		<c:forEach items="${artistList}" var="artist"> 
		<tr>
			<td>
				<fmt:parseNumber>
					${fn:split(artist.artisId,'-')[2]}
				</fmt:parseNumber>
				</td>
			<td> <a href="/melon/album/list?artistId=${artist. artisId}">${artist.member}</a></td>
			<td>${artist.debutDate}</td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<form id="searchForm">
			${pager}
		</form>
	</div>

</body>
</html>