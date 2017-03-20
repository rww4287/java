package com.melon.music.service;

import java.util.List;

import com.melon.music.biz.MusicBiz;
import com.melon.music.biz.MusicBizimpl;
import com.melon.music.vo.MusicSearchVO;
import com.melon.music.vo.MusicVO;
import com.melon.user.biz.UserBiz;
import com.melon.user.biz.UserBizImpl;
import com.melon.user.vo.UserVO;

/*
 * 간단하게 MusicBiz와 연결을 해준다. 
 * UserBiz도 연결해준다. 
 */
public class MusicServiceImpl implements MusicService{

	private MusicBiz musicBiz;
	private UserBiz userBiz;
	
	public MusicServiceImpl(){
		musicBiz = new MusicBizimpl();
		userBiz = new UserBizImpl();
	}
	@Override
	public boolean addNewMusic(MusicVO musicVO) {
		return musicBiz.addNewMusic(musicVO);
	}

	@Override
	public List<MusicVO> getAllMusic(MusicSearchVO musicSearchVO) {
		return musicBiz.getAllMusic(musicSearchVO);
	}

	@Override
	public MusicVO getOneMusic(String musicId,UserVO userVO) {
		
		MusicVO music = musicBiz.getOneMusic(musicId);
		
		if( music != null ){
			if(userVO == null ){
				return music;
			}
			userBiz.managePoint(userVO.getUserId(), -5);
			int userPoint = userVO.getUserPoint();
			userVO.setUserPoint(userPoint-5);
		} 
		
		return music;
	}

	@Override
	public boolean deleteOneMusic(String musicId) {
		return musicBiz.deleteOneMusic(musicId);
	}
	@Override
	public boolean increaseMusicCount(String musicId) {
		return musicBiz.increaseMusicCount(musicId);
	}


}
