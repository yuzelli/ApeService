package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.MyStringUtlis;
import bean.Article;
import biz.ArticleBiz;
import bizimpl.ArticleBizImpl;

public class addAtricle extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addAtricle() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			

		response.setContentType("text/html");
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//int articleId = Integer.parseInt(request.getParameter("ArticleId"));
		int vexID = Integer.parseInt(request.getParameter("VexID"));
		//String title = MyStringUtlis.toUTFString(request, "Title");
		String title = request.getParameter("Title");
		System.out.println(title);
		String type = MyStringUtlis.toUTFString(request, "Type");
		String imgUrl = request.getParameter("ImgUrl");
		String userName = MyStringUtlis.toUTFString(request, "UserName");
		String createTime = request.getParameter("CreateTime");
		String replies = request.getParameter("Replies");
		String content = MyStringUtlis.toUTFString(request, "Content");
		Article article = new Article();
		//article.setArticleId(articleId);
		
		article.setVexID(vexID);
		article.setTitle(title);
		article.setType(type);
		article.setImgUrl(imgUrl);
		article.setUserName(userName);
		article.setCreateTime(createTime);
		article.setReplies(replies);
		article.setContent(content);
		
		ArticleBiz biz = new ArticleBizImpl();
		Article a= new Article(vexID, title, type, imgUrl, userName, createTime, replies, content);
		try {
			biz.addAtricle(a);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//request.getRequestDispatcher("/techSearch.jsp");
		response.sendRedirect("techSearch.jsp");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
