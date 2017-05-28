package daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Company;
import bean.CompanyPictures;
import bean.Job;
import bean.JobAndCompany;
import bean.JobAndCompanyC;
import bean.JobCollection;
import biz.JobBiz;
import dao.CompanyDao;
import dao.JobCollectionDao;
import dao.JobDao;
import db.DataBaseUtil;

public class JobCollectionDaoImpl implements JobCollectionDao {
	
	

	@Override
	public int addJobColl(JobCollection jc) throws Exception {
		// TODO Auto-generated method stub
		int jcID = -1;
		try {
			List<JobCollection> list2 = findAllJobColl();
			for (JobCollection jcDB : list2) {
				if (jcDB.getUserId() == jc.getUserId()
						&& jcDB.getJobId()==jc.getJobId()) {
					jcID = jcDB.getCollectionId();
					return jcID;
				}
			}
			String sqlStr = "insert into jobcollection (JobId,UserInfoId) values(?,?)";
			int num = DataBaseUtil.executeUpdate(sqlStr,
					new Object[] {jc.getJobId(),jc.getUserId() });
			if (num > 0) {
				List<JobCollection> list = findAllJobColl();
				for (JobCollection jcDB : list) {
					if (jcDB.getUserId() == jc.getUserId()
							&& jcDB.getJobId()==jc.getJobId()) {
						jcID = jcDB.getCollectionId();
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

		return jcID;
	}

	@Override
	public boolean deleteJobColl(int jcID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from jobcollection where CollectionId=?";
		boolean flag = false;
		try {
			int num = DataBaseUtil.executeUpdate(sql, new Object[] { jcID });
			if (num > 0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}

		return flag;
	}

	@Override
	public JobCollection updateJobColl(JobCollection jc) throws Exception {
		// TODO Auto-generated method stub
		try {

			String sqlStr = "update jobcollection set JobId=?,UserInfoId=? where CollectionId=?";

			int num = DataBaseUtil.executeUpdate(
					sqlStr,
					new Object[] { jc.getJobId(),jc.getUserId(),jc.getCollectionId() });
			if (num > 0) {
				JobCollection jc2 = findJobCollByID(jc.getCollectionId());
				return jc2;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}

		return null;
	}

	@Override
	public List<JobCollection> findAllJobColl() throws Exception {
		// TODO Auto-generated method stub
		List<JobCollection> list = null;

		try {
			list = new ArrayList<JobCollection>();
			String sqlStr = "select * from jobcollection";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStr, null);
			while (rs.next()) {
				JobCollection jc = new JobCollection();
				jc.setCollectionId(rs.getInt("CollectionId"));
				jc.setJobId(rs.getInt("JobId"));
				jc.setUserId(rs.getInt("UserInfoId"));
				list.add(jc);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBaseUtil.closeConn();
		}

		return list;
	}

	@Override
	public JobCollection findJobCollByID(int jcID) throws Exception {
		// TODO Auto-generated method stub
		JobCollection jc = null;

		try {
			String sqlStrid = "select * from jobcollection where CollectionId=?";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStrid,
					new Object[] { jcID });
			while (rs.next()) {
				jc = new JobCollection();
				jc.setCollectionId(rs.getInt("CollectionId"));
				jc.setJobId(rs.getInt("JobId"));
				jc.setUserId(rs.getInt("UserInfoId"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}
		return jc;
	}

	@Override
	public List<JobAndCompanyC> findJobCollByUserID(int userID) throws Exception {
		// TODO Auto-generated method stub
		List<JobAndCompanyC> jobs = null;
		List<JobCollection> list = null;

		try {
			list = new ArrayList<JobCollection>();
			String sqlStr = "select * from jobcollection where UserInfoId = ?";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStr, new Object[]{ userID});
			while (rs.next()) {
				JobCollection jc = new JobCollection();
				jc.setCollectionId(rs.getInt("CollectionId"));
				jc.setJobId(rs.getInt("JobId"));
				jc.setUserId(rs.getInt("UserInfoId"));
				list.add(jc);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBaseUtil.closeConn();
		}
		JobDao jobDao = new JobDaoImpl();
		if (list!=null) {
			jobs = new ArrayList<JobAndCompanyC>();
			for (JobCollection jc :list) {
				Job job = jobDao.load(jc.getJobId());
				CompanyDao compDao = new CompanyDaoImpl();
				Company company = compDao.findCompanyByID(job.getCompanyId());
				JobAndCompanyC jcc = new JobAndCompanyC(job.getJobId(), jc.getCollectionId(), job.JobName, job.JobDetail, job.JobType, job.JobCharge, job.JobCity, company, job.JobTechnology);
				jobs.add(jcc);
			}
		}

		return jobs;
	}

	@Override
	public boolean delJobByUserId(int userID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from jobcollection where UserInfoId=?";
		boolean flag = false;
		try {
			int num = DataBaseUtil.executeUpdate(sql, new Object[] { userID });
			if (num > 0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}

		return flag;
	}

	@Override
	public boolean delJobByJobId(int jobID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from jobcollection where JobId=?";
		boolean flag = false;
		try {
			int num = DataBaseUtil.executeUpdate(sql, new Object[] { jobID });
			if (num > 0) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}

		return flag;
	}

}
