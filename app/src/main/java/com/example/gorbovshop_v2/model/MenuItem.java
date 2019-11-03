package com.example.gorbovshop_v2.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.gorbovshop_v2.R;

public class MenuItem implements Parcelable {
    private String mItemName;
    private String mItemDescription;
    private int mItemPrice;
    private int mItemCode;
    private int mImageResource;

    public MenuItem() {
    }

    public MenuItem(String mItemName, int mItemPrice, ItemCode mItemCode) {
        this.mItemName = mItemName;
        this.mItemPrice = mItemPrice;
        this.mItemCode = mItemCode.getCode();
    }

    private MenuItem(Parcel in) {
        mItemName = in.readString();
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

    public void setItemName(String mItemName) {
        this.mItemName = mItemName;
    }

    public int getItemPrice() {
        return mItemPrice;
    }

    public void setItemPrice(int mItemPrice) {
        this.mItemPrice = mItemPrice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mItemName);
        dest.writeInt(mItemPrice);
        dest.writeInt(mItemCode);
    }
}
