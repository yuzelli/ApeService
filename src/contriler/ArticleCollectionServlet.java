package contriler;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import bean.ArticalCollection;
import bean.Article;
import bean.ArticleC;
import bean.CompanyPictures;
import bean.JobCollection;
import bean.MyError;
import bean.Success;
import biz.ArtCollectionBiz;
import biz.JobCollectionBiz;
import bizimpl.ArtCollectionBizImpl;

public class ArticleCollectionServlet extends HttpServlet {
	ArtCollectionBiz artCollBiz = new ArtCollectionBizImpl();

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
		if ("addArtColl".equals(type)) {
			addArtColl(req, resp);
			return;
		} else if ("deleteArtColl".equals(type)) {
			deleteArtColl(req, resp);
			return;
		} else if ("updateArtColl".equals(type)) {
			updateArtColl(req, resp);
			return;
		} else if ("findAllArtColl".equals(type)) {
			findAllArtColl(req, resp);
			return;
		} else if ("findArtCollByID".equals(type)) {
			findArtCollByID(req, resp);
			return;
		} else if ("findArtCollByCUserID".equals(type)) {
			findArtCollByCUserID(req, resp);
			return;
		}
	}

	/**
	 * 娣诲姞鏀惰棌
	 * 
	 * @param req
	 * @param resp
	 */
	private void addArtColl(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			int userInfoId = Integer.parseInt(req.getParameter("UserInfoId"));
			int articalId = Integer.parseInt(req.getParameter("ArticalId"));
			ArticalCollection ac = new ArticalCollection();
			ac.setUserId(userInfoId);
			ac.setArticalId(articalId);

			int acid = artCollBiz.addArtColl(ac);
			if (acid != -1) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("CollectionID", acid + "");
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
	 * 閫氳繃id鍒犻櫎鏀惰棌
	 * 
	 * @param req
	 * @param resp
	 */
	private void deleteArtColl(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			int acID = Integer.parseInt(req.getParameter("CollectionId"));
			boolean flag = artCollBiz.deleteArtColl(acID);
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
	 * 淇敼鏀惰棌淇℃伅
	 * 
	 * @param req
	 * @param resp
	 */
	private void updateArtColl(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			int acID = Integer.parseInt(req.getParameter("CollectionId"));
			int userInfoId = Integer.parseInt(req.getParameter("UserInfoId"));
			int articalId = Integer.parseInt(req.getParameter("ArticalId"));
			ArticalCollection ac = new ArticalCollection();
			ac.setCollectionId(acID);
			ac.setUserId(userInfoId);
			ac.setArticalId(articalId);

			ArticalCollection jc2 = artCollBiz.updateArtColl(ac);
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
	 * 鏌ヨ鎵�湁鐨勬敹钘忔枃绔�
	 * 
	 * @param req
	 * @param resp
	 */
	private void findAllArtColl(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			List<ArticalCollection> list = artCollBiz.findAllArtColl();
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
	 * 閫氳繃id鏌ユ敹钘忔枃绔�
	 * 
	 * @param req
	 * @param resp
	 */
	private void findArtCollByID(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			int acID = Integer.parseInt(req.getParameter("CollectionId"));
			ArticalCollection ac = artCollBiz.findArtCollByID(acID);
			if (ac != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(ac);
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
	 * 閫氳繃鐢ㄦ埛id鏌ョ敤鎴锋敹钘忕殑鏂囩珷
	 * 
	 * @param req
	 * @param resp
	 */
	private void findArtCollByCUserID(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			int userID = Integer.parseInt(req.getParameter("UserInfoId"));
			List<ArticleC> list = artCollBiz.findArtCollByCUserID(userID);
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
}
