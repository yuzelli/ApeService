package bean;

public class ArticleC {
	private int articleId;
	private int collectionId;
	private int vexID;
	private String title;
	private String type;
	private String imgUrl;
	private String userName;
	private String createTime;
	private String replies;	
	private String content;
	
	
	
	public ArticleC(int articleId, int collectionId, int vexID, String title,
			String type, String imgUrl, String userName, String createTime,
			String replies, String content) {
		super();
		this.articleId = articleId;
		this.collectionId = collectionId;
		this.vexID = vexID;
		this.title = title;
		this.type = type;
		this.imgUrl = imgUrl;
		this.userName = userName;
		this.createTime = createTime;
		this.replies = replies;
		this.content = content;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}
	public int getVexID() {
		return vexID;
	}
	public void setVexID(int vexID) {
		this.vexID = vexID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getReplies() {
		return replies;
	}
	public void setReplies(String replies) {
		this.replies = replies;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
