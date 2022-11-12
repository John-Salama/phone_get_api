package com.ahmdalii.mvvmdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Products implements Parcelable {

    private int id;
    private String title;
    private String description;
    private double price;
    private float discountPercentage;
    private float rating;
    private int stock;
    private String brand;
    private String category;
    @SerializedName("thumbnail")
    private String productImage;
    private ArrayList<String> images;

    public Products() { }

    public Products(int id, String title, String description, double price, float discountPercentage, float rating, int stock, String brand, String category, String productImage, ArrayList<String> images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.rating = rating;
        this.stock = stock;
        this.brand = brand;
        this.category = category;
        this.productImage = productImage;
        this.images = images;
    }

    protected Products(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
        price = in.readDouble();
        discountPercentage = in.readFloat();
        rating = in.readFloat();
        stock = in.readInt();
        brand = in.readString();
        category = in.readString();
        productImage = in.readString();
        images = in.createStringArrayList();
    }

    public static final Creator<Products> CREATOR = new Creator<Products>() {
        @Override
        public Products createFromParcel(Parcel in) {
            return new Products(in);
        }

        @Override
        public Products[] newArray(int size) {
            return new Products[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeDouble(price);
        dest.writeFloat(discountPercentage);
        dest.writeFloat(rating);
        dest.writeInt(stock);
        dest.writeString(brand);
        dest.writeString(category);
        dest.writeString(productImage);
        dest.writeStringList(images);
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", rating=" + rating +
                ", stock=" + stock +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", productImage='" + productImage + '\'' +
                ", images=" + images +
                '}';
    }
}
