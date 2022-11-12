package com.ahmdalii.mvvmdemo.network;

import static com.ahmdalii.mvvmdemo.utils.AppConstants.BASE_URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseRetrofitHelper {

    private static Retrofit retrofitHelper = null;

    private BaseRetrofitHelper() {
        if (retrofitHelper == null) {
            throw new IllegalStateException("You must use getter method to get Instance.");
        }
    }

    public static Retrofit getInstance() {

        if (retrofitHelper == null) {
            Gson gson = new GsonBuilder().serializeNulls().create();

            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .build();

            retrofitHelper = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
        }

        return retrofitHelper;
    }
}
