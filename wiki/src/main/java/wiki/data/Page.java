package wiki.data;

public class Page {
	private String name;
	private String content;
	private boolean published;
	private String publishedId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	public String getPublishedId() {
		return publishedId;
	}
	public void setPublishedId(String publishedId) {
		this.publishedId = publishedId;
	}
}
