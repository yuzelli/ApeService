package biz;

import java.util.List;

import bean.CompanyPictures;

public interface CompanyPicBiz {
	// 增
	public int addPic(CompanyPictures cp) throws Exception;

	// 删
	public boolean deletePic(int cpID) throws Exception;

	// 改
	public CompanyPictures updatePic(CompanyPictures cp) throws Exception;

	// 查
	public List<CompanyPictures> findAllPic() throws Exception;

	public CompanyPictures findPicByID(int cpID) throws Exception;

	// 通过公司查所有
	public List<CompanyPictures> findPicByCompID(int cID) throws Exception;

}
