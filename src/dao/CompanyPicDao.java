package dao;

import java.util.List;

import bean.Article;
import bean.CompanyPictures;

public interface CompanyPicDao {
	// 澧�
	public int addPic(CompanyPictures cp) throws Exception;

	// 鍒�
	public boolean deletePic(int cpID) throws Exception;

	// 鏀�
	public CompanyPictures updatePic(CompanyPictures cp) throws Exception;

	// 鏌�
	public List<CompanyPictures> findAllPic() throws Exception;

	public CompanyPictures findPicByID(int cpID) throws Exception;

	// 閫氳繃鍏徃鏌ユ墍鏈�
	public List<CompanyPictures> findPicByCompID(int cID) throws Exception;
	
	
	public boolean deletePicByCompanyID(int cID) throws Exception;

}
