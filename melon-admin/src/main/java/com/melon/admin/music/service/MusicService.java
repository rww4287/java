package com.melon.admin.music.service;

import java.util.List;

import com.melon.music.vo.MusicVO;

public interface MusicService {

	public List<MusicVO> getLikeCountRanking();
}
