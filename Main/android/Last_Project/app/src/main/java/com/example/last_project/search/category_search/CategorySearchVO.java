package com.example.last_project.search.category_search;

import java.io.Serializable;

public class CategorySearchVO implements Serializable {

    String brand_name, model_name, model_code, filepath, category_name;

    public CategorySearchVO(String brand_name, String model_name, String model_code, String filepath, String category_name) {
        this.brand_name = brand_name;
        this.model_name = model_name;
        this.model_code = model_code;
        this.filepath = filepath;
        this.category_name = category_name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getModel_code() {
        return model_code;
    }

    public void setModel_code(String model_code) {
        this.model_code = model_code;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
