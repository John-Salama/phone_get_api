package com.ahmdalii.mvvmdemo.ui.home.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmdalii.mvvmdemo.R;
import com.ahmdalii.mvvmdemo.model.Products;
import com.ahmdalii.mvvmdemo.network.ProductsClient;
import com.ahmdalii.mvvmdemo.ui.home.repo.HomeRepoImpl;
import com.ahmdalii.mvvmdemo.ui.home.viewmodel.HomeViewModel;
import com.ahmdalii.mvvmdemo.ui.home.viewmodel.HomeViewModelFactory;
import com.bumptech.glide.Glide;

public class InfoPage extends AppCompatActivity {

    private int mNextPosition;
    private HomeViewModel homeViewModel;
    private RecyclerView mRecyclerView;
    private TextView mPriceAfterDiscount;
    private TextView mDiscount;
    private ImageView mPhoneImage;
    private TextView mPhoneDescriptionText;
    private TextView mPhonePriceText;
    private TextView mPhoneNameText;
    private Products mProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);
        Intent intent = getIntent();
        mNextPosition = intent.getIntExtra("position", 0);
        mRecyclerView = findViewById(R.id.info_recycler_imgs);
        InitializeData();
        gettingViewModelReady();
        getImages();

    }

    private void fillData() {
        mPhoneNameText.setText(mProduct.getTitle());
        mPhoneDescriptionText.setText(mProduct.getDescription());
        mPhonePriceText.setText(""+mProduct.getPrice());
        Glide.with(this)
                .load(mProduct.getProductImage())
                .override(300, 300)
                .into(mPhoneImage);
        if (mProduct.getDiscountPercentage() != 0) {
            mPhonePriceText.setPaintFlags(mPhonePriceText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            mDiscount.setText("-" + mProduct.getDiscountPercentage() + "%");
            mPriceAfterDiscount.setText("EGP "+ (float) (mProduct.getPrice() - mProduct.getDiscountPercentage() * mProduct.getPrice() / 100));
        } else
        {
            mDiscount.setVisibility(View.INVISIBLE);
            mPriceAfterDiscount.setVisibility(View.INVISIBLE);
        }


    }

    private void InitializeData() {
        mPhoneNameText = findViewById(R.id.info_title);
        mPhonePriceText = findViewById(R.id.info_price);
        mPhoneDescriptionText = findViewById(R.id.info_description);
        mPhoneImage = findViewById(R.id.info_image);
        mDiscount = findViewById(R.id.info_discount);
        mPriceAfterDiscount = findViewById(R.id.info_price_disc);
    }

    private void gettingViewModelReady() {
        HomeViewModelFactory homeViewModelFactory = new HomeViewModelFactory(
                HomeRepoImpl.getInstance(
                        ProductsClient.getInstance()
                )
        );

        homeViewModel = new ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel.class);
    }

    private void getImages() {
        homeViewModel.getProducts();

        homeViewModel.productsResponseMutableLiveData.observe(this, productsResponse -> {
            LinearLayoutManager phoneLayoutManager = new LinearLayoutManager(InfoPage.this);
            phoneLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mRecyclerView.setLayoutManager(phoneLayoutManager);
            mProduct = productsResponse.getProducts().get(mNextPosition);
            ImageAdapter imagesRecyclerAdapter = new ImageAdapter(InfoPage.this, mProduct.getImages());
            mRecyclerView.setAdapter(imagesRecyclerAdapter);
            fillData();
            Log.d("weAreFinished:", productsResponse.toString());
        });
    }
}