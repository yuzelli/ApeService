package bizimpl;

import java.util.List;

import dao.CompanyDao;
import daoimpl.CompanyDaoImpl;
import bean.Company;
import biz.CompanyBiz;

public class CompanyBizImpl implements CompanyBiz {
	CompanyDao companyDao = new CompanyDaoImpl();

	@Override
	public Company registerCompany(Company company) throws Exception {
		// TODO Auto-generated method stub
		return companyDao.registerCompany(company);
	}

	@Override
	public boolean deleteCompanyByID(int companyID) throws Exception {
		// TODO Auto-generated method stub
		return companyDao.deleteCompanyByID(companyID);
	}

	@Override
	public Company updateCompanyByID(int companyID, Company company)
			throws Exception {
		// TODO Auto-generated method stub
		return companyDao.updateCompanyByID(companyID, company);
	}

	@Override
	public List<Company> findAllCompany() throws Exception {
		// TODO Auto-generated method stub
		return companyDao.findAllCompany();
	}

	@Override
	public Company findCompanyByID(int companyID) throws Exception {
		// TODO Auto-generated method stub
		return companyDao.findCompanyByID(companyID);
	}

	@Override
	public Company LoginCompany(String companyNum, String passWord)
			throws Exception {
		// TODO Auto-generated method stub
		return companyDao.LoginCompany(companyNum, passWord);
	}

}
