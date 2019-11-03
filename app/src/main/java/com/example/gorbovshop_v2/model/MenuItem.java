package com.example.gorbovshop_v2.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.gorbovshop_v2.R;

public class MenuItem implements Parcelable {
    private int mImageResource;
    private String mItemName;
    private String mItemDescription;
    private int mItemPrice;
    private int mItemCode;

    public MenuItem(int imageResource, String itemName, String itemDescription, int itemPrice, ItemCode itemCode) {
        this.mImageResource = imageResource;
        this.mItemName = itemName;
        this.mItemDescription = itemDescription;
        this.mItemPrice = itemPrice;
        this.mItemCode = itemCode.getCode();
    }

    private MenuItem(Parcel in) {
        mImageResource = in.readInt();
        mItemName = in.readString();
        mItemDescription = in.readString();
        mItemPrice = in.readInt();
        mItemCode = in.readInt();
    }

    public static final Creator<MenuItem> CREATOR = new Creator<MenuItem>() {
        @Override
        public MenuItem createFromParcel(Parcel in) {
            return new MenuItem(in);
        }

        @Override
        public MenuItem[] newArray(int size) {
            return new MenuItem[size];
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
