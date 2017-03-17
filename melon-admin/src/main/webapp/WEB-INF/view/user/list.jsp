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
	<form method="post" action="/melon-admin/user/authcheck">
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
				<td><input type="checkbox" name="checkuser" value="${user.userId}">${user.index}</td>
				<td>${user.userId}</td>
				<td><a href="/melon-admin/user/detail?userId=${user.userId}">${user.userName}</a></td>
				<td>${user.userPoint}</td>
				<td>${user.authorizationVO.authorizationName}</td>
			</tr>
			</c:forEach>
		</table>
	<div>
			${pager}
	</div>
			<select name="toAuth">
				<c:forEach items="${authList}" var="auth">
					<option value="${auth.authorizationId}">${auth.authorizationName}</option>
				</c:forEach>
					<option value="">권한없음</option>
			</select>
		<input type="submit" value="회원권한수정"/>
		</form>
		
		<form method="post" action="/melon-admin/user/authmodify">
			<select name="auth">
				<c:forEach items="${authList}" var="auth">
					<option value="${auth.authorizationId}">${auth.authorizationName}</option>
				</c:forEach>
				<option value="">권한없음</option>
			</select>
			<select name="auth">
				<c:forEach items="${authList}" var="auth">
					<option value="${auth.authorizationId}">${auth.authorizationName}</option>
				</c:forEach>
					<option value="">권한없음</option>
			</select>
			<input type="submit" value="일괄수정" />
		</form>
		
	
</body>
</html>