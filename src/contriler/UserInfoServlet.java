package contriler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.MyStringUtlis;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import bean.MyError;
import bean.Success;
import bean.UserInfo;
import biz.UserInfoBiz;
import bizimpl.UserInfoBizImpl;

public class UserInfoServlet extends HttpServlet {

	UserInfoBiz userInfoBiz = new UserInfoBizImpl();

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
		if ("register".equals(type)) {
			registerUserInfo(req, resp);
			return;
		} else if ("login".equals(type)) {
			Login(req, resp);
			return;
		} else if ("deleteUser".equals(type)) {
			deleteUserInfoByID(req, resp);
			return;
		} else if ("updateUser".equals(type)) {
			updateUserInfoByID(req, resp);
			return;
		} else if ("findUser".equals(type)) {
			findUserInfoByID(req, resp);
			return;
		} else if ("findAllUser".equals(type)) {
			findAllUser(req, resp);
			return;
		}
	}

	private void findAllUser(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			List<UserInfo> list = userInfoBiz.findAllUserInfo();
			
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
	 * 登陆用户
	 * 
	 * @param req
	 * @param resp
	 */
	private void Login(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			String phone = req.getParameter("phone");
			String passWord = req.getParameter("passWord");

			UserInfo userInfo = userInfoBiz.LoginUserInfo(phone, passWord);
			if (userInfo != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(userInfo);
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
	 * 注册用户
	 * 
	 * @param req
	 * @param resp
	 */
	private void registerUserInfo(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			String userPhoneNum = req.getParameter("UserPhoneNum");
			String userPassword = req.getParameter("UserPassword");
			String userHeadImg = req.getParameter("UserHeadImg");
			String userTrueName = MyStringUtlis.toUTFString(req, "UserTrueName");
			String userGender = MyStringUtlis.toUTFString(req, "UserGender");
			int userAge = Integer.parseInt(req.getParameter("UserAge"));
			int userDegree = Integer.parseInt(req.getParameter("UserDegree"));
			String userSchool = req.getParameter("UserSchool");
			int userExpactMonney = Integer.parseInt(req
					.getParameter("UserExpactMonney"));
			String userExperence = MyStringUtlis.toUTFString(req, "UserExperence"); 
			String userAdvantage = MyStringUtlis.toUTFString(req, "UserAdvantage"); 
			
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

			UserInfo userInfo2 = userInfoBiz.registerUserInfo(userInfo);
			if (userInfo2 != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(userInfo2);
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
	 * 删除用户
	 * 
	 * @param req
	 * @param resp
	 */
	private void deleteUserInfoByID(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
		try {
			
			int userID = Integer.parseInt(req.getParameter("userID"));
			boolean flag = userInfoBiz.deleteUserInfoByID(userID);
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
	 * 更新用户
	 * 
	 * @param req
	 * @param resp
	 */
	private void updateUserInfoByID(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
		try {
			int userID = Integer.parseInt(req.getParameter("userID"));
			String userPhoneNum = req.getParameter("UserPhoneNum");
			String userPassword = req.getParameter("UserPassword");
			String userHeadImg = req.getParameter("UserHeadImg");
			String userTrueName =  MyStringUtlis.toUTFString(req, "UserTrueName");
			String userGender = MyStringUtlis.toUTFString(req, "UserGender");
			int userAge = Integer.parseInt(req.getParameter("UserAge"));
			int userDegree = Integer.parseInt(req.getParameter("UserDegree"));
			String userSchool = MyStringUtlis.toUTFString(req, "UserSchool");
			int userExpactMonney = Integer.parseInt(req
					.getParameter("UserExpactMonney"));
			String userExperence = MyStringUtlis.toUTFString(req, "UserExperence");
			String userAdvantage = MyStringUtlis.toUTFString(req, "UserAdvantage");
			
			UserInfo userInfo = new UserInfo();
			userInfo.setUserId(userID);
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
			UserInfo user = userInfoBiz.updateUserInfoByID(userID, userInfo);
			if (user != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(user);
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
	 * 通过id找到用户
	 * 
	 * @param req
	 * @param resp
	 */
	private void findUserInfoByID(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
		try {
			int userID = Integer.parseInt(req.getParameter("userID"));
			UserInfo userInfo  = userInfoBiz.findUserInfoByID(userID);
			if (userInfo != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(userInfo);
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
