package dao;

import java.util.List;

import bean.CompanyPictures;
import bean.Job;
import bean.JobAndCompanyC;
import bean.JobCollection;

public interface JobCollectionDao {
	// 澧�
	public int addJobColl(JobCollection jc) throws Exception;

	// 鍒�
	public boolean deleteJobColl(int jcID) throws Exception;

	// 鏀�
	public JobCollection updateJobColl(JobCollection jc) throws Exception;

	// 鏌�
	public List<JobCollection> findAllJobColl() throws Exception;

	public JobCollection findJobCollByID(int jcID) throws Exception;

	// 閫氳繃鐢ㄦ埛id鏌ユ墍鏈�
	public List<JobAndCompanyC> findJobCollByUserID(int userID) throws Exception;
	
	public boolean delJobByUserId(int userID) throws Exception;  //通过userid删
	public boolean delJobByJobId(int jobID) throws Exception;  //通过jobid删

}
