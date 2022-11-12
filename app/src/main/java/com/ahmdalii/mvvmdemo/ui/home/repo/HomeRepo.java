package com.ahmdalii.mvvmdemo.ui.home.repo;

import com.ahmdalii.mvvmdemo.model.ProductsResponse;

import retrofit2.Call;

public interface HomeRepo {

    Call<ProductsResponse> getProducts();
}
