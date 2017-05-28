package contriler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import utils.MyStringUtlis;
import bean.Job;
import bean.MyError;
import biz.JobBiz;
import bizimpl.JobBizImpl;

public class addJobAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addJobAction() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String JobName = MyStringUtlis.toUTFString(request, "jobrname");
		String JobDetail = MyStringUtlis.toUTFString(request, "jobdetails");
		int JobType = Integer.parseInt(request.getParameter("jobtype"));
		int JobCharge = Integer.parseInt(request.getParameter("jobsalary"));
		int JobCity = Integer.parseInt(request.getParameter("city"));
		int CompanyId = Integer.parseInt(request.getParameter("companyname"));
		String JobTechnology = MyStringUtlis.toUTFString(request, "jobskill");
		JobBiz jb = new JobBizImpl();
		Job j = new Job();

		j.setJobName(JobName);
		j.setJobDetail(JobDetail);
		j.setJobType(JobType);
		j.setJobCharge(JobCharge);
		j.setJobCity(JobCity);
		j.setCompanyId(CompanyId);
		j.setJobTechnology(JobTechnology);

		boolean test = jb.addJob(j);

		

		if (test) {
			// 插入成功
			response.sendRedirect("SelAllJobAction");
		} else {
			// 插入失败
			System.out.println("error");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
}
