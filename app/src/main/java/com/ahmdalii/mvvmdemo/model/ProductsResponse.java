package com.ahmdalii.mvvmdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ProductsResponse implements Parcelable {

    private ArrayList<Products> products;
    private int total;
    private int skip;
    private int limit;

    public ProductsResponse() { }

    public ProductsResponse(ArrayList<Products> products, int total, int skip, int limit) {
        this.products = products;
        this.total = total;
        this.skip = skip;
        this.limit = limit;
    }

    protected ProductsResponse(Parcel in) {
        products = in.createTypedArrayList(Products.CREATOR);
        total = in.readInt();
        skip = in.readInt();
        limit = in.readInt();
    }

    public static final Creator<ProductsResponse> CREATOR = new Creator<ProductsResponse>() {
        @Override
        public ProductsResponse createFromParcel(Parcel in) {
            return new ProductsResponse(in);
        }

        @Override
        public ProductsResponse[] newArray(int size) {
            return new ProductsResponse[size];
        }
    };

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(products);
        dest.writeInt(total);
        dest.writeInt(skip);
        dest.writeInt(limit);
    }

    @Override
    public String toString() {
        return "ProductsResponse{" +
                "products=" + products +
                ", total=" + total +
                ", skip=" + skip +
                ", limit=" + limit +
                '}';
    }
}
