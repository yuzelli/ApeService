package dao;

import java.util.List;

import bean.Article;
import bean.CompanyResume;

public interface CompanyResumeDao {
	//澧�
		public int addCompanyResume(CompanyResume cr) throws Exception;

	    //鍒�
		public boolean deleteCompanyResume(int crID) throws Exception;
		
		//鏀�
		public CompanyResume updateCompanyResume(CompanyResume cr) throws Exception;
		
		//鏌�
		public List<CompanyResume> findCompanyResumes() throws Exception;
		public CompanyResume findCompanyResumeleByID(Integer cID) throws Exception;
		//鍏徃id鏌�
		public List<CompanyResume> findCompanyResumeByCompID(Integer crID) throws Exception;
		//鐢ㄦ埛id鏌�
		public List<CompanyResume> findCompanyResumeByUserID(Integer uID) throws Exception;

		public boolean deleteCompanyResumeByUserID(int userID) throws Exception;
		
		public boolean deleteCompanyResumeByJobID(int jobID) throws Exception;
		
		public boolean deleteCompanyResumeByCompanyID(int cID) throws Exception;
}
