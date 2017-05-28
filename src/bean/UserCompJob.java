package bean;

public class UserCompJob {
	private int resume_id;
	private UserInfo userInfo;
	private Job job;
	private Company company;
	
	
	
	public UserCompJob(int resume_id, UserInfo userInfo, Job job,
			Company company) {
		super();
		this.resume_id = resume_id;
		this.userInfo = userInfo;
		this.job = job;
		this.company = company;
	}
	public int getResume_id() {
		return resume_id;
	}
	public void setResume_id(int resume_id) {
		resume_id = resume_id;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
