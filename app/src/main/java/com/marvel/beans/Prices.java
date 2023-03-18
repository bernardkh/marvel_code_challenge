package com.marvel.beans;

import com.google.gson.annotations.SerializedName;

public class Prices {
    @SerializedName("type")
    private String type;
    @SerializedName("price")
    private String price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
