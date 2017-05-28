package daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.UserException;

import bean.Article;
import bean.Company;
import bean.UserInfo;
import dao.ArtCollectionDao;
import dao.CompanyResumeDao;
import dao.JobCollectionDao;
import dao.UserInfoDao;
import db.DataBaseUtil;

public class UserInfoDaoImpl implements UserInfoDao{

	@Override
	public UserInfo registerUserInfo(UserInfo user) throws Exception {
		// TODO Auto-generated method stub
		 UserInfo userInfo= null;
		 
		 boolean flag = VerificationUserPhone(user.getUserPhoneNum());
		 if(flag){
			 return null;
		 }
		 
		try {
			String sqlStr = "insert into user (UserPhoneNum,UserPassword,UserHeadImg,"
					+ "UserTrueName,UserGender,"
					+ "UserAge,UserDegree,UserSchool,"
					+ "UserExpactMonney,UserExperence,UserAdvantage)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?)";
			int num = DataBaseUtil.executeUpdate(
					sqlStr,new Object[] {user.getUserPhoneNum(),
					  user.getUserPassword(),user.getUserHeadImg(),
					  user.getUserTrueName(),user.getUserGender(),
					  user.getUserAge(),user.getUserDegree(),user.getUserSchool(),
					  user.getUserExpactMonney(),user.getUserExperence(),user.getUserAdvantage()});
			if (num > 0) {
				List<UserInfo> userInfoList = findAllUserInfo();
				for (UserInfo userDB : userInfoList) {
					if (userDB.getUserPhoneNum().equals(user.getUserPhoneNum())
							&&userDB.getUserPassword().equals(user.getUserPassword())) {
						userInfo = userDB;
						break;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}

		return userInfo;
	}

	@Override
	public boolean deleteUserInfoByID(int userID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from user where UserId=?";
		
		JobCollectionDao jobCollDao = new JobCollectionDaoImpl();
		jobCollDao.delJobByUserId(userID);

		ArtCollectionDao artCollDao = new ArtCollectionDaoImpl();
		artCollDao.deleteArtCollByUserID(userID);
		
		CompanyResumeDao compResumeDao = new CompanyResumeDaoImpl();
		compResumeDao.deleteCompanyResumeByUserID(userID);
		
		
		boolean flag = false;
		try {
			int num  = DataBaseUtil.executeUpdate(sql, new Object[]{userID});
		    if(num>0){
		    	flag = true;
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConn();
		}
		
		return flag;
	}

	@Override
	public UserInfo updateUserInfoByID(int userID, UserInfo user) throws Exception
			 {
		// TODO Auto-generated method stub
		UserInfo userInfo = null;
		try {
		
		String sqlStr = "update user set UserPhoneNum=?,UserPassword=?,UserHeadImg=?,UserTrueName=?,UserGender=?,UserAge=?,UserDegree=?, UserSchool=?,UserExpactMonney=?,UserExperence=?,UserAdvantage=? where userid=?";
		
		int num = DataBaseUtil.executeUpdate(
					sqlStr,
					new Object[] {user.getUserPhoneNum(),
							  user.getUserPassword(),user.getUserHeadImg(),
							  user.getUserTrueName(),user.getUserGender(),
							  user.getUserAge(),user.getUserDegree(),user.getUserSchool(),
							  user.getUserExpactMonney(),user.getUserExperence(),user.getUserAdvantage(),userID });
		if(num>0){    
		userInfo = findUserInfoByID(userID);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConn();
		}
				
		return userInfo;
	}

	@Override
	public List<UserInfo> findAllUserInfo() throws Exception {
		// TODO Auto-generated method stub
		List<UserInfo> usersList = new ArrayList<UserInfo>();
		try {
			String sqlStr = "select * from user";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStr, null);

			while (rs.next()) {
				UserInfo user = new UserInfo();
				user.setUserId(rs.getInt("UserId"));
				user.setUserPhoneNum(rs.getString("UserPhoneNum"));
				user.setUserPassword(rs.getString("UserPassword"));
				user.setUserHeadImg(rs.getString("UserHeadImg"));
				user.setUserTrueName(rs.getString("UserTrueName"));
				user.setUserGender(rs.getString("UserGender"));
				user.setUserAge(rs.getInt("UserAge"));
				user.setUserDegree(rs.getInt("UserDegree"));
				user.setUserSchool(rs.getString("UserSchool"));
				user.setUserExpactMonney(rs.getInt("UserExpactMonney"));
				user.setUserExperence(rs.getString("UserExperence"));
				user.setUserAdvantage(rs.getString("UserAdvantage")); 	
				usersList.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBaseUtil.closeConn();
		}
		return usersList;
	}

	/* (non-Javadoc)
	 * @see dao.UserInfoDao#findUserInfoByID(int)
	 */
	@Override
	public UserInfo findUserInfoByID(int userID) throws Exception {
		// TODO Auto-generated method stub
		UserInfo user = null;
		
		try {
			String sqlStrid = "select * from user where UserId=?";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStrid,
					new Object[] { userID });
			while (rs.next()) {
				user = new UserInfo();
				user.setUserId(rs.getInt("UserId"));
				user.setUserPhoneNum(rs.getString("UserPhoneNum"));
				user.setUserPassword(rs.getString("UserPassword"));
				user.setUserHeadImg(rs.getString("UserHeadImg"));
				user.setUserTrueName(rs.getString("UserTrueName"));
				user.setUserGender(rs.getString("UserGender"));
				user.setUserAge(rs.getInt("UserAge"));
				user.setUserDegree(rs.getInt("UserDegree"));
				user.setUserSchool(rs.getString("UserSchool"));
				user.setUserExpactMonney(rs.getInt("UserExpactMonney"));
				user.setUserExperence(rs.getString("UserExperence"));
				user.setUserAdvantage(rs.getString("UserAdvantage")); 	
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}
		return user;
	}

	@Override
	public UserInfo LoginUserInfo(String phone, String passWord)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			List<UserInfo> uList = findAllUserInfo();
			for (UserInfo u : uList) {
				if(u.getUserPhoneNum().equals(phone)&&
						u.getUserPassword().equals(passWord)){
					return u;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConn();
		}
		return null;
	}

	@Override
	public boolean VerificationUserPhone(String phone) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		List<UserInfo> userList = findAllUserInfo();
		List<Company> companyList = new CompanyDaoImpl().findAllCompany();
		
		for(UserInfo user : userList){
			if(user.getUserPhoneNum().equals(phone)){
				flag = true;
			}
		}
		for(Company comp : companyList){
			if(comp.getCompanyNum().equals(phone)){
				flag = true;
			}	
		}
		return flag;
	}
	
}
