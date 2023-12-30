package com.example.collectproductinfoapp;

import android.graphics.Bitmap;

public class Product {

    String name;
    Bitmap image;

    public String getName() {
        return name;
    }

    public Bitmap getImage() {
        return image;
    }

    public Product(String name, Bitmap image) {
        this.name = name;
        this.image = image;

    }
}
