package com.example.collectproductinfoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListviewBaseAdapter  extends BaseAdapter {

    ArrayList<Product> productlist;

    Context context;

    public ListviewBaseAdapter(ArrayList<Product> productlist, Context context) {
        this.productlist = productlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return productlist.size();
    }

    @Override
    public Object getItem(int i) {
        return productlist.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewgroup) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //convert the layout into view object 'view'
        //select layout view, viewGroup, false (garbage collector)
        View view = inflater.inflate(R.layout.listview_row,viewgroup,false);

        TextView productName = view.findViewById(R.id.list_productname);
        ImageView image = view.findViewById(R.id.list_image);


        productName.setText(productlist.get(i).getName());
        image.setImageBitmap(productlist.get(i).getImage());


        return view;
    }
}
