package biz;

import java.util.List;

import bean.Job;



public interface JobBiz {
	public List<Job> selAllJob();
	public boolean addJob(Job j); // 增加职位

	public List<Job> selSomeJob(String JobType, String  JobCharge, String  JobCity,
			String  CompanyId);//组合查询职位

	public Job load(int ids);//数据回显

	public void jobUpdate(Job j, int JobId);//修改职位

	public void delJob(int JobId);//删除职位
}
