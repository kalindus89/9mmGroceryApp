package com.a9mm.user.models;

public class BannerModel {


    private String banner_image;

    public BannerModel() {
        // empty constructor
    }

    public BannerModel(String banner_image) {
        this.banner_image = banner_image;
    }

    public void setBanner_image(String banner_image) {
        this.banner_image = banner_image;
    }

    public String getBanner_image() {
        return banner_image;
    }


}
