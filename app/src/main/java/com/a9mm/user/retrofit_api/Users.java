package com.a9mm.user.retrofit_api;

import com.a9mm.user.models.BannerModel;
import com.a9mm.user.models.CategoryModel;
import com.a9mm.user.models.PlateModel;
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

    public String getResponse() {
        return response;
    }

    public String getUserId() {
        return userId;
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
    public String getStrip_banner_image() {
        return strip_banner_image;
    }
}
