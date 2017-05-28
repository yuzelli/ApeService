package biz;

import java.util.List;

import bean.CompanyResume;

public interface CompanyResumeBiz {
	// 增
	public int addCompanyResume(CompanyResume cr) throws Exception;

	// 删
	public boolean deleteCompanyResume(int crID) throws Exception;

	// 改
	public CompanyResume updateCompanyResume(CompanyResume cr) throws Exception;

	// 查
	public List<CompanyResume> findCompanyResumes() throws Exception;

	public CompanyResume findCompanyResumeleByID(Integer cID) throws Exception;

	// 公司id查
	public List<CompanyResume> findCompanyResumeByCompID(Integer crID)
			throws Exception;

	// 用户id查
	public List<CompanyResume> findCompanyResumeByUserID(Integer uID)
			throws Exception;

}
