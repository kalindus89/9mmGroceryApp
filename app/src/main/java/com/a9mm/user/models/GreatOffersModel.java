package com.a9mm.user.models;

public class GreatOffersModel {

    public GreatOffersModel() {
    }
    private int offers_shop_img;
    private  String offers_shop_name, offers_time, offers_discount, offers_rating;

    public GreatOffersModel(int offers_shop_img, String offers_shop_name, String offers_time, String offers_discount, String offers_rating) {
        this.offers_shop_img = offers_shop_img;
        this.offers_shop_name = offers_shop_name;
        this.offers_time = offers_time;
        this.offers_discount = offers_discount;
        this.offers_rating = offers_rating;
    }

    public int getOffers_shop_img() {
        return offers_shop_img;
    }

    public void setOffers_shop_img(int offers_shop_img) {
        this.offers_shop_img = offers_shop_img;
    }

    public String getOffers_shop_name() {
        return offers_shop_name;
    }

    public void setOffers_shop_name(String offers_shop_name) {
        this.offers_shop_name = offers_shop_name;
    }

    public String getOffers_time() {
        return offers_time;
    }

    public void setOffers_time(String offers_time) {
        this.offers_time = offers_time;
    }

    public String getOffers_discount() {
        return offers_discount;
    }

    public void setOffers_discount(String offers_discount) {
        this.offers_discount = offers_discount;
    }

    public String getOffers_rating() {
        return offers_rating;
    }

    public void setOffers_rating(String offers_rating) {
        this.offers_rating = offers_rating;
    }
}
