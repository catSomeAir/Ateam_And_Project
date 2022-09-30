package com.example.last_project.model;

import java.io.Serializable;

public class ModelInfoVO implements Serializable {
	private String model_code, model_name, brand_code, category_code, filename, filepath;

	public ModelInfoVO(String model_code, String model_name, String brand_code, String category_code, String filename, String filepath) {
		this.model_code = model_code;
		this.model_name = model_name;
		this.brand_code = brand_code;
		this.category_code = category_code;
		this.filename = filename;
		this.filepath = filepath;
	}

	public String getModel_code() {
		return model_code;
	}

	public void setModel_code(String model_code) {
		this.model_code = model_code;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public String getBrand_code() {
		return brand_code;
	}

	public void setBrand_code(String brand_code) {
		this.brand_code = brand_code;
	}

	public String getCategory_code() {
		return category_code;
	}

	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
}
 	