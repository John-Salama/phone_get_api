package com.ahmdalii.mvvmdemo.ui.home.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ahmdalii.mvvmdemo.model.ProductsResponse;
import com.ahmdalii.mvvmdemo.ui.home.repo.HomeRepo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<ProductsResponse> _productsResponseMutableLiveData = new MutableLiveData<>();
    public LiveData<ProductsResponse> productsResponseMutableLiveData = _productsResponseMutableLiveData;

    private HomeRepo repo;

    public HomeViewModel(HomeRepo repo) {
        this.repo = repo;
    }

    public void getProducts() {

        Call<ProductsResponse> products = repo.getProducts();
        products.enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {
                if (response.isSuccessful()) {
                    _productsResponseMutableLiveData.postValue(response.body());
                } else {
                    // error
                }
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {

            }
        });
    }
}
