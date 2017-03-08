<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/template/common_header.jsp"/>

<link rel="stylesheet" type="text/css" href="/board/css/write_layout.css"/>
<script type="text/javascript">
	$(document).ready(function(){
		$("#writeForm").find("input[type=button]").click(function(){
			$("#writeForm").attr({
				"method" : "post",
				"action" : "/board/doWrite" // 리터럴! 
			});
			$("#writeForm").submit();
		});
		
		$("#writeForm").find("img").click(function(){
			$.post("/board/doWrite",
					{ // 첫번째 파라미터 URL 
					"subject": $(".subject").val(),
					"content": $(".content").val()
				/* 두번째 파라미터는 {} 객체를 보낸다. 
				 Ajax요청에서는 form을 쓰지 않고 객체들의 데이터를 보낸다. Ajax는 file을 보낼수가 없다. */
					},function(response){ // 세번째 파라미터 콜백
					alert("글쓰기가 잘 완료 되었습니다!!");
					}); 
			});
		});
</script>
	<div class="write">
	<h1>글 쓰깅</h1>
	<hr/> <!-- 가로선 -->
	<form id="writeForm">
		<!-- <input type="text" name="writer" placeholder="이름을 입력하세요."/><br/> -->
			<input type="text" class="subject" name="subject" placeholder="제목을 입력하세요."/><br/>
			<textarea name="content" class="content" placeholder="내용을 입력하세요"></textarea><br/>
		<input type="button" value="글올리기" />
		<img src="/board/img/ic_note_add_black_24dp_2x.png"/>
	</form>
	</div>
<jsp:include page="/template/common_footer.jsp"/>