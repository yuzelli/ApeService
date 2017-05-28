package bizimpl;

import java.util.List;

import dao.JobCollectionDao;
import daoimpl.JobCollectionDaoImpl;
import bean.Job;
import bean.JobAndCompanyC;
import bean.JobCollection;
import biz.JobCollectionBiz;

public class JobCollectionBizImpl implements JobCollectionBiz {
	
	JobCollectionDao jobCollDao = new JobCollectionDaoImpl();

	@Override
	public int addJobColl(JobCollection jc) throws Exception {
		// TODO Auto-generated method stub
		return jobCollDao.addJobColl(jc);
	}

	@Override
	public boolean deleteJobColl(int jcID) throws Exception {
		// TODO Auto-generated method stub
		return jobCollDao.deleteJobColl(jcID);
	}

	@Override
	public JobCollection updateJobColl(JobCollection jc) throws Exception {
		// TODO Auto-generated method stub
		return jobCollDao.updateJobColl(jc);
	}

	@Override
	public List<JobCollection> findAllJobColl() throws Exception {
		// TODO Auto-generated method stub
		return jobCollDao.findAllJobColl();
	}

	@Override
	public JobCollection findJobCollByID(int jcID) throws Exception {
		// TODO Auto-generated method stub
		return jobCollDao.findJobCollByID(jcID);
	}

	@Override
	public List<JobAndCompanyC> findJobCollByUserID(int userID) throws Exception {
		// TODO Auto-generated method stub
		return jobCollDao.findJobCollByUserID(userID);
	}

}
