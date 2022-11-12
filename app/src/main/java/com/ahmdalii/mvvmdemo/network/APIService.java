package com.ahmdalii.mvvmdemo.network;

import com.ahmdalii.mvvmdemo.model.ProductsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    // https://dummyjson.com/products
    @GET("products")
    Call<ProductsResponse> getProducts();
}
