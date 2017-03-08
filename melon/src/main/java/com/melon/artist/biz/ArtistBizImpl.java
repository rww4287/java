package com.melon.artist.biz;

import java.util.ArrayList;
import java.util.List;

import com.melon.artist.dao.ArtistDao;
import com.melon.artist.dao.ArtistDaoImpl;
import com.melon.artist.vo.ArtistSearchVO;
import com.melon.artist.vo.ArtistVO;
import com.melon.common.web.pager.Pager;

public class ArtistBizImpl implements ArtistBiz {

	private ArtistDao artistDao;
	
	public ArtistBizImpl() {
		artistDao = new ArtistDaoImpl();
	}
	
	@Override
	public boolean addNewArtist(ArtistVO artistVO) {
		return artistDao.insertNewArtist(artistVO) > 0;
	}

	@Override
	public List<ArtistVO> getAllArtists(ArtistSearchVO artistSearchVO) {
		int artistCount = artistDao.selectAllArtistsCount(artistSearchVO);
		
		Pager pager = artistSearchVO.getPager();
		pager.setTotalArticleCount(artistCount);
		
		if( artistCount == 0 ){
			return new ArrayList<ArtistVO>();
		}
		
		return artistDao.selectAllArtists(artistSearchVO);
	}

	@Override
	public ArtistVO getOneArtist(String artistId) {
		return artistDao.selectOneArtist(artistId);
	}

	@Override
	public boolean deleteOneArtist(String artistId) {
		return artistDao.delectOneArtist(artistId) > 0;
	}

}
