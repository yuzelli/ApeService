package bizimpl;

import java.util.List;

import dao.ArticleDao;
import daoimpl.ArticleDaoImpl;
import bean.Article;
import biz.ArticleBiz;

public class ArticleBizImpl implements ArticleBiz {
	 ArticleDao articleDao = new ArticleDaoImpl();

	@Override
	public Article findArticleByID(Integer articleId) throws Exception {
		// TODO Auto-generated method stub
		return articleDao.findArticleByID(articleId);
	}

	@Override
	public int addAtricle(Article article) throws Exception {
		// TODO Auto-generated method stub
		return articleDao.addAtricle(article);
	}

	@Override
	public List<Article> findAtricles() throws Exception {
		// TODO Auto-generated method stub
		return articleDao.findAtricles();
	}

	@Override
	public boolean deleteAtricle(int articleID) throws Exception {
		// TODO Auto-generated method stub
		return articleDao.deleteAtricle(articleID);
	}

	@Override
	public Article updateAtricle(Article article) throws Exception {
		// TODO Auto-generated method stub
		return articleDao.updateAtricle(article);
	}

}
