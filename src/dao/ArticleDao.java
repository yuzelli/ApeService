package dao;

import java.util.List;

import bean.Article;

public interface ArticleDao {
	//增
	public int addAtricle(Article article) throws Exception;

    //删
	public boolean deleteAtricle(int articleID) throws Exception;
	
	//改
	public Article updateAtricle(Article article) throws Exception;
	
	//查
	public List<Article> findAtricles() throws Exception;
	
	public Article findArticleByID(Integer articleId) throws Exception;

}
