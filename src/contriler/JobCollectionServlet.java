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
import bean.Article;
import bean.Company;
import bean.CompanyPictures;
import bean.Job;
import bean.JobAndCompany;
import bean.JobAndCompanyC;
import bean.JobCollection;
import bean.MyError;
import bean.Success;
import biz.CompanyBiz;
import biz.JobCollectionBiz;
import bizimpl.CompanyBizImpl;
import bizimpl.JobCollectionBizImpl;

public class JobCollectionServlet extends HttpServlet{
	
	JobCollectionBiz jobCollBiz = new JobCollectionBizImpl();
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
	 		if ("addJobColl".equals(type)) {
	 			addJobColl(req, resp);
	 			return;
	 		} else if ("deleteJobColl".equals(type)) {
	 			deleteJobColl(req, resp);
	 			return;
	 		} else if ("updateJobColl".equals(type)) {
	 			updateJobColl(req, resp);
	 			return;
	 		} else if ("findAllJobColl".equals(type)) {
	 			findAllJobColl(req, resp);
	 			return;
	 		} else if ("findJobCollByID".equals(type)) {
	 			findJobCollByID(req, resp);
	 			return;
	 		} else if ("findJobCollByUserID".equals(type)) {
	 			findJobCollByUserID(req, resp);
	 			return;
	 		}
	 	}
	 	/**
	 	 * 娣诲姞
	 	 * @param req
	 	 * @param resp
	 	 */
	 	private void addJobColl(HttpServletRequest req, HttpServletResponse resp) {
			// TODO Auto-generated method stub
	 		try {
	 			int userInfoId = Integer.parseInt(req.getParameter("UserInfoId"));
				int jobID = Integer.parseInt(req.getParameter("jobID"));
				JobCollection jc = new JobCollection();
			
				jc.setUserId(userInfoId);
				jc.setJobId(jobID);

				int jcid = jobCollBiz.addJobColl(jc);
				if (jcid != -1) {
					Map<String, String> map = new HashMap<String, String>();
					map.put("CollectionID", jcid + "");
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
	 	 * @param req
	 	 * @param resp
	 	 */
	 	private void deleteJobColl(HttpServletRequest req,
				HttpServletResponse resp) {
			// TODO Auto-generated method stub
	 		try {
				int jcID = Integer.parseInt(req.getParameter("CollectionId"));
				boolean flag = jobCollBiz.deleteJobColl(jcID);
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
	 	 * 鏇存柊job鏀惰棌
	 	 * @param req
	 	 * @param resp
	 	 */
	 	private void updateJobColl(HttpServletRequest req,
				HttpServletResponse resp) {
			// TODO Auto-generated method stub
	 		try {
	 			int jcID = Integer.parseInt(req.getParameter("CollectionId"));
	 			int userInfoId = Integer.parseInt(req.getParameter("UserInfoId"));
				int jobID = Integer.parseInt(req.getParameter("JobId"));
				JobCollection jc = new JobCollection();
				jc.setCollectionId(jcID);
				jc.setUserId(userInfoId);
				jc.setJobId(jobID);
				
				JobCollection jc2 = jobCollBiz.updateJobColl(jc);
				if (jc2 != null) {
					MyError error = new MyError();
					error.setError("ok");
					error.setObject(jc2);
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
	 	 * 鏌ヨ鎵�湁鏀惰棌宸ヤ綔
	 	 * @param req
	 	 * @param resp
	 	 */
	 	private void findAllJobColl(HttpServletRequest req,
				HttpServletResponse resp) {
			// TODO Auto-generated method stub
	 		try {
				List<JobCollection> list = jobCollBiz.findAllJobColl();
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
	 	 * 閫氳繃id鎵惧伐浣�
	 	 * @param req
	 	 * @param resp
	 	 */
        private void findJobCollByID(HttpServletRequest req,
				HttpServletResponse resp) {
			// TODO Auto-generated method stub
        	 try {
     	    	int jcID = Integer.parseInt(req.getParameter("CollectionId"));
     	    	JobCollection jc = jobCollBiz.findJobCollByID(jcID);
     			if (jc != null) {
     				MyError error = new MyError();
					error.setError("ok");
					error.setObject(jc);
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
         * 鏌ヨ鐢ㄦ埛鐨勬敹钘忕殑宸ヤ綔
         * @param req
         * @param resp
         */
		private void findJobCollByUserID(HttpServletRequest req,
				HttpServletResponse resp) {
			// TODO Auto-generated method stub
			try {
				int userID = Integer.parseInt(req.getParameter("UserInfoId"));
				List<JobAndCompanyC> list = jobCollBiz.findJobCollByUserID(userID);				
				if (list != null&&list.size()!=0) {
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
