package com.example.gorbovshop_v2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CartItem implements Parcelable {
    private int mImageResource;
    private String mItemName;
    private String mItemDescription;
    private int mItemPrice;
    private int mItemCode;

    public CartItem(int imageResource, ItemCode itemCode) {
        this.mImageResource = imageResource;
        this.mItemName = itemCode.getItemName();
        this.mItemDescription = itemCode.getDescription();
        this.mItemPrice = itemCode.getPrice();
        this.mItemCode = itemCode.getCode();
    }

    private CartItem(Parcel in) {
        mImageResource = in.readInt();
        mItemName = in.readString();
        mItemDescription = in.readString();
        mItemPrice = in.readInt();
        mItemCode = in.readInt();
    }

    public static final Creator<CartItem> CREATOR = new Creator<CartItem>() {
        @Override
        public CartItem createFromParcel(Parcel in) {
            return new CartItem(in);
        }

        @Override
        public CartItem[] newArray(int size) {
            return new CartItem[size];
        }
    };

    public int getItemCode() {
        return mItemCode;
    }

    public String getItemName() {
        return mItemName;
    }


    public int getItemPrice() {
        return mItemPrice;
    }


    public int getImageResource() {
        return mImageResource;
    }

    public String getItemDescription() {
        return mItemDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImageResource);
        dest.writeString(mItemName);
        dest.writeString(mItemDescription);
        dest.writeInt(mItemPrice);
        dest.writeInt(mItemCode);
    }
}
