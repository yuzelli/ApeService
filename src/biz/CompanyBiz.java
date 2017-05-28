package biz;

import java.util.List;

import bean.Company;

public interface CompanyBiz {
	 //注册
	public Company registerCompany(Company company)throws Exception;
	//删
	public boolean deleteCompanyByID(int companyID) throws Exception;
	//改
	public Company updateCompanyByID(int companyID,Company company)throws Exception;
	//查
	public List<Company> findAllCompany() throws Exception;
	
	public Company findCompanyByID(int companyID)throws Exception;
	//登陆
	public Company LoginCompany(String companyNum,String passWord)throws Exception;
}
