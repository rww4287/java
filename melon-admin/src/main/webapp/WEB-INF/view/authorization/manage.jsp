<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/melon-admin/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
// SPA - Ajax를 이용하여 수정,삭제등등 기능을 다하는것. 발전형태 -> Angularjs 
	$().ready(function(){
		
		// 1. 권한 목록 가져오기 
		$.post("/melon-admin/authorization/all",{},function(response){
			
			// JSON Format String을 Javascript Object로 변환함.
			var auth = JSON.parse(response);
			var authList = auth.authorizations;
			
			var authorizationDiv = $("#authorization");
			var parentAuthorizationId = $("#parentAuthorizationId");
			
			for(var i in authList){
				console.log(authList[i].authorizationName);
				
				// 인증 : Authentication ( Cridential : 인증에 필요한 데이터 )
				// 인가 : Authorization 구분!!
				var eachAuth = $("<div id='"+ authList[i].authorizationId+"'></div>");
				eachAuth.text(authList[i].authorizationName);
				eachAuth.data("parent",authList[i].parentAuthorizationId);
				
				authorizationDiv.append(eachAuth); //  $("<div id='"+ authList[i].authorizationId+"'></div>");를 만들어서
												  // authorizationDiv 에 넣겠다. 
				/*
				 * option : select tag의 필수 하위 요소 , option에는 name을 가질수 없다. 
				 * <select name=''>
				 * 		<option value='값'>이름</option>
				 * 		<option value='값'>이름</option>
				 * </select>
				 * value --> 서버로 전달될 값
				 * 이름 --> 값 대신 사용자에게 보여질 의미있는 값
				 */
				var itemAuth = $("<option value='"+ authList[i].authorizationId+"'>"+ authList[i].authorizationName +"</option>");
				parentAuthorizationId.append(itemAuth); // select에다가 option을 넣어주겠다. 
			}
		});
		
		// 2. 클릭을 하면
		// $("#authorization").find("div").click(function(){ 돔방식
		// 섀도우 돔 방식
		$("#authorization").on("click","div",function(){
			alert( $(this).text() );
			
			$("#authorizationId").val($(this).attr("id"));
			$("#authorizationName").val( $(this).text() );
			
			/* eachAuth.data("parent",authList[i].parentAuthorizationId);
			 * 여기서 준data-parent 값을 가져오겠다.
			 */ 
			$("#parentAuthorizationId").val( $(this).data("parent")); 
			
			$("#modifyBtn").remove();
			$("#deleteBtn").remove();
			
			var modifyBtn = $("<input type='button' id='modifyBtn' value='수정' />");
			var deleteBtn = $("<input type='button' id='deleteBtn' value='삭제' />");
			
			$("#registBtn").after(deleteBtn);
			$("#registBtn").after(modifyBtn);
			
			
		});
		
		$("#registForm").on("click","#modifyBtn", function() {
			
			$.post("/melon-admin/authorization/modify",{
				"authorizationId" : $("#authorizationId").val(),
				"authorizationName" :  $("#authorizationName").val(),
				"parentAuthorizationId" : $("#parentAuthorizationId").val()
			},
				function(response) {
					var obj = JSON.parse(response);
					if ( obj.status == "success"){
						var modifiedAuth = $("#authorizationId").val();
						$("#"+modifiedAuth).text($("#authorizationName").val());
						$("#"+modifiedAuth).data("parent",$("#parentAuthorizationId").val());
						
						$("#parentAuthorizationId").find("option[value="+modifiedAuth+"]").text( $("#authorizationName").val() );
						$("#deleteBtn").remove();
						$("#modifyBtn").remove();
						$("#authorizationId").val("");
						$("#authorizationName").val("");
						$("#parentAuthorizationId").val("");
					}
			});

		});
		$("#registForm").on("click","#deleteBtn", function() {
			$.post("/melon-admin/authorization/delete",{
				"authorizationId" : $("#authorizationId").val()
				},
				function(response){
					var status = JSON.parse(response);
					console.log(status);
					if(status.status == "success"){
						var deletedAuth = $("#authorizationId").val();
						$("#"+deletedAuth).remove();
						
						$("#parentAuthorizationId").find("option[value="+deletedAuth+"]").remove();
						$("#deleteBtn").remove();
						$("#modifyBtn").remove();
						$("#authorizationId").val("");
						$("#authorizationName").val("");
						$("#parentAuthorizationId").val("");
					}
					else{
						alert("삭제 실패했습니다");
					}
				});
			
		});

		// 등록해준다.
		$("#registBtn").click(function(){
			$.post("/melon-admin/authorization/regist",{
				"authorizationName" : $("#authorizationName").val(),
				"parentAuthorizationId" : $("#parentAuthorizationId").val()
				}, function(response){
					var auth = JSON.parse(response);
					var authInfo = auth.authorization; // authorizationVO를 가져오겠다. 

					console.log(auth);
					console.log(auth.authorization.authorizationName);

					
					var authorizationDiv = $("#authorization");
					var parentAuthorizationId = $("#parentAuthorizationId");
					var eachAuth = $("<div id='"+ authInfo.authorizationId+"'></div>");
					
					eachAuth.text(authInfo.authorizationName);
					eachAuth.data("parent",authInfo.parentAuthorizationId);
					
					authorizationDiv.append(eachAuth);
					
					var itemAuth = $("<option value='"+ authInfo.authorizationId+"'>"+ authInfo.authorizationName +"</option>");
					parentAuthorizationId.append(itemAuth);
				});
		});
		
		
	});

</script>
</head>
<body>
	
	<div id="regist">
		<form id="registForm">
			<input type="hidden" id="authorizationId"/>
			<span>권한명</span><br/>
			<input type="text" id="authorizationName"/><br/>
			<br/>
			<span>상위 권한</span>
			<select id="parentAuthorizationId"></select>
			<br/>
			<input type="button" id="registBtn" value="저장"/> 

		</form>
	</div>
	<div id="authorization"></div>
	
</body>
</html>