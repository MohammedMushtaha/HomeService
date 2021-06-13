package com.voise.homeservisegraduateproject.data;


import com.voise.homeservisegraduateproject.bojo.AllWorkDataResponse;
import com.voise.homeservisegraduateproject.bojo.AuthResponseCustomer;
import com.voise.homeservisegraduateproject.bojo.AuthResponseProvider;

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

//
//    public Call<ResponseStatus> Rating(double rate, String comment, int service_id) {
//        return dataInterface.Rating(rate, comment, service_id);
//    }
//
//    public Call<CategoriesResponse> getCategoriess() {
//        return dataInterface.getCategoriesResponse();
//    }
//
//    public Call<SpeciesDataResponse> getSpeciesData(int serviceId, String title, int city_id, int page) {
//        return dataInterface.getSpeciesDataResponse(serviceId, title, city_id, page);
//    }
//
//    public Call<SpeciesDataResponse> getSpeciesData1(int serviceId, int city_id, int page) {
//        return dataInterface.getSpeciesDataResponse(serviceId, city_id, page);
//    }
//
//    public Call<SpeciesDataResponse> getSpeciesData2(int serviceId, int page) {
//        return dataInterface.getSpeciesDataResponse(serviceId, page);
//    }
//
//    public Call<SpeciesDataResponse> getSpeciesData3(int serviceId, String title, int page) {
//        return dataInterface.getSpeciesDataResponse(serviceId, title, page);
//    }
//
//    public Call<CityResponse> getCity() {
//        return dataInterface.getCityResponse();
//    }
//
//    public Call<ServesDetailsResponse> getServesDetails(int serviceId) {
//        return dataInterface.getServiceResponseDetails(serviceId);
//    }
//
//    public Call<NotificationResponse> getNotificationResponse() {
//        return dataInterface.getNotificationResponse();
//    }
//
//    public Call<ResponseStatus> ContactUs(String name, String email, String phone, String message) {
//        return dataInterface.ContactUs(name, email, phone, message);
//    }
//
//    public Call<ResponseStatus> Subscribe(String name, String email, String gender, String type) {
//
//        return dataInterface.Subscribe(name, email, gender, type);
//    }
//
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
