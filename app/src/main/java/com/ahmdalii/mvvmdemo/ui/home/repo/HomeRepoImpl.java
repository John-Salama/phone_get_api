package com.ahmdalii.mvvmdemo.ui.home.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ahmdalii.mvvmdemo.model.ProductsResponse;
import com.ahmdalii.mvvmdemo.network.RemoteDataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepoImpl implements HomeRepo {

    private RemoteDataSource remoteDataSource;

    private HomeRepoImpl (RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public static HomeRepoImpl getInstance(RemoteDataSource remoteDataSource) {
        return new HomeRepoImpl(remoteDataSource);
    }

    @Override
    public Call<ProductsResponse> getProducts() {
        return remoteDataSource.getProducts();
    }
}
