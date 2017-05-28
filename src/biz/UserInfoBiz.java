package biz;

import java.util.List;

import bean.UserInfo;

public interface UserInfoBiz {
	//注册
		public UserInfo registerUserInfo(UserInfo user)throws Exception;
		//删
		public boolean deleteUserInfoByID(int userID) throws Exception;
		//改
		public UserInfo updateUserInfoByID(int userID,UserInfo user)throws Exception;
		//查
		public List<UserInfo> findAllUserInfo() throws Exception;
		
		public UserInfo findUserInfoByID(int userID)throws Exception;

		public UserInfo LoginUserInfo(String phone,String passWord)throws Exception;

}
