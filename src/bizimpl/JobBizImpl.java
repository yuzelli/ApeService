package bizimpl;

import java.util.List;

import dao.JobDao;
import daoimpl.JobDaoImpl;
import bean.Job;
import biz.JobBiz;



public class JobBizImpl implements JobBiz{
	private JobDao jobDao ;
	
	public JobBizImpl() {
		jobDao  = new JobDaoImpl();
	}

	@Override
	public List<Job> selAllJob() {
		return jobDao.selJob();
	}

	@Override
	public boolean addJob(Job j) {
		// TODO Auto-generated method stub
		return jobDao.addJob(j);
	}

	@Override
	public List<Job> selSomeJob(String JobType, String  JobCharge, String  JobCity,
			String  CompanyId) {
		// TODO Auto-generated method stub
		String sql = "select * from job where";
		if (!JobType.equals("")) {
			sql+=" JobType="+JobType+" and";
		}
		if (!JobCharge.equals("")) {
			sql+=" JobCharge="+JobCharge+" and";
		}
		if (!JobCity.equals("")) {
			sql+=" JobCity="+JobCity+" and";
		}
		if (!CompanyId.equals("")) {
			sql+=" CompanyId="+CompanyId;
		}
		//sql.lastIndexOf("and");
		System.out.println(sql.lastIndexOf("and"));
		System.out.println(sql);
		if(sql.length()-sql.lastIndexOf("and")==3){
			sql = sql.substring(0, sql.lastIndexOf("and"));
				System.out.println(sql);
		}
		return jobDao.selSomeJob(sql);
	}

	@Override
	public Job load(int ids) {
		return jobDao.load(ids);
	}

	@Override
	public void jobUpdate(Job j, int JobId) {
		jobDao.jobUpdate(j, JobId);
		
	}

	@Override
	public void delJob(int JobId) {
		jobDao.delJob(JobId);
		
	}

}
