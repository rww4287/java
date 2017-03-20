package com.melon.admin.music.biz;

import java.util.List;
import com.melon.music.vo.MusicVO;

public interface MusicBiz {

	public List<MusicVO> getLikeCountRanking();
	
}
