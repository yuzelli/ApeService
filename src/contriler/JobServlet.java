package contriler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import utils.MyStringUtlis;
import bean.Company;
import bean.Job;
import bean.JobAndCompany;
import bean.MyError;
import biz.CompanyBiz;
import biz.JobBiz;
import bizimpl.CompanyBizImpl;
import bizimpl.JobBizImpl;

public class JobServlet extends HttpServlet {

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
		if ("addJob".equals(type)) {
			addJob(req, resp);
			return;
		} else if ("delJob".equals(type)) {
			delJob(req, resp);
			return;
		} else if ("jobUpdate".equals(type)) {
			jobUpdate(req, resp);
			return;
		} else if ("selJob".equals(type)) {
			selJob(req, resp);
			return;
		} else if ("load".equals(type)) {
			load(req, resp);
			return;
		} else if ("selSomeJob".equals(type)) {
			selSomeJob(req, resp);
			return;
		}
	}

	/**
	 * 添加工作
	 * 
	 * @param req
	 * @param resp
	 */
	private void addJob(HttpServletRequest request, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String JobName;
		try {
			JobName = MyStringUtlis.toUTFString(request, "jobrname");
			String JobDetail = MyStringUtlis.toUTFString(request, "jobdetails");
			int JobType = Integer.parseInt(request.getParameter("jobtype"));
			int JobCharge = Integer.parseInt(request.getParameter("jobsalary"));
			int JobCity = Integer.parseInt(request.getParameter("city"));
			int CompanyId = Integer.parseInt(request
					.getParameter("companyname"));
			String JobTechnology = MyStringUtlis.toUTFString(request,
					"jobskill");
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
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(test);
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			} else {
				// 插入失败
				MyError error = new MyError();
				error.setError("error");
				error.setObject(test);
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
				System.out.println("error");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
	private void delJob(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			int id = Integer.parseInt(req.getParameter("ids"));
			JobBiz job = new JobBizImpl();
			job.delJob(id);
			Job job2 = job.load(id);
			MyError error = new MyError();
			if (job2.getJobName()==null) {
				error.setError("ok");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			} else {
				error.setError("error");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 修改数据
	 * 
	 * @param req
	 * @param resp
	 */
	private void jobUpdate(HttpServletRequest request, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			
			int JobId = Integer.parseInt(request.getParameter("jobid"));
			String JobName = MyStringUtlis.toUTFString(request, "jobrname");
			String JobDetail = MyStringUtlis.toUTFString(request, "jobdetails");
			int JobType = Integer.parseInt(request.getParameter("jobtype"));
			int JobCharge = Integer.parseInt(request.getParameter("jobsalary"));
			int JobCity = Integer.parseInt(request.getParameter("city"));
			int CompanyId = Integer.parseInt(request
					.getParameter("companyname"));
			String JobTechnology = MyStringUtlis.toUTFString(request,
					"jobskill");
			JobBiz jb = new JobBizImpl();
			Job j = new Job();
			j.setJobId(JobId);
			j.setJobName(JobName);
			j.setJobDetail(JobDetail);
			j.setJobType(JobType);
			j.setJobCharge(JobCharge);
			j.setJobCity(JobCity);
			j.setCompanyId(CompanyId);
			j.setJobTechnology(JobTechnology);
			jb.jobUpdate(j,j.getJobId());
			Job job2 = jb.load(JobId);
			MyError error = new MyError();
			if (job2.getJobName().equals(j.getJobName())
					&& job2.getJobDetail().equals(j.getJobDetail())
					&& job2.getJobName().equals(j.getJobName())
					&& job2.getJobType() == j.getJobType()
					&& job2.getJobCharge() == j.getJobCharge()
					&& job2.getJobCity() == j.getJobCity()
					&& job2.getCompanyId() == j.getCompanyId()
					&& job2.getJobTechnology().equals(j.getJobTechnology())) {
				error.setError("ok");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			} else {
				error.setError("error");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
	private void selJob(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			JobBiz jb = new JobBizImpl();
			List<Job> list = jb.selAllJob();
			List<JobAndCompany> jobAndCompanies = new ArrayList<JobAndCompany>();
			CompanyBiz companyBiz = new CompanyBizImpl();
			for (int i = 0; i < list.size(); i++) {
				try {
					Job job = list.get(i);
					Company company = companyBiz.findCompanyByID(job.getCompanyId());
					JobAndCompany jc = new JobAndCompany(job.getJobId(), job.getJobName(), job.getJobDetail(), job.getJobType(), job.getJobCharge(), job.getJobCity(), company, job.getJobTechnology());
					jobAndCompanies.add(jc);
				
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (jobAndCompanies!=null&&jobAndCompanies.size()!=0) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(jobAndCompanies);
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			}else{
				MyError error = new MyError();
				error.setError("error");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 通过id查询
	 * 
	 * @param req
	 * @param resp
	 */
	private void load(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			int ids = Integer.parseInt(req.getParameter("ids"));
			JobBiz j = new JobBizImpl();
			Job job = j.load(ids);
			
			if (job != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(job);
				JSONObject jsonObject = JSONObject.fromObject(error);

				resp.getWriter().print(jsonObject);

			} else {
				MyError error = new MyError();
				error.setError("error");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 组合查询
	 * 
	 * @param req
	 * @param resp
	 */
	private void selSomeJob(HttpServletRequest request, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {String JobType=MyStringUtlis.toUTFString(request, "JobType");
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
		List<JobAndCompany> jobAndCompanies = new ArrayList<JobAndCompany>();
		CompanyBiz companyBiz = new CompanyBizImpl();
		for (int i = 0; i < jobs.size(); i++) {
			try {
				Job job = jobs.get(i);
				Company company = companyBiz.findCompanyByID(job.getCompanyId());
				JobAndCompany jc = new JobAndCompany(job.getJobId(), job.getJobName(), job.getJobDetail(), job.getJobType(), job.getJobCharge(), job.getJobCity(), company, job.getJobTechnology());
				jobAndCompanies.add(jc);
			
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (jobAndCompanies!=null&&jobs!=null) {
			MyError error = new MyError();
			error.setError("ok");
			error.setObject(jobAndCompanies);
			JSONObject jsonObject = JSONObject.fromObject(error);
			resp.getWriter().print(jsonObject);
		}else{
			MyError error = new MyError();
			error.setError("error");
			JSONObject jsonObject = JSONObject.fromObject(error);
			resp.getWriter().print(jsonObject);
		}
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
