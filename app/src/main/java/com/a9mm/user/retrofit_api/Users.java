package com.a9mm.user.retrofit_api;

import com.a9mm.user.models.CategoryModel;
import com.a9mm.user.models.PlateModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Users {

    @SerializedName("response")
    private String response;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("categories")
    private List<CategoryModel> category;

    @SerializedName("categories2")
    private List<PlateModel> categoryPlate;

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
}
