package com.example.last_project.model.detail.manual;

import java.io.Serializable;

public class ManualVO implements Serializable {
    private String manual_code, model_code, filename, filepath, help_cnt;

    public String getManual_code() {
        return manual_code;
    }

    public void setManual_code(String manual_code) {
        this.manual_code = manual_code;
    }

    public String getModel_code() {
        return model_code;
    }

    public void setModel_code(String model_code) {
        this.model_code = model_code;
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

    public String getHelp_cnt() {
        return help_cnt;
    }

    public void setHelp_cnt(String help_cnt) {
        this.help_cnt = help_cnt;
    }


}
