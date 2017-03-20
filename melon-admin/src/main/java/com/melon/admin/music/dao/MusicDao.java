package com.melon.admin.music.dao;


import java.util.List;

import com.melon.music.vo.MusicVO;
public interface MusicDao {
	
	public List<MusicVO> allLikeCountRanking();
}
