package com.marvel.beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Events {
    @SerializedName("available")
    private int available;
    @SerializedName("collectionURI")
    private String collectionURI;
    @SerializedName("items")
    private List<ItemsXXX> items;
    @SerializedName("returned")
    private int returned;

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<ItemsXXX> getItems() {
        return items;
    }

    public void setItems(List<ItemsXXX> items) {
        this.items = items;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }
}
