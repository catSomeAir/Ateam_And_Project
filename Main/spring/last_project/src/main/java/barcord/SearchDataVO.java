package barcord;

public class SearchDataVO {
	private String language;
	private String value;
	public SearchDataVO(String language, String value) {
		super();
		this.language = language;
		this.value = value;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
