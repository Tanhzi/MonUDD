package com.example.myapplication.t61;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Product implements Parcelable {
    private String styleId;

    private String brand;

    private String price;
    private String additionInfo;
    private String SearchImage;

    public Product() {
    }

    public Product(String styleId, String brand, String price, String additionInfo, String searchImage) {
        this.styleId = styleId;
        this.brand = brand;
        this.price = price;
        this.additionInfo = additionInfo;
        SearchImage = searchImage;
    }

    protected Product(Parcel in) {
        styleId = in.readString();
        brand = in.readString();
        price = in.readString();
        additionInfo = in.readString();
        SearchImage = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getStyleId() {
        return styleId;
    }

    public void setStyleId(String styleId) {
        this.styleId = styleId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAdditionInfo() {
        return additionInfo;
    }

    public void setAdditionInfo(String additionInfo) {
        this.additionInfo = additionInfo;
    }

    public String getSearchImage() {
        return SearchImage;
    }

    public void setSearchImage(String searchImage) {
        SearchImage = searchImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(styleId);
        dest.writeString(brand);
        dest.writeString(price);
        dest.writeString(additionInfo);
        dest.writeString(SearchImage);
    }
}
