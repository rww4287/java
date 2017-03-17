<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/melon/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/melon/static/js/json2.js"></script>
<script>
	$(document).ready(function(){
		
		$("#userId").keyup(function () {
			$.post("/melon/user/checkDuplicate",
				{
					"userId" : $("#userId").val()
				},
				function(response){
					var jsonObj = JSON.parse(response);
					console.log(JSON);
					console.log(jsonObj);
					
					if( jsonObj.duplicated ){
						$("#duplicateState").text("이미 사용중인 아이디 입니다");
					}else {
						$("#duplicateState").text("사용 가능합니다");
					}
				});
		});
		
		$("#registForm").find("input[type=button]").click(function(){
			
			// 필수입력값 체크 
			if($("#userId").val()==""){
				alert("아이디를 입력하세요!");
				$("#userId").focus();
				return;
			}
			
			if($("#userPassword").val()==""){
				alert("비밀번호를 입력하세요!");
				$("#userPassword").focus();
				return;
			}
			
			if($("#userPassword").val().length <= 7){
				alert("비밀번호는 8자리 이상으로 입력하세요!");
				$("#userPassword").focus();
				return;
			}
			if($("#userName").val() == ""){
				alert("이름을 입력하세요!");
				$("#userName").focus();
				return;
			}
			
			// 모든 유효성 체크 끝! -> 아이디체크
			
			$.post("/melon/user/checkDuplicate",{
				"userId" : $("#userId").val()
			},function(response){
				
				var jsonObj = JSON.parse(response);
				
				if(jsonObj.duplicated){
					alert("입력한 아이디는 이미 사용중입니다.\n 다른아이디를 사용해 주세요");
					return;
				} 
				else {
						$("#registForm").attr({
							"action":"/melon/user/signUp",
							"method":"post"
						});
						
						$("#registForm").submit();
				}
			});
			
		});
	
		
	});


</script>
</head>
<body>
	<!-- 평소엔 안보이다가 에러코드가 발생할때만 보이는 div -->
	<!-- 에러코드가 존재한다면 -->
	<c:if test="${ not empty param.errorCode}">
		<div>
			<c:choose>
				<c:when test="${param.errorCode == '0'}">
					ID는 필수 입력 값 입니다.
				</c:when>
				<c:when test="${param.errorCode == '1'}">
					Password는 필수 입력 값 입니다.
				</c:when>
				<c:when test="${param.errorCode == '2'}">
					Name은 필수 입력 값 입니다.
				</c:when>
				<c:when test="${param.errorCode == '3'}">
					이미 사용중인 ID 입니다.
				</c:when>
				<c:otherwise>
					?????????
				</c:otherwise>
			</c:choose>
		</div>
	</c:if>
	
	<h1>회원가입</h1><hr>
	<form id="registForm">
		<input type="text" id="userId" name="userId" placeholder="아이디를 입력해주세요"/>
		<span id="duplicateState"></span><br/>
		<input type="password" id="userPassword" name="userPassword"  placeholder="비밀번호를 입력해주세요"/><br/>
		<input type="text" id="userName" name="userName" placeholder="이름을 입력해주세요"/><br/>
		<input type="button" value="submit">
	</form>
</body>
</html>