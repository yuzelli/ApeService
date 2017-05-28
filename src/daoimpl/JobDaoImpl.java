package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Finishings;

import bean.Job;
import dao.BaseDao;
import dao.CompanyResumeDao;
import dao.JobCollectionDao;
import dao.JobDao;



public class JobDaoImpl extends BaseDao implements JobDao {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	@Override
	public List<Job> selJob() {
		List<Job> jobs = new ArrayList<Job>();

		try {
			String sql = "select * from `job` order by JobId desc";
			conn = getConnections();
			psmt = conn.prepareCall(sql);
			rs = psmt.executeQuery();// 鑾峰彇缁撴灉闆�
			while (rs.next()) {
				Job oneJob = new Job();
				oneJob.setJobId(rs.getInt(1));
				oneJob.setJobName(rs.getString(2));
				oneJob.setJobDetail(rs.getString(3));
				oneJob.setJobType(rs.getInt(4));
				oneJob.setJobCharge(rs.getInt(5));
				oneJob.setJobCity(rs.getInt(6));
				oneJob.setCompanyId(rs.getInt(7));
				oneJob.setJobTechnology(rs.getString(8));
				jobs.add(oneJob);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}

		return jobs;
	}

	



	/**
	 * 澧炲姞鑱屼綅
	 */
	@Override
	public boolean addJob(Job j) {
		boolean flag = false;
		int num;

		try {
			conn = this.getConnections();
			String sql = "INSERT INTO `job`(JobName,JobDetail,JobType,JobCharge,JobCity, CompanyId,JobTechnology) VALUES (?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, j.getJobName());
			psmt.setString(2, j.getJobDetail());
			psmt.setInt(3, j.getJobType());
			psmt.setInt(4, j.getJobCharge());
			psmt.setInt(5, j.getJobCity());
			psmt.setInt(6, j.getCompanyId());
			psmt.setString(7, j.getJobTechnology());
			num = psmt.executeUpdate();
			if (num > 0) {
				flag = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return flag;
	}
/**
 * 缁勫悎鏌ヨ
 */
	@Override
	public List<Job> selSomeJob(String sql) {
		List<Job> jobs = new ArrayList<Job>();

			try {
				conn = getConnections();
				System.out.println(sql);
				psmt = conn.prepareStatement(sql);
				
				rs = psmt.executeQuery();// 鑾峰彇缁撴灉闆�
				while (rs.next()) {
					Job oneJob = new Job();
					oneJob.setJobId(rs.getInt(1));
					oneJob.setJobName(rs.getString(2));
					oneJob.setJobDetail(rs.getString(3));
					oneJob.setJobType(rs.getInt(4));
					oneJob.setJobCharge(rs.getInt(5));
					oneJob.setJobCity(rs.getInt(6));
					oneJob.setCompanyId(rs.getInt(7));
					oneJob.setJobTechnology(rs.getString(8));
					jobs.add(oneJob);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return jobs;
	}

	/**
	 * 鏁版嵁鏄剧ず鍦ㄤ慨鏀圭殑琛ㄤ笂
	 */
	@Override
	public Job load(int ids) {
		conn = this.getConnections();
		Job j = new Job();
		String sql = "select * from `job`  where JobId = ? order by JobId desc";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ids);
			rs = psmt.executeQuery();
			while (rs.next()) {
				j.setJobId(rs.getInt(1));
				j.setJobName(rs.getString(2));
				j.setJobDetail(rs.getString(3));
				j.setJobType(rs.getInt(4));
				j.setJobCharge(rs.getInt(5));
				j.setJobCity(rs.getInt(6));
				j.setCompanyId(rs.getInt(7));
				j.setJobTechnology(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return j;
	}

	/**
	 * 淇敼鏁版嵁
	 */
	@Override
	public void jobUpdate(Job j, int JobId) {
		try {
			conn = this.getConnections();
			String sql = "update `job` set JobId=?,JobName=?,JobDetail=?,JobType=?,JobCharge=?,JobCity=?,CompanyId=?,JobTechnology=? where JobId=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, j.getJobId());
			psmt.setString(2, j.getJobName());
			psmt.setString(3, j.getJobDetail());
			psmt.setInt(4, j.getJobType());
			psmt.setInt(5, j.getJobCharge());
			psmt.setInt(6, j.getJobCity());
			psmt.setInt(7, j.getCompanyId());
			psmt.setString(8, j.getJobTechnology());
			psmt.setInt(9, JobId);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

	/**
	 * 鍒犻櫎鏁版嵁
	 */
	@Override
	public void delJob(int JobId) {
		    JobCollectionDao jobDao = new JobCollectionDaoImpl();
		    CompanyResumeDao compReDao = new CompanyResumeDaoImpl();
		    try {
				jobDao.delJobByJobId(JobId);
				compReDao.deleteCompanyResumeByJobID(JobId);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
		    
		
				 conn = this.getConnections();
			String sql = "delete from `job` where JobId=?";
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, JobId);
				psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeAll();
			}
	}
	private void closeAll() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}





	
}
