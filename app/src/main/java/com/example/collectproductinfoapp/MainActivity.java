package com.example.collectproductinfoapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ImageView cameraImage;
    EditText productName;
    Button saveButton;

    Button photoButton;

    Bitmap bitmap;
    BaseAdapter adapter;

    ArrayList<Product> stockList;


    ActivityResultLauncher<Intent> cameraActivityLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productName = findViewById(R.id.txt_productname);
        cameraImage = findViewById(R.id.imageview);
        photoButton = findViewById(R.id.btn_photo);
        saveButton = findViewById(R.id.btn_save);

        saveButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Log.d("testing save","save clicked");
        Product p =  new Product(productName.getText().toString(),bitmap);

        stockList.add(p);

        Toast.makeText(MainActivity.this,"save clicked",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this,ShowProductsActivity.class);

       startActivity(intent);

    }
});






       stockList = ((MyApp)getApplication()).appProductlist;


        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // implicit
                if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    Log.d("permission", "after give the permission");
                    // if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                    // if there are more than 1 app to handle the intent,
                    // the os will ask the user.
                    //  startActivityForResult(cameraInent, REQUEST_IMAGE_CAPTURE);
                    cameraActivityLauncher.launch(cameraIntent);
                    // }
                } else {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);
                    Log.d("permission", "after request the permission");

                }

            }
        });

        cameraActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {

                             bitmap = result.getData().getParcelableExtra("data");
                            cameraImage.setImageBitmap(bitmap);
                        }
                    }
                });


    }



}