package com.voise.homeservisegraduateproject.bojo;

import java.io.Serializable;

public class CompletedOrder implements Serializable {

    private int id;
    private String order_date;
    private String order_name;
    private String order_cat;

    public CompletedOrder(int id, String order_date, String order_name, String order_cat) {
        this.id = id;
        this.order_date = order_date;
        this.order_name = order_name;
        this.order_cat = order_cat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getOrder_cat() {
        return order_cat;
    }

    public void setOrder_cat(String order_cat) {
        this.order_cat = order_cat;
    }

    @Override
    public String toString() {
        return "CompletedOrder{" +
                "id=" + id +
                ", order_date='" + order_date + '\'' +
                ", order_name='" + order_name + '\'' +
                ", order_cat='" + order_cat + '\'' +
                '}';
    }
}
