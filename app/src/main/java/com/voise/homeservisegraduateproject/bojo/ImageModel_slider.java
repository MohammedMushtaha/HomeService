package com.voise.homeservisegraduateproject.bojo;

public class ImageModel_slider {
    private int imageurl;

    public ImageModel_slider(int imageurl) {
        this.imageurl = imageurl;
    }

    public ImageModel_slider() {
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }

    @Override
    public String toString() {
        return "ImageModel{" +
                "imageurl='" + imageurl + '\'' +
                '}';
    }


}
