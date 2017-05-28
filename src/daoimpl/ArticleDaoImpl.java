package daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Article;
import bean.UserInfo;
import dao.ArtCollectionDao;
import dao.ArticleDao;
import db.DataBaseUtil;

public class ArticleDaoImpl implements ArticleDao{

	@Override
	public Article findArticleByID(Integer articleId) throws Exception {
		// TODO Auto-generated method stub
		Article article = null;
		
		try {
			String sqlStrid = "select * from article where ArticleId=?";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStrid,
					new Object[] { articleId });
			while (rs.next()) {
				article = new Article();
				article.setArticleId(rs.getInt("ArticleId"));
				article.setVexID(rs.getInt("VexID"));
				article.setTitle(rs.getString("Title"));
				article.setType(rs.getString("Type"));
				article.setImgUrl(rs.getString("ImgUrl"));
				article.setUserName(rs.getString("UserName"));
				article.setCreateTime(rs.getString("CreateTime"));
				article.setReplies(rs.getString("Replies"));
				article.setContent(rs.getString("Content"));
				
			}

	  } catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}
		return article;
		
		
	}

	@Override
	public int addAtricle(Article article) throws Exception {
		// TODO Auto-generated method stub
		int ArticleID = -1;
		try {
			String sqlStr = "insert into article (VexID,Title,Type,ImgUrl,UserName,CreateTime,Replies,Content) values(?,?,?,?,?,?,?,?)"
					;
			int num = DataBaseUtil.executeUpdate(
					sqlStr,new Object[] { article.getVexID(), article.getTitle(),article.getType(),
							article.getImgUrl(), article.getUserName(),
							article.getCreateTime(), article.getReplies(),article.getContent() });
			if (num > 0) {
				List<Article> ArticleList = findAtricles();
				for (Article articleDB : ArticleList) {
					if (articleDB.getVexID()==article.getVexID()) {
						ArticleID = articleDB.getArticleId();
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

		return ArticleID;
	}

	@Override
	public List<Article> findAtricles() throws Exception {
		// TODO Auto-generated method stub
		List<Article> articleList = null;

		try {
			articleList = new ArrayList<Article>();
			String sqlStr = "select * from article";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStr, null);
			while (rs.next()) {
				Article article = new Article();
				article.setArticleId(rs.getInt("ArticleId"));
				article.setVexID(rs.getInt("VexID"));
				article.setTitle(rs.getString("Title"));
				article.setType(rs.getString("Type"));
				article.setImgUrl(rs.getString("ImgUrl"));
				article.setUserName(rs.getString("UserName"));
				article.setCreateTime(rs.getString("CreateTime"));
				article.setReplies(rs.getString("Replies"));
				article.setContent(rs.getString("Content"));
				articleList.add(article);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBaseUtil.closeConn();
		}

		return articleList;
	}

	@Override
	public boolean deleteAtricle(int articleID) throws Exception {
		// TODO Auto-generated method stub
		ArtCollectionDao artcollDao = new ArtCollectionDaoImpl();
		artcollDao.deleteArtCollByArtId(articleID);
		
		String sql = "delete from article where ArticleId=?";
		boolean flag = false;
		try {
			int num  = DataBaseUtil.executeUpdate(sql, new Object[]{articleID});
		    if(num>0){
		    	flag = true;
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConn();
		}
		
		return flag;
	}

	@Override
	public Article updateAtricle(Article article) throws Exception {
		// TODO Auto-generated method stub
		Article art = null;
		try {
		
		String sqlStr = "update article set VexID=?,Title=?,Type=?,ImgUrl=?,UserName=?,CreateTime=?,Replies=?, Content=? where ArticleId=?";
		
		int num = DataBaseUtil.executeUpdate(
					sqlStr,
					new Object[] {article.getVexID(), article.getTitle(),article.getType(),
							article.getImgUrl(), article.getUserName(),
							article.getCreateTime(), article.getReplies(),article.getContent(),article.getArticleId()});
		if(num>0){    
			art = findArticleByID(article.getArticleId());
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConn();
		}
				
		return art;
	}

}
