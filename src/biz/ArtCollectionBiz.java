package biz;

import java.util.List;

import bean.ArticalCollection;
import bean.Article;
import bean.ArticleC;

public interface ArtCollectionBiz {
	// 澧�
		public int addArtColl(ArticalCollection ac) throws Exception;

		// 鍒�
		public boolean deleteArtColl(int acID) throws Exception;

		// 鏀�
		public ArticalCollection updateArtColl(ArticalCollection ac)
				throws Exception;

		// 鏌�
		public List<ArticalCollection> findAllArtColl() throws Exception;

		public ArticalCollection findArtCollByID(int acID) throws Exception;

		// 閫氳繃鐢ㄦ埛id鏌ユ墍鏈�
		public List<ArticleC> findArtCollByCUserID(int userID) throws Exception;


}
