package daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Company;
import bean.UserInfo;
import dao.CompanyDao;
import dao.CompanyPicDao;
import dao.CompanyResumeDao;
import db.DataBaseUtil;

public class CompanyDaoImpl implements CompanyDao{

	@Override
	public Company registerCompany(Company company) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = VerificationCompanyPhone(company.getCompanyNum());
		if(flag){
			return null;
		}
		
		Company comp= null;
			try {
				String sqlStr = "insert into company (CompanyNum,CompanyPassword,CompanyHeadImg,CompanyName,CompanyAddress,CompanyIntroduce,CompanyScale) values(?,?,?,?,?,?,?)";
				int num = DataBaseUtil.executeUpdate(
						sqlStr,new Object[] {company.getCompanyNum(),company.getCompanyPassword(),company.getCompanyHeadImg()
								,company.getCompanyName(),company.getCompanyAddress(),company.getCompanyIntroduce(),company.getCompanyScale()});
				if (num > 0) {
					List<Company> companyList = findAllCompany();
					for (Company companyDB : companyList) {
						if (companyDB.getCompanyNum().equals(company.getCompanyNum())
								&&companyDB.getCompanyPassword().equals(company.getCompanyPassword())) {
							comp = companyDB;
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

			return comp;
	}

	@Override
	public boolean deleteCompanyByID(int companyID) throws Exception {
		// TODO Auto-generated method stub
		CompanyPicDao cpDao = new CompanyPicDaoImpl();
		cpDao.deletePicByCompanyID(companyID);
		
		CompanyResumeDao crDao = new CompanyResumeDaoImpl();
		crDao.deleteCompanyResumeByCompanyID(companyID);		
		String sql = "delete from company where CompanyId=?";
		boolean flag = false;
		try {
			int num  = DataBaseUtil.executeUpdate(sql, new Object[]{companyID});
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
	public Company updateCompanyByID(int companyID, Company company)
			throws Exception {
		// TODO Auto-generated method stub
		Company comp = null;
		try {
		
		String sqlStr = "update company set CompanyNum=?,CompanyPassword=?,CompanyHeadImg=?,CompanyName=?,CompanyAddress=?,CompanyIntroduce=?,CompanyScale=? where CompanyId=?";
		
		int num = DataBaseUtil.executeUpdate(
					sqlStr,
					new Object[] { company.getCompanyNum(),company.getCompanyPassword(),company.getCompanyHeadImg()
							,company.getCompanyName(),company.getCompanyAddress(),company.getCompanyIntroduce(),company.getCompanyScale(),companyID});
		if(num>0){    
			comp = findCompanyByID(companyID);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConn();
		}
				
		return comp;
	}

	@Override
	public List<Company> findAllCompany() throws Exception {
		// TODO Auto-generated method stub
		List<Company> companyList = new ArrayList<Company>();
		try {
			String sqlStr = "select * from company";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStr, null);

			while (rs.next()) {
				Company company = new Company();
				company.setCompanyId(rs.getInt("CompanyId"));
				company.setCompanyNum(rs.getString("CompanyNum"));
				company.setCompanyPassword(rs.getString("CompanyPassword"));
				company.setCompanyHeadImg(rs.getString("CompanyHeadImg"));
				company.setCompanyName(rs.getString("CompanyName"));
				company.setCompanyAddress(rs.getString("CompanyAddress"));
				company.setCompanyIntroduce(rs.getString("CompanyIntroduce"));
				company.setCompanyScale(rs.getInt("CompanyScale"));
				companyList.add(company);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBaseUtil.closeConn();
		}
		return companyList;
	}

	@Override
	public Company findCompanyByID(int companyID) throws Exception {
		// TODO Auto-generated method stub
		Company company = null;
		
		try {
			String sqlStrid = "select * from company where CompanyId=?";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStrid,
					new Object[] { companyID });
			while (rs.next()) {
				company = new Company();
				company.setCompanyId(rs.getInt("CompanyId"));
				company.setCompanyNum(rs.getString("CompanyNum"));
				company.setCompanyPassword(rs.getString("CompanyPassword"));
				company.setCompanyHeadImg(rs.getString("CompanyHeadImg"));
				company.setCompanyName(rs.getString("CompanyName"));
				company.setCompanyAddress(rs.getString("CompanyAddress"));
				company.setCompanyIntroduce(rs.getString("CompanyIntroduce"));
				company.setCompanyScale(rs.getInt("CompanyScale"));
			
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}
		return company;
	}

	@Override
	public Company LoginCompany(String companyNum, String passWord) throws Exception
			{
		// TODO Auto-generated method stub
	
		try {
			List<Company> cList = findAllCompany();
			for (Company c : cList) {
				if(c.getCompanyNum().equals(companyNum)&&
						c.getCompanyPassword().equals(passWord)){
					return c;
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
	public boolean VerificationCompanyPhone(String phone) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		List<Company> companyList = findAllCompany();
		List<UserInfo> userList = new UserInfoDaoImpl().findAllUserInfo();
		
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
