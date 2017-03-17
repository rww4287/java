<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/melon/static/js/jquery-3.1.1.min.js"></script>
<script>
$(document).ready(function(){

	$("#loginFrm").find("input[type=button]").click(function(){
		
		$("#loginFrm").attr({
			"action":"/melon/user/signIn",
			"method":"post"
		});
		
		$("#loginFrm").submit();
	});
	
});

</script>
</head>
<body>

	<h1>로그인</h1><hr>
	<form id="loginFrm" >
		<input type="text" name="userId" placeholder="아이디를 입력해주세요"/><br/>
		<input type="password" name="userPassword"  placeholder="비밀번호를 입력해주세요"/><br/>
	
		<input type="button" value="submit">
	</form>
</body>
</html>