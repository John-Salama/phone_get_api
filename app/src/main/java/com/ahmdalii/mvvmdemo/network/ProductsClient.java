package com.ahmdalii.mvvmdemo.network;

import com.ahmdalii.mvvmdemo.model.Products;
import com.ahmdalii.mvvmdemo.model.ProductsResponse;

import retrofit2.Call;

public class ProductsClient implements RemoteDataSource {

    private ProductsClient() {

    }

    public static ProductsClient getInstance() {
        return new ProductsClient();
    }

    @Override
    public Call<ProductsResponse> getProducts() {
        return BaseRetrofitHelper.getInstance().create(APIService.class).getProducts();
    }
}
