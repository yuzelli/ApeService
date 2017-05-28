package daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Article;
import bean.CompanyResume;
import dao.CompanyResumeDao;
import db.DataBaseUtil;

public class CompanyResumeDaoImpl implements CompanyResumeDao {

	@Override
	public int addCompanyResume(CompanyResume cr) throws Exception {
		// TODO Auto-generated method stub
		int crID = -1;
		try {
			List<CompanyResume> CompanyResumeList2 = findCompanyResumes();
			for (CompanyResume crDB : CompanyResumeList2) {
				if (crDB.getJobId() == cr.getJobId()
						&& crDB.getCompanyId() == cr.getCompanyId()&&crDB.getUserId()==cr.getUserId()) {
					crID = crDB.getResume_id();
					return crID;
				}
			}
			
			
			String sqlStr = "insert into companyresume (JobId,UserId,CompanyId) values(?,?,?)";
			int num = DataBaseUtil.executeUpdate(
					sqlStr,
					new Object[] { cr.getJobId(), cr.getUserId(),
							cr.getCompanyId() });
			if (num > 0) {
				List<CompanyResume> CompanyResumeList = findCompanyResumes();
				for (CompanyResume crDB : CompanyResumeList) {
					if (crDB.getJobId() == cr.getJobId()
							&& crDB.getCompanyId() == cr.getCompanyId()) {
						crID = crDB.getResume_id();
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

		return crID;
	}

	@Override
	public boolean deleteCompanyResume(int crID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from companyresume where Resume_id=?";
		boolean flag = false;
		try {
			int num  = DataBaseUtil.executeUpdate(sql, new Object[]{crID});
		    if(num>0){
		    	flag = true;
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConn();
		}
		
		return flag;
	}

	@Override
	public CompanyResume updateCompanyResume(CompanyResume cr) throws Exception {
		// TODO Auto-generated method stub
		CompanyResume cResume = null;
		try {
		
		String sqlStr = "update companyresume set JobId=? ,UserId=?, CompanyId=? where Resume_id=?";
		
		int num = DataBaseUtil.executeUpdate(
					sqlStr,
					new Object[] {cr.getJobId(),cr.getUserId(),cr.getCompanyId(),cr.getResume_id()});
		if(num>0){    
			cResume = findCompanyResumeleByID(cr.getResume_id());
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConn();
		}
				
		return cResume;
	}

	@Override
	public List<CompanyResume> findCompanyResumes() throws Exception {
		// TODO Auto-generated method stub
		List<CompanyResume> companyResumeList = null;

		try {
			companyResumeList = new ArrayList<CompanyResume>();
			String sqlStr = "select * from companyresume";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStr, null);
			while (rs.next()) {
				CompanyResume cr = new CompanyResume();
				cr.setResume_id(rs.getInt("Resume_id"));
				cr.setJobId(rs.getInt("JobId"));
				cr.setUserId(rs.getInt("UserId"));
				cr.setCompanyId(rs.getInt("CompanyId"));
				companyResumeList.add(cr);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBaseUtil.closeConn();
		}

		return companyResumeList;
	}

	@Override
	public List<CompanyResume> findCompanyResumeByCompID(Integer cID) throws Exception {
		// TODO Auto-generated method stub
		List<CompanyResume> companyResumeList = null;

		try {
			companyResumeList = new ArrayList<CompanyResume>();
			String sqlStr = "select * from companyresume where CompanyId = ?";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStr, new Object[]{cID});
			while (rs.next()) {
				CompanyResume cr = new CompanyResume();
				cr.setResume_id(rs.getInt("Resume_id"));
				cr.setJobId(rs.getInt("JobId"));
				cr.setUserId(rs.getInt("UserId"));
				cr.setCompanyId(rs.getInt("CompanyId"));
				companyResumeList.add(cr);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBaseUtil.closeConn();
		}

		return companyResumeList;
	}

	@Override
	public CompanyResume findCompanyResumeleByID(Integer crID) throws Exception {
		// TODO Auto-generated method stub
		CompanyResume companyResume = null;
		
		try {
			String sqlStrid = "select * from companyresume where Resume_id=?";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStrid,
					new Object[] { crID });
			while (rs.next()) {
				companyResume = new CompanyResume();
				
				companyResume.setResume_id(rs.getInt("Resume_id"));
				companyResume.setJobId(rs.getInt("JobId"));
				companyResume.setUserId(rs.getInt("UserId"));
				companyResume.setCompanyId(rs.getInt("CompanyId"));
			}

	  } catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}
		return companyResume;
	}

	@Override
	public List<CompanyResume> findCompanyResumeByUserID(Integer uID)
			throws Exception {
		List<CompanyResume> companyResumeList = null;

		try {
			companyResumeList = new ArrayList<CompanyResume>();
			String sqlStr = "select * from companyresume where UserId = ?";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStr, new Object[]{uID});
			while (rs.next()) {
				CompanyResume cr = new CompanyResume();
				cr.setResume_id(rs.getInt("Resume_id"));
				cr.setJobId(rs.getInt("JobId"));
				cr.setUserId(rs.getInt("UserId"));
				cr.setCompanyId(rs.getInt("CompanyId"));
				companyResumeList.add(cr);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBaseUtil.closeConn();
		}

		return companyResumeList;
	}

	@Override
	public boolean deleteCompanyResumeByUserID(int userID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from companyresume where UserId=?";
		boolean flag = false;
		try {
			int num  = DataBaseUtil.executeUpdate(sql, new Object[]{userID});
		    if(num>0){
		    	flag = true;
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConn();
		}
		
		return flag;
	}

	@Override
	public boolean deleteCompanyResumeByJobID(int jobID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from companyresume where JobId=?";
		boolean flag = false;
		try {
			int num  = DataBaseUtil.executeUpdate(sql, new Object[]{jobID});
		    if(num>0){
		    	flag = true;
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConn();
		}
		
		return flag;
	}

	@Override
	public boolean deleteCompanyResumeByCompanyID(int cID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from companyresume where CompanyId=?";
		boolean flag = false;
		try {
			int num  = DataBaseUtil.executeUpdate(sql, new Object[]{cID});
		    if(num>0){
		    	flag = true;
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConn();
		}
		
		return flag;
	}

}
