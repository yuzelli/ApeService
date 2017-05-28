package bean;

public class Job {
		public int JobId;
		public String JobName;
		public String JobDetail;
		public int JobType;
		public int JobCharge;
		public int JobCity;
		public int CompanyId;
		public String JobTechnology;
		
		public Job() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Job(int jobId, String jobName, String jobDetail, int jobType,
				int jobCharge, int jobCity, int companyId, String jobTechnology) {
			super();
			JobId = jobId;
			JobName = jobName;
			JobDetail = jobDetail;
			JobType = jobType;
			JobCharge = jobCharge;
			JobCity = jobCity;
			CompanyId = companyId;
			JobTechnology = jobTechnology;
		}
		public int getJobId() {
			return JobId;
		}
		public void setJobId(int jobId) {
			JobId = jobId;
		}
		public String getJobName() {
			return JobName;
		}
		public void setJobName(String jobName) {
			JobName = jobName;
		}
		public String getJobDetail() {
			return JobDetail;
		}
		public void setJobDetail(String jobDetail) {
			JobDetail = jobDetail;
		}
		public int getJobType() {
			return JobType;
		}
		public void setJobType(int jobType) {
			JobType = jobType;
		}
		public int getJobCharge() {
			return JobCharge;
		}
		public void setJobCharge(int jobCharge) {
			JobCharge = jobCharge;
		}
		public int getJobCity() {
			return JobCity;
		}
		public void setJobCity(int jobCity) {
			JobCity = jobCity;
		}
		public int getCompanyId() {
			return CompanyId;
		}
		public void setCompanyId(int companyId) {
			CompanyId = companyId;
		}
		public String getJobTechnology() {
			return JobTechnology;
		}
		public void setJobTechnology(String jobTechnology) {
			JobTechnology = jobTechnology;
		}
		
}
