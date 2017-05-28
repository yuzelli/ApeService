package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.MyStringUtlis;
import bean.Company;
import biz.CompanyBiz;
import bizimpl.CompanyBizImpl;

public class addCompanys extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addCompanys() {
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
		String companyNum = request.getParameter("CompanyNum");
		String companyPassword = request.getParameter("CompanyPassword");
		String companyHeadImg = request.getParameter("CompanyHeadImg");
		String companyName = MyStringUtlis.toUTFString(request, "CompanyName");
		String companyAddress = MyStringUtlis.toUTFString(request, "CompanyAddress");
		String companyIntroduce = MyStringUtlis.toUTFString(request, "CompanyIntroduce");
		int companyScale = Integer.parseInt(request
				.getParameter("CompanyScale"));
		Company company = new Company();
		company.setCompanyNum(companyNum);
		company.setCompanyPassword(companyPassword);
		company.setCompanyHeadImg(companyHeadImg);
		company.setCompanyName(companyName);
		company.setCompanyAddress(companyAddress);
		company.setCompanyIntroduce(companyIntroduce);
		company.setCompanyScale(companyScale);
		CompanyBiz biz = new CompanyBizImpl();
		try {
			biz.registerCompany(company);
			response.sendRedirect("compAllSearch.jsp");
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
