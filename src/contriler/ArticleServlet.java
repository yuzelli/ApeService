package contriler;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.MyStringUtlis;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import bean.Article;
import bean.MyError;
import bean.Success;
import bean.UserInfo;
import biz.ArticleBiz;
import bizimpl.ArticleBizImpl;

public class ArticleServlet extends HttpServlet {

	private ArticleBiz articleBiz = new ArticleBizImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf8");
		resp.setCharacterEncoding("utf8");
		
		// 判断
		String type = req.getParameter("type");
		if ("addArticle".equals(type)) {
			addArticle(req, resp);
			return;
		} else if ("deletArticle".equals(type)) {
			deletArticle(req, resp);
			return;
		} else if ("updataArticle".equals(type)) {
			updataArticle(req, resp);
			return;
		} else if ("findArticleByID".equals(type)) {
			findArticleByID(req, resp);
			return;
		} else if ("findAllArticle".equals(type)) {
			findAll(req, resp);
			return;
		}
	}

	/**
	 * 通过id查询
	 * 
	 * @param req
	 * @param resp
	 */
	private void findArticleByID(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub

		try {
			int articleID = Integer.parseInt(req.getParameter("articleID"));
			Article article = articleBiz.findArticleByID(articleID);
			if (article != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(article);
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			} else {
				MyError error = new MyError();
				error.setError("error");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 修改
	 * 
	 * @param req
	 * @param resp
	 */
	private void updataArticle(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {

			int articleId = Integer.parseInt(req.getParameter("ArticleId"));
			int vexID = Integer.parseInt(req.getParameter("VexID"));
			String title = MyStringUtlis.toUTFString(req, "Title");
			String type = MyStringUtlis.toUTFString(req, "Type");
			String imgUrl = req.getParameter("ImgUrl");
			String userName = MyStringUtlis.toUTFString(req, "UserName");
			String createTime = req.getParameter("CreateTime");
			String replies = req.getParameter("Replies");
			String content = MyStringUtlis.toUTFString(req, "Content");
			Article article = new Article();
			article.setArticleId(articleId);
			article.setVexID(vexID);
			article.setTitle(title);
			article.setType(type);
			article.setImgUrl(imgUrl);
			article.setUserName(userName);
			article.setCreateTime(createTime);
			article.setReplies(replies);
			article.setContent(content);
			Article art = articleBiz.updateAtricle(article);
			if (art != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(art);
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			} else {
				MyError error = new MyError();
				error.setError("error");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 查询所有
	 * 
	 * @param req
	 * @param resp
	 */
	private void findAll(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			HttpSession session = req.getSession();
			List<Article> list = articleBiz.findAtricles();
			if (list != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(list);
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
				
				
			} else {
				MyError error = new MyError();
				error.setError("error");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除
	 * 
	 * @param req
	 * @param resp
	 */
	private void deletArticle(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

		try {
			int articleId = Integer.parseInt(req.getParameter("ArticleId"));
			boolean flag = articleBiz.deleteAtricle(articleId);
			Success success = new Success();
			success.setFlag(flag);
			JSONObject jsonObject = JSONObject.fromObject(success);
			resp.getWriter().print(jsonObject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 添加一个文章。
	private void addArticle(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			int vexID = Integer.parseInt(req.getParameter("VexID"));
			String title = MyStringUtlis.toUTFString(req, "Title");
			String type = MyStringUtlis.toUTFString(req, "Type");
			String imgUrl = req.getParameter("ImgUrl");
			String userName = MyStringUtlis.toUTFString(req, "UserName");
			String createTime = req.getParameter("CreateTime");
			String replies = req.getParameter("Replies");
			String content = MyStringUtlis.toUTFString(req, "Content");
			Article article = new Article();
			article.setVexID(vexID);
			article.setTitle(title);
			article.setType(type);
			article.setImgUrl(imgUrl);
			article.setUserName(userName);
			article.setCreateTime(createTime);
			article.setReplies(replies);
			article.setContent(content);

			int articleID = articleBiz.addAtricle(article);
			if (articleID != -1) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("articleID", articleID + "");
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(map);
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			} else {
				MyError error = new MyError();
				error.setError("error");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
