package com.ahmdalii.mvvmdemo.network;

import com.ahmdalii.mvvmdemo.model.ProductsResponse;

import retrofit2.Call;

public interface RemoteDataSource {

    Call<ProductsResponse> getProducts();
}
