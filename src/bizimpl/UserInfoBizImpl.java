package bizimpl;

import java.util.List;

import dao.UserInfoDao;
import daoimpl.UserInfoDaoImpl;
import bean.UserInfo;
import biz.UserInfoBiz;

public class UserInfoBizImpl implements UserInfoBiz {
	UserInfoDao userInfoDao = new UserInfoDaoImpl();
	@Override
	public UserInfo registerUserInfo(UserInfo user) throws Exception {
		// TODO Auto-generated method stub
		return userInfoDao.registerUserInfo(user);
	}

	@Override
	public boolean deleteUserInfoByID(int userID) throws Exception {
		// TODO Auto-generated method stub
		return userInfoDao.deleteUserInfoByID(userID);
	}

	@Override
	public UserInfo updateUserInfoByID(int userID, UserInfo user)
			throws Exception {
		// TODO Auto-generated method stub
		return userInfoDao.updateUserInfoByID(userID, user);
	}

	@Override
	public List<UserInfo> findAllUserInfo() throws Exception {
		// TODO Auto-generated method stub
		return userInfoDao.findAllUserInfo();
	}

	@Override
	public UserInfo findUserInfoByID(int userID) throws Exception {
		// TODO Auto-generated method stub
		return userInfoDao.findUserInfoByID(userID);
	}

	@Override
	public UserInfo LoginUserInfo(String phone, String passWord)
			throws Exception {
		// TODO Auto-generated method stub
		return userInfoDao.LoginUserInfo(phone, passWord);
	}

}
