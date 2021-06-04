package com.a9mm.user.retrofit_api;

import com.google.gson.annotations.SerializedName;

public class Users {

    @SerializedName("response")
    private String response;

    @SerializedName("user_id")
    private String userId;

    public String getResponse() {
        return response;
    }

    public String getUserId() {
        return userId;
    }
}
