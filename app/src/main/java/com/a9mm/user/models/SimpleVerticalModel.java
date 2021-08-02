package com.a9mm.user.models;

public class SimpleVerticalModel {

    public SimpleVerticalModel() {
        // empty constructor
    }

    private String shop_name,shop_owner_name,description,coupon,shop_image,rating,landmark,discount;

    public SimpleVerticalModel(String shop_name, String shop_owner_name, String description, String coupon, String shop_image, String rating, String landmark, String discount) {
        this.shop_name = shop_name;
        this.shop_owner_name = shop_owner_name;
        this.description = description;
        this.coupon = coupon;
        this.shop_image = shop_image;
        this.rating = rating;
        this.landmark = landmark;
        this.discount = discount;
    }

    public String getShop_name() {
        return shop_name;
    }

    public String getShop_owner_name() {
        return shop_owner_name;
    }

    public String getDescription() {
        return description;
    }

    public String getCoupon() {
        return coupon;
    }

    public String getShop_image() {
        return shop_image;
    }

    public String getRating() {
        return rating;
    }

    public String getLandmark() {
        return landmark;
    }

    public String getDiscount() {
        return discount;
    }
}
