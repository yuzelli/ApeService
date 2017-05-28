package bean;

public class JobAndCompanyC {
	private int jobId;
	private int collectionId;
	private String jobName;
	private String jobDetail;
	private int jobType;
	private int jobCharge;
	private int jobCity;
	private Company company;
	private String jobTechnology;
	
	
	
	public JobAndCompanyC(int jobId, int collectionId, String jobName,
			String jobDetail, int jobType, int jobCharge, int jobCity,
			Company company, String jobTechnology) {
		super();
		this.jobId = jobId;
		this.collectionId = collectionId;
		this.jobName = jobName;
		this.jobDetail = jobDetail;
		this.jobType = jobType;
		this.jobCharge = jobCharge;
		this.jobCity = jobCity;
		this.company = company;
		this.jobTechnology = jobTechnology;
	}
	public int getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}
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
	
	

}
