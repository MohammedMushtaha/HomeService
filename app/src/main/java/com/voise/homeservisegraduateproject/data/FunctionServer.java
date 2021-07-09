package com.voise.homeservisegraduateproject.data;


import android.net.Uri;

import com.voise.homeservisegraduateproject.bojo.AcceptUserResponse;
import com.voise.homeservisegraduateproject.bojo.AddOrderResponse;
import com.voise.homeservisegraduateproject.bojo.AllOfferResponse;
import com.voise.homeservisegraduateproject.bojo.AllWorkDataResponse;
import com.voise.homeservisegraduateproject.bojo.AuthResponseCustomer;
import com.voise.homeservisegraduateproject.bojo.AuthResponseProvider;
import com.voise.homeservisegraduateproject.bojo.CompletedOrderResponse;
import com.voise.homeservisegraduateproject.bojo.CreateOfferResponse;
import com.voise.homeservisegraduateproject.bojo.FinishOrderResponse;
import com.voise.homeservisegraduateproject.bojo.HomeProviderResponse;
import com.voise.homeservisegraduateproject.bojo.PendingOrderResponse;
import com.voise.homeservisegraduateproject.bojo.UnCompletedOrderResponse;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;


public class FunctionServer {

    public static final String BaseUrl = "http://test.taktakonline.com/api/";
    private DataInterface dataInterface;
    private static FunctionServer Instanse;
    public static boolean authorization1 = false;

    public FunctionServer() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BaseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
        System.out.println("Log authorization1 " + authorization1);

        dataInterface = ApiClient.getClient(authorization1, 1).create(DataInterface.class);
    }

    public static FunctionServer getInstanse(boolean authorization) {
        System.out.println("Log authorization1ss " + authorization1);
        if (null == Instanse) {
            Instanse = new FunctionServer();
        }
        return Instanse;
    }

    public Call<AuthResponseCustomer> loginAsCustomer(String email, String password) {
        return dataInterface.loginAsCustomer(email, password);
    }

    public Call<AuthResponseProvider> loginAsServiceProvider(String email, String password) {
        return dataInterface.loginAsServiceProvider(email, password);
    }

    public Call<AuthResponseCustomer> RegisterCustomer(String name, String email, String password, String phone) {
        return dataInterface.RegisterCustomer(name, email, password, phone);
    }

    public Call<AuthResponseProvider> RegisterProvider(String name, String email, String password, String phone, int work_id) {
        return dataInterface.RegisterProvider(name, email, password, phone, work_id);
    }

    public Call<AllWorkDataResponse> getAllWorkResponse() {
        return dataInterface.getAllWorkResponse();
    }

    public Call<PendingOrderResponse> getAllPendingRequest() {
        return dataInterface.getAllPendingRequest();
    }

    public Call<UnCompletedOrderResponse> getAllUnCompleteRequest() {
        return dataInterface.getAllUnCompleteRequest();
    }

    public Call<CompletedOrderResponse> getAllCompleteRequest() {
        return dataInterface.getAllCompleteRequest();
    }

    public Call<AllOfferResponse> getAllOfferUserRequest(int order_id) {
        return dataInterface.getAllOfferUserRequest(order_id);
    }

    public Call<FinishOrderResponse> FinishOrderRequest(int order_id) {
        return dataInterface.FinishOrderRequest(order_id);
    }

    public Call<AcceptUserResponse> AcceptOfferUserRequest(String delivery_id, String order_id ) {
        return dataInterface.AcceptOfferUserRequest(delivery_id,order_id);
    }
    public Call<HomeProviderResponse> HomeProviderService(String orderBy) {
        return dataInterface.HomeProviderService(orderBy);
    }

    public Call<CreateOfferResponse> createOfferRequest(String orderBy) {
        return dataInterface.createOfferRequest(orderBy);
    }

    public Call<AddOrderResponse> AddOrder(int work_id, String details, String details_address, List<Uri> photo, String phone, long latitude, long longitude) {

        RequestBody work_idB = RequestBody.create(work_id + "", MediaType.parse("text/plain"));
        RequestBody detailsB = RequestBody.create(details + "", MediaType.parse("text/plain"));
        RequestBody details_addressB = RequestBody.create(details_address + "", MediaType.parse("text/plain"));
        RequestBody phoneB = RequestBody.create(phone + "", MediaType.parse("text/plain"));
        RequestBody latB = RequestBody.create(latitude + "", MediaType.parse("text/plain"));
        RequestBody longB = RequestBody.create(longitude + "", MediaType.parse("text/plain"));

        HashMap<String, RequestBody> map = new HashMap<>();
        map.put("work_id", work_idB);
        map.put("details", detailsB);
        map.put("details_address", details_addressB);
        map.put("phone", phoneB);
        map.put("lat", latB);
        map.put("long", longB);

        File fileSubImg;
        MultipartBody.Part[] surveyImagesParts = new MultipartBody.Part[photo.size()];
        for (int index = 0; index < photo.size(); index++) {
            fileSubImg = new File(photo.get(index).getPath());
            RequestBody surveyBody = RequestBody.create(fileSubImg, MediaType.parse("image/*"));
            surveyImagesParts[index] = MultipartBody.Part.createFormData("photos[]", fileSubImg.getName(), surveyBody);
        }

        return dataInterface.AddOrder2(map, surveyImagesParts);
    }




//    public Call<ResponseStatus> UpdatePassword(String old_password, String password, String password_confirmation) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("old_password",old_password);
//        map.put("password",password);
//        map.put("password_confirmation",password_confirmation);
//        return dataInterface.UpdatePassword(map);
//    }
//
//    public Call<ConfigResponse> getConfigData() {
//        return dataInterface.getConfigResponse();
//
//    }
}
