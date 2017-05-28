package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.MyStringUtlis;
import bean.UserInfo;
import biz.UserInfoBiz;
import bizimpl.UserInfoBizImpl;

public class updateUser extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public updateUser() {
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
		String userPhoneNum = request.getParameter("UserPhoneNum");
		String userPassword = request.getParameter("UserPassword");
		String userHeadImg = request.getParameter("UserHeadImg");
		String userTrueName = MyStringUtlis.toUTFString(request, "UserTrueName");
		String userGender = MyStringUtlis.toUTFString(request, "UserGender");
		int userAge = Integer.parseInt(request.getParameter("UserAge"));
		int userDegree = Integer.parseInt(request.getParameter("UserDegree"));
		String userSchool = request.getParameter("UserSchool");
		int userExpactMonney = Integer.parseInt(request
				.getParameter("UserExpactMonney"));
		String userExperence = MyStringUtlis.toUTFString(request, "UserExperence"); 
		String userAdvantage = MyStringUtlis.toUTFString(request, "UserAdvantage"); 
		int userId=Integer.parseInt(request.getParameter("userId"));
		System.out.println(userId+"");
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUserPhoneNum(userPhoneNum);
		userInfo.setUserPassword(userPassword);
		userInfo.setUserHeadImg(userHeadImg);
		userInfo.setUserTrueName(userTrueName);
		userInfo.setUserGender(userGender);
		userInfo.setUserAge(userAge);
		userInfo.setUserDegree(userDegree);
		userInfo.setUserSchool(userSchool);
		userInfo.setUserExpactMonney(userExpactMonney);
		userInfo.setUserExperence(userExperence);
		userInfo.setUserAdvantage(userAdvantage);
		
		UserInfoBiz biz = new UserInfoBizImpl();
		try {
			biz.updateUserInfoByID(userId, userInfo);
			response.sendRedirect("userAllSearch.jsp");
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
