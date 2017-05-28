package bizimpl;

import java.util.List;

import dao.ArtCollectionDao;
import daoimpl.ArtCollectionDaoImpl;
import bean.ArticalCollection;
import bean.Article;
import bean.ArticleC;
import biz.ArtCollectionBiz;

public class ArtCollectionBizImpl implements ArtCollectionBiz {

	ArtCollectionDao artCollDao = new ArtCollectionDaoImpl();
	@Override
	public int addArtColl(ArticalCollection ac) throws Exception {
		// TODO Auto-generated method stub
		return artCollDao.addArtColl(ac);
	}

	@Override
	public boolean deleteArtColl(int acID) throws Exception {
		// TODO Auto-generated method stub
		return artCollDao.deleteArtColl(acID);
	}

	@Override
	public ArticalCollection updateArtColl(ArticalCollection ac)
			throws Exception {
		// TODO Auto-generated method stub
		return artCollDao.updateArtColl(ac);
	}

	@Override
	public List<ArticalCollection> findAllArtColl() throws Exception {
		// TODO Auto-generated method stub
		return artCollDao.findAllArtColl();
	}

	@Override
	public ArticalCollection findArtCollByID(int acID) throws Exception {
		// TODO Auto-generated method stub
		return artCollDao.findArtCollByID(acID);
	}

	@Override
	public List<ArticleC> findArtCollByCUserID(int userID) throws Exception {
		// TODO Auto-generated method stub
		return artCollDao.findArtCollByCUserID(userID);
	}

}
