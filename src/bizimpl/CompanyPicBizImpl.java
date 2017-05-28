package bizimpl;

import java.util.List;

import dao.CompanyPicDao;
import daoimpl.CompanyPicDaoImpl;
import bean.CompanyPictures;
import biz.CompanyPicBiz;

public class CompanyPicBizImpl implements CompanyPicBiz {
	CompanyPicDao cpDao = new CompanyPicDaoImpl();

	@Override
	public int addPic(CompanyPictures cp) throws Exception {
		// TODO Auto-generated method stub
		return cpDao.addPic(cp);
	}

	@Override
	public boolean deletePic(int cpID) throws Exception {
		// TODO Auto-generated method stub
		return cpDao.deletePic(cpID);
	}

	@Override
	public CompanyPictures updatePic(CompanyPictures cp) throws Exception {
		// TODO Auto-generated method stub
		return cpDao.updatePic(cp);
	}

	@Override
	public List<CompanyPictures> findAllPic() throws Exception {
		// TODO Auto-generated method stub
		return cpDao.findAllPic();
	}

	@Override
	public CompanyPictures findPicByID(int cpID) throws Exception {
		// TODO Auto-generated method stub
		return cpDao.findPicByID(cpID);
	}

	@Override
	public List<CompanyPictures> findPicByCompID(int cID) throws Exception {
		// TODO Auto-generated method stub
		return cpDao.findPicByCompID(cID);
	}

}
