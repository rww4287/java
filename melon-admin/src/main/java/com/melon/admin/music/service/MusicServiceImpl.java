package com.melon.admin.music.service;

import java.util.List;

import com.melon.admin.music.biz.MusicBiz;
import com.melon.admin.music.biz.MusicBizImpl;
import com.melon.music.vo.MusicVO;

public class MusicServiceImpl implements MusicService{

	private MusicBiz musicBiz;
	
	public MusicServiceImpl(){
		musicBiz = new MusicBizImpl();
	}
	@Override
	public List<MusicVO> getLikeCountRanking() {
		return musicBiz.getLikeCountRanking();
	}

}
