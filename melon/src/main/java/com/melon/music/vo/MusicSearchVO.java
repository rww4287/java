package com.melon.music.vo;

import com.melon.common.web.pager.Pager;
import com.melon.common.web.pager.PagerFactory;

public class MusicSearchVO {

	private Pager pager;
	
	private String albumId;
	private String artistId; // 앨범아이디와 아티스트를 검색을 하기 위해. 
	

	public Pager getPager() {
		if( pager == null ){
			pager = PagerFactory.getPager(Pager.ORACLE, 20, 10); //한페이지에는 20개씩을 보여주고, 한페이지 그룹이 10개  
		}
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getArtistId() {
		return artistId;
	}

	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}
	
	

}
