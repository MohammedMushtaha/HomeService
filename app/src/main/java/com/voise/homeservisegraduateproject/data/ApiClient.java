package com.voise.homeservisegraduateproject.data;


import androidx.annotation.NonNull;

import com.voise.homeservisegraduateproject.BuildConfig;
import com.voise.homeservisegraduateproject.SharedPreferanse.SharedPreferanse;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.voise.homeservisegraduateproject.data.FunctionServer.BaseUrl;


class ApiClient {

    private static String TAG = "ApiClient";


    static Retrofit getClient(boolean authorization, int v) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS);

        httpClient.addInterceptor(logging);

        httpClient.addInterceptor(new Interceptor() {
                                      @Override
                                      public Response intercept(@NonNull Chain chain) throws IOException {

                                          Request original = chain.request();
                                          Request request = original.newBuilder()
                                                  .header("Content-Type", "application/x-www-form-urlencoded")
                                                  .header("Accept", "application/json")
                                                  .header("Accept-Language", "ar")
                                                  .header("Authorization", SharedPreferanse.read(SharedPreferanse.TOKEN, ""))
                                                  .method(original.method(), original.body())
                                                  .build();

                                          return chain.proceed(request);
                                      }
                                  }


        );


        if (v == 2) {
            return new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        } else {
            return new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }


    }


}