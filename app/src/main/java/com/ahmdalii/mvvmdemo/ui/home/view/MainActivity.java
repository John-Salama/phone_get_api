package com.ahmdalii.mvvmdemo.ui.home.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.ahmdalii.mvvmdemo.R;
import com.ahmdalii.mvvmdemo.model.ProductsResponse;
import com.ahmdalii.mvvmdemo.network.ProductsClient;
import com.ahmdalii.mvvmdemo.ui.home.repo.HomeRepoImpl;
import com.ahmdalii.mvvmdemo.ui.home.viewmodel.HomeViewModel;
import com.ahmdalii.mvvmdemo.ui.home.viewmodel.HomeViewModelFactory;

public class MainActivity extends AppCompatActivity {

    private HomeViewModelFactory homeViewModelFactory;
    private HomeViewModel homeViewModel;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.phone_recyclier_view);

        gettingViewModelReady();
        getProducts();
    }

    private void gettingViewModelReady() {
        homeViewModelFactory = new HomeViewModelFactory(
                HomeRepoImpl.getInstance(
                        ProductsClient.getInstance()
                )
        );

        homeViewModel = new ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel.class);
    }

    private void getProducts() {
        homeViewModel.getProducts();

        homeViewModel.productsResponseMutableLiveData.observe(this, new Observer<ProductsResponse>() {
            @Override
            public void onChanged(ProductsResponse productsResponse) {
                LinearLayoutManager phoneLayoutManager = new LinearLayoutManager(MainActivity.this);
                mRecyclerView.setLayoutManager(phoneLayoutManager);
                PhoneAdapter productsRecyclerAdapter = new PhoneAdapter(MainActivity.this, productsResponse.getProducts());
                mRecyclerView.setAdapter(productsRecyclerAdapter);
                Log.d("weAreFinished:", productsResponse.toString());
            }
        });
    }
}