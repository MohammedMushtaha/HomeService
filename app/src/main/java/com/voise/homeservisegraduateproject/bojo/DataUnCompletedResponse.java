package com.voise.homeservisegraduateproject.bojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DataUnCompletedResponse implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("delivery_id")
    @Expose
    private String deliveryId;
    @SerializedName("work_id")
    @Expose
    private String workId;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("details_address")
    @Expose
    private String detailsAddress;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("long")
    @Expose
    private String _long;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("work")
    @Expose
    private DataWorkPending work;
    @SerializedName("delivery")
    @Expose
    private ProviderData delivery;
    @SerializedName("photo_order")
    @Expose
    private List<PhotoOrderResponse> photoOrder = null;

    public Integer getId() {
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

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetailsAddress() {
        return detailsAddress;
    }

    public void setDetailsAddress(String detailsAddress) {
        this.detailsAddress = detailsAddress;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong() {
        return _long;
    }

    public void setLong(String _long) {
        this._long = _long;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public DataWorkPending getWork() {
        return work;
    }

    public void setWork(DataWorkPending work) {
        this.work = work;
    }

    public ProviderData getDelivery() {
        return delivery;
    }

    public void setDelivery(ProviderData delivery) {
        this.delivery = delivery;
    }

    public List<PhotoOrderResponse> getPhotoOrder() {
        return photoOrder;
    }

    public void setPhotoOrder(List<PhotoOrderResponse> photoOrder) {
        this.photoOrder = photoOrder;
    }

}
