package com.example.last_project.map;

import com.google.gson.annotations.SerializedName;

public class Meta {
    @SerializedName("same_name")
    private SameName sameName;

    @SerializedName("pageable_count")
    private int pageableCount;

    @SerializedName("total_count")
    private int totalCount;

    @SerializedName("is_end")
    private boolean isEnd;


    public SameName getSameName() {
        return sameName;
    }

    public void setSameName(SameName sameName) {
        this.sameName = sameName;
    }

    public int getPageableCount() {
        return pageableCount;
    }

    public void setPageableCount(int pageableCount) {
        this.pageableCount = pageableCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}


