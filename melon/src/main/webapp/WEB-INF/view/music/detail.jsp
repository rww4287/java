<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Music Detail</title>
<script type="text/javascript" src="/melon/static/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="/melon/static/css/common_layout.css"/>
<script type="text/javascript">
		$(document).ready(function(){
			$("#beforelike").click(function(){
				$.post("/melon/user/likecount",{
					"musicid" : $("#musicId").val()
				},function(response){

 					 var music = JSON.parse(response);
					 console.log(music.music.musicId);
 					 
					 var like = $("<div>♥ 좋아요 : "+music.music.likeCount+"</div>");
					 $("#beforelike").remove();
					 $("#member").after(like); 
				});
						
			});
		});
</script>
</head>
<body>

<!--  	<center><h1><img src="/melon/static/img/ic_audiotrack_black_24dp_2x.png"/> ${music.title}</h1>
	<h3 id="member">${music.albumVO.artistVO.member}</h3>

	<img src="/melon/album/post?albumId=${music.albumId}" 
		 width="300px" height="300px"/><br/>
	
	<div id="beforelike">♡ 좋아요 :  ${music.likeCount}</div>
	<input type="hidden" id="musicId" value="${music.musicId}"/>
	
	<video src="/melon/mp3/${music.albumId}/${music.mp3File}" 
		   controls="controls"></video>
		   
	</center>-->
	
	<div id="musicdetail">
	<h1><img src="/melon/static/img/ic_audiotrack_black_24dp_2x.png"/> ${music.title}</h1>
	<h3 id="member">${music.albumVO.artistVO.member}</h3>

	<img src="/melon/album/post?albumId=${music.albumId}" 
		 width="300px" height="300px"/><br/>
	<input type=range><br/>
	<img src="/melon/static/img/ic_repeat_black_24dp_2x.png"/>
	<img src="/melon/static/img/ic_favorite_border_black_24dp_2x.png"/> 
	<img src="/melon/static/img/ic_shuffle_black_24dp_2x.png"/> 
	<div> 좋아요수 </div>
	<input type="hidden" id="musicId" value="${music.musicId}"/>
	<textarea rows="4" cols="30">
	 ${music.lyrics}
	</textarea><br/>
	<img src="/melon/static/img/ic_skip_previous_black_24dp_2x.png"/> 
	<img src="/melon/static/img/ic_play_arrow_black_24dp_2x.png"/> 
	<img src="/melon/static/img/ic_skip_next_black_24dp_2x.png"/> 

	</div>

	
	
</body>
</html>