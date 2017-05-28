package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CompanyPictures;
import bean.CompanyResume;
import biz.CompanyPicBiz;
import biz.CompanyResumeBiz;
import bizimpl.CompanyPicBizImpl;

public class updateCompPictu extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public updateCompPictu() {
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

		response.setContentType("text/html");
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		int pictureId = Integer.parseInt(request.getParameter("pictureId"));
		int  companyId= Integer.parseInt(request.getParameter("companyId"));
		String pictureUrl =  request.getParameter("pictureUrl") ;
		CompanyPictures pictures = new CompanyPictures();
		pictures.setPictureId(pictureId);
		pictures.setCompanyId(companyId);
		pictures.setPictureURL(pictureUrl);
		CompanyPicBiz biz = new CompanyPicBizImpl();
		try {
			biz.updatePic(pictures);
			response.sendRedirect("searchAllCompPictu.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
