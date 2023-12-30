package com.example.collectproductinfoapp;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShowProductsActivity  extends AppCompatActivity {


    ListView listview;
    ArrayList<Product>stockList;


    ListviewBaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);



        listview = findViewById(R.id.list_products); // Adapter View
        stockList = ((MyApp) getApplication()).appProductlist; // data
        adapter = new ListviewBaseAdapter(stockList, this);

        listview.setAdapter(adapter);


    }
}