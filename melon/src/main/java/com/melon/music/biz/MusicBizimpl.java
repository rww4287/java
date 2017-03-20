package com.melon.music.biz;

import java.util.ArrayList;
import java.util.List;

import com.melon.common.web.pager.Pager;
import com.melon.music.dao.MusicDao;
import com.melon.music.dao.MusicDaoImpl;
import com.melon.music.vo.MusicSearchVO;
import com.melon.music.vo.MusicVO;

public class MusicBizimpl implements MusicBiz{

	MusicDao musicDao;
	public MusicBizimpl(){
		musicDao = new MusicDaoImpl();
	}
	@Override
	public boolean addNewMusic(MusicVO musicVO) {
		return musicDao.insertNewMusic(musicVO) >0;
	}

	@Override
	public List<MusicVO> getAllMusic(MusicSearchVO musicSearchVO) {
		
		int musicCount= musicDao.selectAllMusicCount(musicSearchVO);
		
		Pager pager = musicSearchVO.getPager();
		pager.setTotalArticleCount(musicCount);
		
		
		if( musicCount == 0 ){
			return new ArrayList<MusicVO>();
			
		}
		return musicDao.selectAllMusic(musicSearchVO);
	}

	@Override
	public MusicVO getOneMusic(String musicId) {
		return musicDao.selectOneMusic(musicId);
	}

	@Override
	public boolean deleteOneMusic(String musicId) {
		return musicDao.deleteOneMusic(musicId)>0;
	}
	@Override
	public boolean increaseMusicCount(String musicId) {
		return musicDao.addMusicCount(musicId)>0;
	}

}
