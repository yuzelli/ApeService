package contriler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import bean.Company;
import bean.CompanyPictures;
import bean.CompanyResume;
import bean.Job;
import bean.MyError;
import bean.Success;
import bean.UserCompJob;
import bean.UserInfo;
import biz.CompanyBiz;
import biz.CompanyResumeBiz;
import biz.JobBiz;
import biz.UserInfoBiz;
import bizimpl.CompanyBizImpl;
import bizimpl.CompanyResumeBizImpl;
import bizimpl.JobBizImpl;
import bizimpl.UserInfoBizImpl;

public class CompanyResumeServlet extends HttpServlet {
	CompanyResumeBiz biz = new CompanyResumeBizImpl();

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
		// 鍒ゆ柇
		String type = req.getParameter("type");
		if ("addCompanyResume".equals(type)) {
			addCompanyResume(req, resp);
			return;
		} else if ("deleteCompanyResume".equals(type)) {
			deleteCompanyResume(req, resp);
			return;
		} else if ("updateCompanyResume".equals(type)) {
			updateCompanyResume(req, resp);
			return;
		} else if ("findCompanyResumes".equals(type)) {
			findCompanyResumes(req, resp);
			return;
		} else if ("findCompanyResumeleByID".equals(type)) {
			findCompanyResumeleByID(req, resp);
			return;
		} else if ("findCompanyResumeByCompID".equals(type)) {
			findCompanyResumeByCompID(req, resp);
			return;
		} else if ("findCompanyResumeByUserID".equals(type)) {
			findCompanyResumeByUserID(req, resp);
			return;
		}
	}

	/**
	 * 娣诲姞
	 * 
	 * @param req
	 * @param resp
	 */
	private void addCompanyResume(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			int jobId = Integer.parseInt(req.getParameter("jobId"));
			int userId = Integer.parseInt(req.getParameter("userId"));
			int companyId = Integer.parseInt(req.getParameter("companyId"));
			CompanyResume cr = new CompanyResume();
			cr.setJobId(jobId);
			cr.setUserId(userId);
			cr.setCompanyId(companyId);

			int crid = biz.addCompanyResume(cr);
			if (crid != -1) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("crId", crid + "");
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

	/**
	 * 鍒犻櫎
	 * 
	 * @param req
	 * @param resp
	 */
	private void deleteCompanyResume(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			int crID = Integer.parseInt(req.getParameter("resume_id"));
			boolean flag = biz.deleteCompanyResume(crID);
			Success success = new Success();
			success.setFlag(flag);
			JSONObject jsonObject = JSONObject.fromObject(success);
			resp.getWriter().print(jsonObject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 鏇存柊
	 * 
	 * @param req
	 * @param resp
	 */
	private void updateCompanyResume(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			int resume_id = Integer.parseInt(req.getParameter("resume_id"));
			int jobId = Integer.parseInt(req.getParameter("jobId"));
			int userId = Integer.parseInt(req.getParameter("userId"));
			int companyId = Integer.parseInt(req.getParameter("companyId"));
			CompanyResume cr = new CompanyResume();
			cr.setResume_id(resume_id);
			cr.setJobId(jobId);
			cr.setUserId(userId);
			cr.setCompanyId(companyId);

			CompanyResume cr2 = biz.updateCompanyResume(cr);
			if (cr2 != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(cr2);
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
	 * 鏌ユ墍鏈�
	 * 
	 * @param req
	 * @param resp
	 */
	private void findCompanyResumes(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			List<CompanyResume> crs = biz.findCompanyResumes();
			List<UserCompJob> list = null;
			JobBiz jb = new JobBizImpl();
			UserInfoBiz userInfoBiz = new UserInfoBizImpl();
			CompanyBiz companyBiz = new CompanyBizImpl();
			
			for (int i = 0; i < crs.size(); i++) {
				list = new ArrayList<UserCompJob>();
				UserInfo userInfo = userInfoBiz.findUserInfoByID(crs.get(i).getUserId());
				Job job = jb.load(crs.get(i).getJobId());
				Company company = companyBiz.findCompanyByID(crs.get(i).getCompanyId());
				UserCompJob ucj = new UserCompJob(crs.get(i).getResume_id(), userInfo, job, company);
				list.add(ucj);
			}
			
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
	 * 閫氳繃id鏌�
	 * 
	 * @param req
	 * @param resp
	 */
	private void findCompanyResumeleByID(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
	    	int cID = Integer.parseInt(req.getParameter("resume_id"));
	    	CompanyResume cr = biz.findCompanyResumeleByID(cID);
			if (cr != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(cr);
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
	 * 閫氳繃鍏徃id鏌�
	 * 
	 * @param req
	 * @param resp
	 */
	private void findCompanyResumeByCompID(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			int companyId = Integer.parseInt(req.getParameter("companyId"));
			List<CompanyResume> crs = biz.findCompanyResumeByCompID(companyId);
			List<UserCompJob> list = null;
			JobBiz jb = new JobBizImpl();
			UserInfoBiz userInfoBiz = new UserInfoBizImpl();
			CompanyBiz companyBiz = new CompanyBizImpl();
			
			list = new ArrayList<UserCompJob>();
			for (int i = 0; i < crs.size(); i++) {
				UserInfo userInfo = userInfoBiz.findUserInfoByID(crs.get(i).getUserId());
				Job job = jb.load(crs.get(i).getJobId());
				Company company = companyBiz.findCompanyByID(crs.get(i).getCompanyId());
				UserCompJob ucj = new UserCompJob(crs.get(i).getResume_id(), userInfo, job, company);
				
				list.add(ucj);
			}
			
			if (list != null&&crs!=null) {
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
	 * 閫氳繃鐢ㄦ埛id鏌�
	 * 
	 * @param req
	 * @param resp
	 */
	private void findCompanyResumeByUserID(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			int userId = Integer.parseInt(req.getParameter("userId"));
			List<CompanyResume> crs = biz.findCompanyResumeByUserID(userId);
			List<UserCompJob> list = null;
			JobBiz jb = new JobBizImpl();
			UserInfoBiz userInfoBiz = new UserInfoBizImpl();
			CompanyBiz companyBiz = new CompanyBizImpl();
			list = new ArrayList<UserCompJob>();
			for (int i = 0; i < crs.size(); i++) {
				
				UserInfo userInfo = userInfoBiz.findUserInfoByID(crs.get(i).getUserId());
				Job job = jb.load(crs.get(i).getJobId());
				Company company = companyBiz.findCompanyByID(crs.get(i).getCompanyId());
				UserCompJob ucj = new UserCompJob(crs.get(i).getResume_id(), userInfo, job, company);
				list.add(ucj);
			}
			
			if (list != null&&crs!=null) {
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
}
