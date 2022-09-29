package com.example.last_project.main.manysearch;

import java.io.Serializable;

public class ManySearchVO implements Serializable {
    private String model_code, model_name, filepath, brand_name;

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

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

}
