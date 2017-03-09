package com.melon.album.biz;

import java.util.List;

import com.melon.album.dao.AlbumDao;
import com.melon.album.dao.AlbumDaoImpl;
import com.melon.album.vo.AlbumSearchVO;
import com.melon.album.vo.AlbumVO;

public class AlbumBizImpl implements AlbumBiz {

	AlbumDao albumDao = new AlbumDaoImpl();
	
	@Override
	public boolean addNewAlbum(AlbumVO albumVO) {
		return albumDao.insertNewAlbum(albumVO)>0;
	}

	@Override
	public List<AlbumVO> getAllAlbums(AlbumSearchVO albumSearchVO) {
		return albumDao.selectAllAlbums(albumSearchVO);
	}

	@Override
	public AlbumVO getOneAlbum(String albumId) {
		return albumDao.selectOneAlbum(albumId);
	}

	@Override
	public boolean removeOneAlbum(String albumId) {
		return albumDao.delecteOneAlbum(albumId)>0;
	}

}
