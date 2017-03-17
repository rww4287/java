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
		
		var userId = "${param.userId}";
		$("#auth").val("${user.authorizationId}");
		
		$("#pointBtn").click(function(){
			var buttontext = $(this).val();
			
			if(buttontext == "변경하기"){
				$(this).val("변경완료");
				$("#point").removeAttr("disabled");
			}
			else if(buttontext == "변경완료"){
				$.post("/melon-admin/user/modify",{
					"userPoint" : $("#point").val(),
					"userId" : userId
				},function(response){
					$(this).val("변경하기");
					$("#point").attr("disabled","disabled");
				});

			}
		});
		$("#passwordBtn").click(function(){
			var buttontext = $(this).val();
			
			if(buttontext == "변경하기"){
				$(this).val("변경완료");
				$("#password").removeAttr("disabled");
			}
			else if(buttontext == "변경완료"){
				$.post("/melon-admin/user/modify",{
					"userPassword" : $("#password").val(),
					"userId" : userId 
				},function(response){
					$(this).val("변경하기");
					$("#password").attr("disabled","disabled");
				});
				
			}
		});
		$("#authBtn").click(function(){
			var buttontext = $(this).val();
			
			if(buttontext == "변경하기"){
				$(this).val("변경완료");
				$("#auth").removeAttr("disabled");
			}
			else if(buttontext == "변경완료"){
				$.post("/melon-admin/user/modify",{
					"authorizationId" : $("#auth").val(),
					"userId" : userId 
				},function(response){
					
					$(this).val("변경하기");
					$("#auth").attr("disabled","disabled");
				});
			}
		});
	});
</script>
</head>
<body>
	<h3>ID : ${user.userId}</h3>
	<h3>NAME : ${user.userName}</h3><hr/>
	
	<form id="modifyForm">
		
		<span>PNT</span><input type="text" id="point"  disabled="disabled" value="${user.userPoint}">
		<input type="button" id="pointBtn" value="변경하기" />
		<br/>
		<span>PW</span> :<input type="password" id="password" disabled="disabled">
		<input type="button" id="passwordBtn" value="변경하기" />
		<br/>
		<select id="auth" disabled="disabled">
			<c:forEach items="${authList}" var="auth">
				<option value="${auth.authorizationId}">${auth.authorizationName}</option>
			</c:forEach>
		</select>
		<input type="button" id="authBtn" value="변경하기" />
	</form>
</body>
</html>