package dao;



import java.util.List;

import bean.Company;
import bean.UserInfo;

public interface UserInfoDao {
	//娉ㄥ唽
	public UserInfo registerUserInfo(UserInfo user)throws Exception;
	//鍒�
	public boolean deleteUserInfoByID(int userID) throws Exception;
	//鏀�
	public UserInfo updateUserInfoByID(int userID,UserInfo user)throws Exception;
	//鏌�
	public List<UserInfo> findAllUserInfo() throws Exception;
	
	public UserInfo findUserInfoByID(int userID)throws Exception;

	public UserInfo LoginUserInfo(String phone,String passWord)throws Exception;
	
	public boolean VerificationUserPhone(String phone) throws Exception;
}
