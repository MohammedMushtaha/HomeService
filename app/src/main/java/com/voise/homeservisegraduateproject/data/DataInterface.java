package com.voise.homeservisegraduateproject.data;


import com.voise.homeservisegraduateproject.bojo.AcceptUserResponse;
import com.voise.homeservisegraduateproject.bojo.AddOrderResponse;
import com.voise.homeservisegraduateproject.bojo.AllOfferResponse;
import com.voise.homeservisegraduateproject.bojo.AllWorkDataResponse;
import com.voise.homeservisegraduateproject.bojo.AuthResponseCustomer;
import com.voise.homeservisegraduateproject.bojo.AuthResponseProvider;
import com.voise.homeservisegraduateproject.bojo.CompletedOrderResponse;
import com.voise.homeservisegraduateproject.bojo.HomeProviderResponse;
import com.voise.homeservisegraduateproject.bojo.PendingOrderResponse;
import com.voise.homeservisegraduateproject.bojo.UnCompletedOrderResponse;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface DataInterface {

    @FormUrlEncoded
    @POST("auth/login/user")
    public Call<AuthResponseCustomer> loginAsCustomer(
            @Field("email") String email,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("auth/login/delivery")
    public Call<AuthResponseProvider> loginAsServiceProvider(
            @Field("email") String email,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("auth/register/user")
    public Call<AuthResponseCustomer> RegisterCustomer(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String phone,
            @Field("phone") String message);

    @FormUrlEncoded
    @POST("auth/register/delivery")
    public Call<AuthResponseProvider> RegisterProvider(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String phone,
            @Field("phone") String message,
            @Field("work_id") int work_id);

    @GET("all/works")
    public Call<AllWorkDataResponse> getAllWorkResponse();


    @POST("create/order")
    public Call<AddOrderResponse> AddOrder(@Body Map<String, Object> params);

    @Multipart
    @POST("create/order")
    public Call<AddOrderResponse> AddOrder2(
            @PartMap() Map<String, RequestBody> partMap,
            @Part MultipartBody.Part[] images);

    @GET("order/un/complete/user")
    public Call<PendingOrderResponse> getAllPendingRequest();

    @GET("order/pending/user")
    public Call<UnCompletedOrderResponse> getAllUnCompleteRequest();

    @GET("order/complete/user")
    public Call<CompletedOrderResponse> getAllCompleteRequest();


    @FormUrlEncoded
    @POST("get/all/offer")
    public Call<AllOfferResponse> getAllOfferUserRequest(
            @Field("order_id") int id);

    @FormUrlEncoded
    @POST("accept/offer")
    public Call<AcceptUserResponse> AcceptOfferUserRequest(
            @Field("delivery_id") String delivery_id,
            @Field("order_id") String order_id);


    @FormUrlEncoded
    @POST("home/deliver")
        public Call<HomeProviderResponse> HomeProviderService(
             @Field("orderBy") String orderBy);




//    @GET("order/pending/user")
//    public Call<PendingOrderResponse> getAllUnCompleteRequest();
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