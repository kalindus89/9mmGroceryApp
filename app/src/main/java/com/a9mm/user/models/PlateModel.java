package com.a9mm.user.models;

public class PlateModel {

    public PlateModel() {
        // empty constructor
    }

    private int cat_image;

    public PlateModel(int cat_image) {
        this.cat_image=cat_image;
    }

    public void setPlate_img(int cat_image) {
        this.cat_image = cat_image;
    }

    public int getPlate_img() {
        return cat_image;
    }
}
