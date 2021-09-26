package com.example.project_reser;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("currentCount")
    @Expose
    private Integer currentCount;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("matchCount")
    @Expose
    private Integer matchCount;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("perPage")
    @Expose
    private Integer perPage;
    @SerializedName("totalCount")
    @Expose
    private Integer totalCount;

    public Integer getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(Integer matchCount) {
        this.matchCount = matchCount;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

}