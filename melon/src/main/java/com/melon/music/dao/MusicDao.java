package com.melon.music.dao;

import java.util.List;

import com.melon.music.vo.MusicSearchVO;
import com.melon.music.vo.MusicVO;

public interface MusicDao {
	
	public int insertNewMusic(MusicVO musicVO);
	
	public int selectAllMusicCount(MusicSearchVO musicSearchVO);

	public List<MusicVO> selectAllMusic(MusicSearchVO musicSearchVO);
	
	public MusicVO selectOneMusic(String musicId);
	
	public int deleteOneMusic(String musicId);
	
	public int addMusicCount(String musicId);

}
