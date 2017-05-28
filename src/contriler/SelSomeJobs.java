package contriler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import utils.MyStringUtlis;
import net.sf.json.JSONArray;
import bean.Company;
import bean.Job;
import bean.JobAndCompany;
import biz.CompanyBiz;
import biz.JobBiz;
import bizimpl.CompanyBizImpl;
import bizimpl.JobBizImpl;


public class SelSomeJobs extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SelSomeJobs() {
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

		response.setContentType("text/html;chrset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String JobType=MyStringUtlis.toUTFString(request, "JobType");
		String JobCharge=MyStringUtlis.toUTFString(request, "JobCharge");
		String JobCity=MyStringUtlis.toUTFString(request, "JobCity");
		String CompanyId=MyStringUtlis.toUTFString(request, "CompanyId");
		JobBiz jbbiz = new JobBizImpl();
		List<Job> jobs =  new ArrayList<Job>();
		if ("".equals(JobType)&&"".equals(JobCharge)&&"".equals(JobCity)&&"".equals(CompanyId)) {
			jobs= jbbiz.selAllJob();
		}else{
			jobs= jbbiz.selSomeJob(JobType, JobCharge, JobCity, CompanyId);
		}
		request.setAttribute("list1", jobs);
		request.getRequestDispatcher("index.jsp").forward(request, response);
 	 
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
