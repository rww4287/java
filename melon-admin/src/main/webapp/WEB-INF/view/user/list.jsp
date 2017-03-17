<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/melon-admin/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
	});
</script>
</head>
<body>
	<h1>List</h1><hr/>
	<p>${totalUser}명의 USER가 검색되었습니다.</p>
	<table>
		<tr>
			<th>번호</th>
			<th>ID</th>
			<th>이름</th>
			<th>POINT</th>
			<th>권한</th>
		</tr>
		<c:forEach items="${userList}" var="user">
		<tr>
			<td>${user.index}</td>
			<td>${user.userId}</td>
			<td><a href="/melon-admin/user/detail?userId=${user.userId}">${user.userName}</a></td>
			<td>${user.userPoint}</td>
			<td>${user.authorizationVO.authorizationName}</td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<form id="searchForm">
			${pager}
		</form>
	</div>

	<input type="button" value="회원추가">
	<input type="button" value="일괄수정">
	<input type="button" value="일괄삭제">
	
</body>
</html>