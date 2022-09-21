package com.example.last_project.postList;

public class RequestedPostDTO {

    private String model_name;
    private String model_code;
    private String brand_name;

    public RequestedPostDTO(String model_name, String model_code, String brand_name) {
        this.model_name = model_name;
        this.model_code = model_code;
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

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }
}
