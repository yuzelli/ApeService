package daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Article;
import bean.CompanyPictures;
import dao.CompanyPicDao;
import db.DataBaseUtil;

public class CompanyPicDaoImpl implements CompanyPicDao {

	@Override
	public int addPic(CompanyPictures cp) throws Exception {
		// TODO Auto-generated method stub
		int picID = -1;
		try {
			List<CompanyPictures> list2 = findAllPic();
			for (CompanyPictures cpDB : list2) {
				if (cpDB.getCompanyId() == cp.getCompanyId()
						&& cpDB.getPictureURL().equals(cp.getPictureURL())) {
					picID = cpDB.getPictureId();
					return picID;
				}
			}
			String sqlStr = "insert into companypictures (PictureURL,CompanyId) values(?,?)";
			int num = DataBaseUtil.executeUpdate(sqlStr,
					new Object[] { cp.getPictureURL(), cp.getCompanyId() });
			if (num > 0) {
				List<CompanyPictures> list = findAllPic();
				for (CompanyPictures cpDB : list) {
					if (cpDB.getCompanyId() == cp.getCompanyId()
							&& cpDB.getPictureURL().equals(cp.getPictureURL())) {
						picID = cpDB.getPictureId();
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

		return picID;
	}

	@Override
	public boolean deletePic(int cpID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from companypictures where PictureId=?";
		boolean flag = false;
		try {
			int num = DataBaseUtil.executeUpdate(sql, new Object[] { cpID });
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
	public CompanyPictures updatePic(CompanyPictures cp) throws Exception {
		// TODO Auto-generated method stub

		try {

			String sqlStr = "update companypictures set PictureURL=?,CompanyId=? where PictureId=?";

			int num = DataBaseUtil.executeUpdate(
					sqlStr,
					new Object[] { cp.getPictureURL(), cp.getCompanyId(),
							cp.getPictureId() });
			if (num > 0) {
				CompanyPictures companyPictures = findPicByID(cp.getPictureId());
				return companyPictures;
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
	public List<CompanyPictures> findAllPic() throws Exception {
		// TODO Auto-generated method stub
		List<CompanyPictures> list = null;

		try {
			list = new ArrayList<CompanyPictures>();
			String sqlStr = "select * from companypictures";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStr, null);
			while (rs.next()) {
				CompanyPictures cPictures = new CompanyPictures();
				cPictures.setPictureId(rs.getInt("PictureId"));
				cPictures.setPictureURL(rs.getString("PictureURL"));
				cPictures.setCompanyId(rs.getInt("CompanyId"));
				list.add(cPictures);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBaseUtil.closeConn();
		}

		return list;
	}

	@Override
	public CompanyPictures findPicByID(int cpID) throws Exception {
		// TODO Auto-generated method stub
		CompanyPictures cp = null;

		try {
			String sqlStrid = "select * from companypictures where PictureId=?";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStrid,
					new Object[] { cpID });
			while (rs.next()) {
				cp =  new CompanyPictures();
				cp.setPictureId(rs.getInt("PictureId"));
				cp.setPictureURL(rs.getString("PictureURL"));
				cp.setCompanyId(rs.getInt("CompanyId"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}
		return cp;

	}

	@Override
	public List<CompanyPictures> findPicByCompID(int cID) throws Exception {
		// TODO Auto-generated method stub
		List<CompanyPictures> list = null;

		try {
			list = new ArrayList<CompanyPictures>();
			String sqlStr = "select * from companypictures where CompanyId = ?";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStr, new Object[]{ cID});
			while (rs.next()) {
				CompanyPictures cPictures = new CompanyPictures();
				cPictures.setPictureId(rs.getInt("PictureId"));
				cPictures.setPictureURL(rs.getString("PictureURL"));
				cPictures.setCompanyId(rs.getInt("CompanyId"));
				list.add(cPictures);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBaseUtil.closeConn();
		}

		return list;
	}

	@Override
	public boolean deletePicByCompanyID(int cID) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from companypictures where CompanyId=?";
		boolean flag = false;
		try {
			int num = DataBaseUtil.executeUpdate(sql, new Object[] { cID });
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
