package com.a9mm.user.models;

public class PlateModel {

    public PlateModel() {
        // empty constructor
    }

    private String cat_image;

    public PlateModel(String cat_image) {
        this.cat_image=cat_image;
    }

    public void setPlate_img(String cat_image) {
        this.cat_image = cat_image;
    }

    public String getPlate_img() {
        return cat_image;
    }
}
