package bean;

public class JobAndCompany {
	public int jobId;
	public String jobName;
	public String jobDetail;
	public int jobType;
	public int jobCharge;
	public int jobCity;
	public Company company;
	public String jobTechnology;
	
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobDetail() {
		return jobDetail;
	}
	public void setJobDetail(String jobDetail) {
		this.jobDetail = jobDetail;
	}
	public int getJobType() {
		return jobType;
	}
	public void setJobType(int jobType) {
		this.jobType = jobType;
	}
	public int getJobCharge() {
		return jobCharge;
	}
	public void setJobCharge(int jobCharge) {
		this.jobCharge = jobCharge;
	}
	public int getJobCity() {
		return jobCity;
	}
	public void setJobCity(int jobCity) {
		this.jobCity = jobCity;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getJobTechnology() {
		return jobTechnology;
	}
	public void setJobTechnology(String jobTechnology) {
		this.jobTechnology = jobTechnology;
	}
	public JobAndCompany(int jobId, String jobName, String jobDetail,
			int jobType, int jobCharge, int jobCity, Company company,
			String jobTechnology) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobDetail = jobDetail;
		this.jobType = jobType;
		this.jobCharge = jobCharge;
		this.jobCity = jobCity;
		this.company = company;
		this.jobTechnology = jobTechnology;
	}
	

}
