package com.voise.homeservisegraduateproject.bojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataHomeProviderResponse  implements Serializable {


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("details_address")
    @Expose
    private String detailsAddress;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("long")
    @Expose
    private double _long;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("work_id")
    @Expose
    private String workId;
    @SerializedName("work")
    @Expose
    private WorkAddOrderResponse work;
    @SerializedName("photo_order_home")
    @Expose
    private PhotoOrderHomeProvider photoOrderHome;
    @SerializedName("user")
    @Expose
    private UserCustomer user;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDetailsAddress() {
        return detailsAddress;
    }

    public void setDetailsAddress(String detailsAddress) {
        this.detailsAddress = detailsAddress;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLong() {
        return _long;
    }

    public void setLong(double _long) {
        this._long = _long;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public WorkAddOrderResponse getWork() {
        return work;
    }

    public void setWork(WorkAddOrderResponse work) {
        this.work = work;
    }

    public PhotoOrderHomeProvider getPhotoOrderHome() {
        return photoOrderHome;
    }

    public void setPhotoOrderHome(PhotoOrderHomeProvider photoOrderHome) {
        this.photoOrderHome = photoOrderHome;
    }

    public UserCustomer getUser() {
        return user;
    }

    public void setUser(UserCustomer user) {
        this.user = user;
    }

}
