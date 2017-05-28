package bizimpl;

import java.util.List;

import dao.CompanyResumeDao;
import daoimpl.CompanyResumeDaoImpl;
import bean.CompanyResume;
import biz.CompanyResumeBiz;

public class CompanyResumeBizImpl implements CompanyResumeBiz{
	CompanyResumeDao CompanyResumeDao = new CompanyResumeDaoImpl();

	@Override
	public int addCompanyResume(CompanyResume cr) throws Exception {
		// TODO Auto-generated method stub
		return CompanyResumeDao.addCompanyResume(cr);
	}

	@Override
	public boolean deleteCompanyResume(int crID) throws Exception {
		// TODO Auto-generated method stub
		return CompanyResumeDao.deleteCompanyResume(crID);
	}

	@Override
	public CompanyResume updateCompanyResume(CompanyResume cr) throws Exception {
		// TODO Auto-generated method stub
		return CompanyResumeDao.updateCompanyResume(cr);
	}

	@Override
	public List<CompanyResume> findCompanyResumes() throws Exception {
		// TODO Auto-generated method stub
		return CompanyResumeDao.findCompanyResumes();
	}

	@Override
	public CompanyResume findCompanyResumeleByID(Integer cID) throws Exception {
		// TODO Auto-generated method stub
		return CompanyResumeDao.findCompanyResumeleByID(cID);
	}

	@Override
	public List<CompanyResume> findCompanyResumeByCompID(Integer crID)
			throws Exception {
		// TODO Auto-generated method stub
		return CompanyResumeDao.findCompanyResumeByCompID(crID);
	}

	@Override
	public List<CompanyResume> findCompanyResumeByUserID(Integer uID)
			throws Exception {
		// TODO Auto-generated method stub
		return CompanyResumeDao.findCompanyResumeByUserID(uID);
	}


}
