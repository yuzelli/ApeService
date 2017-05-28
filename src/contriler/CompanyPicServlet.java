package contriler;

import java.io.IOException;
import java.lang.reflect.Array;
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
import bean.CompanyPictures;
import bean.MyError;
import bean.Success;
import biz.CompanyPicBiz;
import bizimpl.CompanyPicBizImpl;

public class CompanyPicServlet extends HttpServlet {

	CompanyPicBiz companyPicBiz = new CompanyPicBizImpl();

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
		if ("addPic".equals(type)) {
			addPic(req, resp);
			return;
		} else if ("deletePic".equals(type)) {
			deletePic(req, resp);
			return;
		} else if ("updatePic".equals(type)) {
			updatePic(req, resp);
			return;
		} else if ("findAllPic".equals(type)) {
			findAllPic(req, resp);
			return;
		} else if ("findPicByID".equals(type)) {
			findPicByID(req, resp);
			return;
		} else if ("findPicByCompID".equals(type)) {
			findPicByCompID(req, resp);
			return;
		}
	}

	/**
	 * 鏌ヨ鍏徃鐨勬墍鏈夊浘鐗�
	 * 
	 * @param req
	 * @param resp
	 */
	private void findPicByCompID(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
		try {
			int cID = Integer.parseInt(req.getParameter("CompanyId"));
			List<CompanyPictures> list = companyPicBiz.findPicByCompID(cID);
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
	 * 鏌ヨ鍗曚釜
	 * 
	 * @param req
	 * @param resp
	 */
	private void findPicByID(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	    try {
	    	int cpID = Integer.parseInt(req.getParameter("PictureId"));
			CompanyPictures cp = companyPicBiz.findPicByID(cpID);
			if (cp != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(cp);
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
	 * 鏌ヨ鎵�湁
	 * 
	 * @param req
	 * @param resp
	 */
	private void findAllPic(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			List<CompanyPictures> list = companyPicBiz.findAllPic();
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
	 * 鏇存敼鍥剧墖
	 * 
	 * @param req
	 * @param resp
	 */
	private void updatePic(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			int cpID = Integer.parseInt(req.getParameter("PictureId"));
			String pictureURL = req.getParameter("PictureURL");
			int companyId = Integer.parseInt(req.getParameter("CompanyId"));
			CompanyPictures cp = new CompanyPictures();
			cp.setPictureId(cpID);
			cp.setPictureURL(pictureURL);
			cp.setCompanyId(companyId);

			CompanyPictures cp2 = companyPicBiz.updatePic(cp);
			if (cp2 != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(cp2);
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
	 * 鍒犻櫎鍥剧墖
	 * 
	 * @param req
	 * @param resp
	 */
	private void deletePic(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

		try {
			int cpID = Integer.parseInt(req.getParameter("PictureId"));
			boolean flag = companyPicBiz.deletePic(cpID);
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
	 * 娣诲姞鍥剧墖
	 * 
	 * @param req
	 * @param resp
	 */
	private void addPic(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			String pictureURL = req.getParameter("PictureURL");
			int companyId = Integer.parseInt(req.getParameter("CompanyId"));
			
			List<String> list = new ArrayList<String>();
			char [] strs = pictureURL.toCharArray();
			int begin = 0;
		
			for(int i = 0 ; i < strs.length;i++){
				if(strs[i]==';'){
					list.add(pictureURL.substring(begin,i));
					begin = i+1;
				}
			}
			list.add(pictureURL.substring(begin,pictureURL.length()));
			int cpid = -1;
			for(int i = 0 ; i < list.size();i++){
				CompanyPictures cp = new CompanyPictures();
				cp.setPictureURL(list.get(i));
				cp.setCompanyId(companyId);
				cpid = companyPicBiz.addPic(cp);
			}
			
			

			
			if (cpid != -1) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("PictureId", cpid + "");
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
