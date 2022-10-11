package barcode;

import java.util.List;

import org.springframework.stereotype.Repository;


public class BarcodeVO {
	private String language, value;

	public BarcodeVO(String language, String value) {
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
