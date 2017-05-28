package dao;

import java.util.List;

import bean.Company;
import bean.UserInfo;

public interface CompanyDao {
	    //娉ㄥ唽
		public Company registerCompany(Company company)throws Exception;
		//鍒�
		public boolean deleteCompanyByID(int companyID) throws Exception;
		//鏀�
		public Company updateCompanyByID(int companyID,Company company)throws Exception;
		//鏌�
		public List<Company> findAllCompany() throws Exception;
		
		public Company findCompanyByID(int companyID)throws Exception;
		
		//鐧婚檰
		public Company LoginCompany(String companyNum,String passWord)throws Exception;

		public boolean VerificationCompanyPhone(String phone) throws Exception;
}
