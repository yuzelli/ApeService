package contriler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import utils.MyStringUtlis;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import bean.Company;
import bean.MyError;
import bean.Success;
import biz.CompanyBiz;
import bizimpl.CompanyBizImpl;

public class CompanyServlet extends HttpServlet {

	CompanyBiz companyBiz = new CompanyBizImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf8");
		resp.setCharacterEncoding("utf8");
		// 鍒ゆ柇
		String type = req.getParameter("type");
		if ("register".equals(type)) {
			registerCompany(req, resp);
			return;
		} else if ("login".equals(type)) {
			LoginCompany(req, resp);
			return;
		} else if ("deleteCompany".equals(type)) {
			deleteCompanyByID(req, resp);
			return;
		} else if ("updateCompany".equals(type)) {
			updateCompanyByID(req, resp);
			return;
		} else if ("findCompany".equals(type)) {
			findCompanyByID(req, resp);
			return;
		}
		else if ("findAllCompany".equals(type)) {
			findAllCompany(req, resp);
			return;
		}
	}
	/**
	 * 鏌ヨ鎵�湁
	 * @param req
	 * @param resp
	 */
    private void findAllCompany(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			List<Company> list = companyBiz.findAllCompany();
			if (list != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(list);
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			} else {
				MyError error = new MyError();
				error.setError("error");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
     * 鐧婚檰鐢ㄦ埛
     * @param req
     * @param resp
     */
	private void LoginCompany(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			
			String companyNum = req.getParameter("CompanyNum");
			String passWord = req.getParameter("CompanyPassword");
			
			Company company = companyBiz.LoginCompany(companyNum, passWord);
			if (company != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(company);
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			} else {
				
				MyError error = new MyError();
				error.setError("error");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 閫氳繃id鏉ユ煡璇㈠叕鍙�
	 * 
	 * @param req
	 * @param resp
	 */
	private void findCompanyByID(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			int companyID = Integer.parseInt(req.getParameter("CompanyId"));
			Company company = companyBiz.findCompanyByID(companyID);
			if (company != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(company);
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			} else {
				MyError error = new MyError();
				error.setError("error");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 淇敼鍏徃淇℃伅
	 * 
	 * @param req
	 * @param resp
	 */
	private void updateCompanyByID(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			int companyID = Integer.parseInt(req.getParameter("CompanyId"));
			String companyNum = req.getParameter("CompanyNum");
			String companyPassword = req.getParameter("CompanyPassword");
			String companyHeadImg = req.getParameter("CompanyHeadImg");
			String companyName = MyStringUtlis.toUTFString(req, "CompanyName");
			String companyAddress = MyStringUtlis.toUTFString(req, "CompanyAddress");
			String companyIntroduce = MyStringUtlis.toUTFString(req, "CompanyIntroduce");
			int companyScale = Integer.parseInt(req
					.getParameter("CompanyScale"));
			Company company = new Company();
			company.setCompanyId(companyID);
			company.setCompanyNum(companyNum);
			company.setCompanyPassword(companyPassword);
			company.setCompanyHeadImg(companyHeadImg);
			company.setCompanyName(companyName);
			company.setCompanyAddress(companyAddress);
			company.setCompanyIntroduce(companyIntroduce);
			company.setCompanyScale(companyScale);
			Company company2 = companyBiz.updateCompanyByID(companyID, company);
			if (company2 != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(company2);
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			} else {
				MyError error = new MyError();
				error.setError("error");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 鍒犻櫎鍏徃
	 * 
	 * @param req
	 * @param resp
	 */
	private void deleteCompanyByID(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			int companyID = Integer.parseInt(req.getParameter("CompanyId"));
			boolean flag = companyBiz.deleteCompanyByID(companyID);
			Success success = new Success();
			success.setFlag(flag);
			JSONObject jsonObject = JSONObject.fromObject(success);
			resp.getWriter().print(jsonObject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 娉ㄥ唽鍏徃
	 * 
	 * @param req
	 * @param resp
	 */
	private void registerCompany(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			String companyNum = req.getParameter("CompanyNum");
			String companyPassword = req.getParameter("CompanyPassword");
			String companyHeadImg = req.getParameter("CompanyHeadImg");
			String companyName = MyStringUtlis.toUTFString(req, "CompanyName");
			String companyAddress = MyStringUtlis.toUTFString(req, "CompanyAddress");
			String companyIntroduce = MyStringUtlis.toUTFString(req, "CompanyIntroduce");
			int companyScale = Integer.parseInt(req
					.getParameter("CompanyScale"));
			Company company = new Company();
			company.setCompanyNum(companyNum);
			company.setCompanyPassword(companyPassword);
			company.setCompanyHeadImg(companyHeadImg);
			company.setCompanyName(companyName);
			company.setCompanyAddress(companyAddress);
			company.setCompanyIntroduce(companyIntroduce);
			company.setCompanyScale(companyScale);
			Company company2 = companyBiz.registerCompany(company);
			if (company2 != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(company2);
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			} else {
				MyError error = new MyError();
				error.setError("error");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
