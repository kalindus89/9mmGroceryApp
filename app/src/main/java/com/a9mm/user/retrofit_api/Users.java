package com.a9mm.user.retrofit_api;

import com.a9mm.user.models.CategoryModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Users {

    @SerializedName("response")
    private String response;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("categories")
    private List<CategoryModel> category;

    public String getResponse() {
        return response;
    }

    public String getUserId() {
        return userId;
    }

    public List<CategoryModel> getCategory() {
        return category;
    }
}
