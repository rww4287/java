package com.melon.admin.music.biz;

import java.util.List;

import com.melon.admin.music.dao.MusicDao;
import com.melon.admin.music.dao.MusicDaoImpl;
import com.melon.music.vo.MusicVO;
public class MusicBizImpl implements MusicBiz {

	private MusicDao musicDao;
	
	public MusicBizImpl(){
		musicDao = new MusicDaoImpl();
	}
	@Override
	public List<MusicVO> getLikeCountRanking() {
		return musicDao.allLikeCountRanking();
	}

}
