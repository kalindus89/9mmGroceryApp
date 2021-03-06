package com.a9mm.user.retrofit_api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("register_email.php")
    Call<Users> performEmailRegistration(
            @Query("user_name") String user_name,
            @Query("user_email") String user_email,
            @Query("user_password") String user_password
    );

    @GET("login_email.php")
    Call<Users> performEmailLogin(
            @Query("user_email") String user_email,
            @Query("user_password") String user_password
    );

    @GET("register_phone.php")
    Call<Users> performPhoneRegistration(
            @Query("user_phone") String user_phone
    );

    @GET("login_phone.php")
    Call<Users> performPhoneLogin(
            @Query("user_phone") String user_phone
    );

    @GET("categories.php")
    Call<Users> getCategories();

    @GET("categories_login.php")
    Call<Users> getCategoriesPlate();

    @GET("banners.php")
    Call<Users> getAllBanners();

    @GET("strip_banner.php")
    Call<Users> getStripBanner();

    @GET("random_shops.php")
    Call<Users> getRandomShops();

    @GET("great_offers_shops.php")
    Call<Users> getGreatOfferShops();

    @GET("great_offers_shops_vertical.php")
    Call<Users> getGreatOfferShopsVertical();

    @GET("new_arrivals_shops.php")
    Call<Users> get_new_arrivals_Shops();

    @GET("new_arrivals_shops_vertical.php")
    Call<Users> getNew_Arrivals_Shops_Vertical();


}
