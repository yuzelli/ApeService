package daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.ArticalCollection;
import bean.Article;
import bean.ArticleC;
import bean.CompanyPictures;
import dao.ArtCollectionDao;
import dao.ArticleDao;
import db.DataBaseUtil;

public class ArtCollectionDaoImpl implements ArtCollectionDao {
	
	ArticleDao acticleDao = new ArticleDaoImpl();

	@Override
	public int addArtColl(ArticalCollection ac) throws Exception {
		// TODO Auto-generated method stub
		int artID = -1;
		try {
			List<ArticalCollection> list2 = findAllArtColl();
			for (ArticalCollection acDB : list2) {
				if (acDB.getArticalId() == ac.getArticalId()
						&& acDB.getUserId()==ac.getUserId()) {
					artID = acDB.getCollectionId();
					return artID;
				}
			}
			
			String sqlStr = "insert into articalcollection (UserInfoId,ArticalId) values(?,?)";
			int num = DataBaseUtil.executeUpdate(sqlStr,
					new Object[] { ac.getUserId(), ac.getArticalId() });
			if (num > 0) {
				List<ArticalCollection> list = findAllArtColl();
				for (ArticalCollection acDB : list) {
					if (acDB.getArticalId() == ac.getArticalId()
							&& acDB.getUserId()==ac.getUserId()) {
						artID = acDB.getCollectionId();
						break;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}

		return artID;
	}

	@Override
	public boolean deleteArtColl(int acID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from articalcollection where CollectionId=?";
		boolean flag = false;
		try {
			int num = DataBaseUtil.executeUpdate(sql, new Object[] { acID });
			if (num > 0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}

		return flag;
	}

	@Override
	public ArticalCollection updateArtColl(ArticalCollection ac)
			throws Exception {
		// TODO Auto-generated method stub

		try {

			String sqlStr = "update articalcollection set UserInfoId=?,ArticalId=? where CollectionId=?";

			int num = DataBaseUtil.executeUpdate(
					sqlStr,
					new Object[] { ac.getUserId(), ac.getArticalId(),
							ac.getCollectionId() });
			if (num > 0) {
				ArticalCollection ac1 = findArtCollByID(ac.getCollectionId() );
				return ac1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}

		return null;
	}

	@Override
	public List<ArticalCollection> findAllArtColl() throws Exception {
		// TODO Auto-generated method stub
		List<ArticalCollection> list = null;

		try {
			list = new ArrayList<ArticalCollection>();
			String sqlStr = "select * from articalcollection";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStr, null);
			while (rs.next()) {
				ArticalCollection ac = new ArticalCollection();
				ac.setCollectionId(rs.getInt("CollectionId"));
				ac.setUserId(rs.getInt("UserInfoId"));
				ac.setArticalId(rs.getInt("ArticalId"));
				list.add(ac);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBaseUtil.closeConn();
		}

		return list;
	}

	@Override
	public ArticalCollection findArtCollByID(int acID) throws Exception {
		// TODO Auto-generated method stub
		ArticalCollection ac = null;

		try {
			String sqlStrid = "select * from articalcollection where CollectionId=?";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStrid,
					new Object[] { acID });
			while (rs.next()) {
				ac =  new ArticalCollection();
				ac.setCollectionId(rs.getInt("CollectionId"));
				ac.setUserId(rs.getInt("UserInfoId"));
				ac.setArticalId(rs.getInt("ArticalId"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}
		return ac;
	}

	@Override
	public List<ArticleC> findArtCollByCUserID(int userID) throws Exception {
		// TODO Auto-generated method stub
		List<ArticleC> articles = null;
		List<ArticalCollection> list = null;
		try {
			list = new ArrayList<ArticalCollection>();
			String sqlStr = "select * from articalcollection where UserInfoId = ?";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStr, new Object[]{ userID});
			while (rs.next()) {
				ArticalCollection ac = new ArticalCollection();
				ac.setCollectionId(rs.getInt("CollectionId"));
				ac.setUserId(rs.getInt("UserInfoId"));
				ac.setArticalId(rs.getInt("ArticalId"));
				list.add(ac);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}
		if (list!=null) {
			articles = new ArrayList<ArticleC>();
			for (ArticalCollection ac : list) {
				Article a = acticleDao.findArticleByID(ac.getArticalId());
				ArticleC aco = new ArticleC(a.getArticleId(), ac.getCollectionId(), a.getVexID(), a.getTitle(), a.getType(), a.getImgUrl(), a.getUserName(), a.getCreateTime(), a.getReplies(), a.getContent());
			    articles.add(aco);
			}
			
		}

		return articles;
	}

	@Override
	public boolean deleteArtCollByUserID(int userID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from articalcollection where UserInfoId=?";
		boolean flag = false;
		try {
			int num = DataBaseUtil.executeUpdate(sql, new Object[] { userID });
			if (num > 0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}

		return flag;
	}

	@Override
	public boolean deleteArtCollByArtId(int artID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from articalcollection where ArticalId=?";
		boolean flag = false;
		try {
			int num = DataBaseUtil.executeUpdate(sql, new Object[] { artID });
			if (num > 0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}

		return flag;
	}

}
