package com.a9mm.user.retrofit_api;

import com.a9mm.user.models.BannerModel;
import com.a9mm.user.models.CategoryModel;
import com.a9mm.user.models.GreatOffersModel;
import com.a9mm.user.models.PlateModel;
import com.a9mm.user.models.SimpleVerticalModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Users {

    @SerializedName("response")
    private String response;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("strip_banner_image")
    private String strip_banner_image;

    @SerializedName("categories")
    private List<CategoryModel> category;

    @SerializedName("categories2")
    private List<PlateModel> categoryPlate;

    @SerializedName("banners")
    private List<BannerModel> bannerModelList;

    @SerializedName("random_shops")
    private List<SimpleVerticalModel> simpleVerticalModelList;

    @SerializedName("great_offers_shops_vertical")
    private List<SimpleVerticalModel> great_offers_shops_vertical;

    @SerializedName("great_offers_shops")
    private List<GreatOffersModel> greatOffersModelList;

    @SerializedName("new_arrivals_shops_vertical")
    private List<SimpleVerticalModel> newArrivalVerticalList;

    @SerializedName("new_arrivals_shops")
    private List<GreatOffersModel> newArrivalList;

    public String getResponse() {
        return response;
    }

    public String getUserId() {
        return userId;
    }

    public String getStrip_banner_image() {
        return strip_banner_image;
    }

    public List<CategoryModel> getCategory() {
        return category;
    }

    public List<PlateModel> getCategoryPlate() {
        return categoryPlate;
    }

    public List<BannerModel> getBannerModelList() {
        return bannerModelList;
    }

    public List<SimpleVerticalModel> getSimpleVerticalModelList() {
        return simpleVerticalModelList;
    }

    public List<GreatOffersModel> getGreatOffersModelList() {
        return greatOffersModelList;
    }

    public List<SimpleVerticalModel> getGreat_offers_shops_vertical() {
        return great_offers_shops_vertical;
    }

    public List<SimpleVerticalModel> getNewArrivalVerticalList() {
        return newArrivalVerticalList;
    }

    public List<GreatOffersModel> getNewArrivalList() {
        return newArrivalList;
    }
}
