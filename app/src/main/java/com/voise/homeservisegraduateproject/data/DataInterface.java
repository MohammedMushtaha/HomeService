package com.voise.homeservisegraduateproject.data;


import com.voise.homeservisegraduateproject.bojo.AuthResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataInterface {

    @FormUrlEncoded
    @POST("auth/login/user")
    public Call<AuthResponse> loginAsCustomer(
            @Field("email") String email,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("auth/login/delivery")
    public Call<AuthResponse> loginAsServiceProvider(
            @Field("email") String email,
            @Field("password") String password);

//    @FormUrlEncoded
//    @POST("rate")
//    public Call<ResponseStatus> Rating(
//            @Field("rate") double rate,
//            @Field("comment") String comment,
//            @Field("service_id") int service_id);
//
//    @FormUrlEncoded
//    @POST("ContactUs")
//    public Call<ResponseStatus> ContactUs(
//            @Field("name") String name,
//            @Field("email") String email,
//            @Field("phone") String phone,
//            @Field("message") String message);
//
//    @FormUrlEncoded
//    @POST("store_client")
//    public Call<ResponseStatus> Subscribe(
//            @Field("name") String name,
//            @Field("email") String email,
//            @Field("gender") String phone,
//            @Field("type") String message);
//
//
//
//
//    @POST("user/password")
//    public Call<ResponseStatus> UpdatePassword(@Body Map<String, Object> params);
//
//    @GET("getConfig")
//    public Call<ConfigResponse> getConfigResponse();
//
//    @GET("categories")
//    public Call<CategoriesResponse> getCategoriesResponse();
//
//    @GET("services/{id}")
//    public Call<SpeciesDataResponse> getSpeciesDataResponse(@Path("id") int serviceId, @Query("title") String title, @Query("city_id") int city_id, @Query("page") int page);
//
//    @GET("services/{id}")
//    public Call<SpeciesDataResponse> getSpeciesDataResponse(@Path("id") int serviceId, @Query("city_id") int city_id, @Query("page") int page);
//
//    @GET("services/{id}")
//    public Call<SpeciesDataResponse> getSpeciesDataResponse(@Path("id") int serviceId, @Query("page") int page);
//
//    @GET("services/{id}")
//    public Call<SpeciesDataResponse> getSpeciesDataResponse(@Path("id") int serviceId, @Query("title") String title, @Query("page") int page);
//
//    @GET("cities")
//    public Call<CityResponse> getCityResponse();
//
//    @GET("notification")
//    public Call<NotificationResponse> getNotificationResponse();
//
//    @GET("service/{service}")
//    public Call<ServesDetailsResponse> getServiceResponseDetails(@Path("service") int serviceId);


}