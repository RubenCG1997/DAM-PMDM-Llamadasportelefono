package com.example.llamadasportelefono;

import android.Manifest;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CALL_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_contact0).setOnClickListener(v->callNumber(0));
        findViewById(R.id.btn_contact1).setOnClickListener(v->callNumber(1));
        findViewById(R.id.btn_contact2).setOnClickListener(v->callNumber(2));
        findViewById(R.id.btn_contact3).setOnClickListener(v->callNumber(3));
        findViewById(R.id.btn_contact4).setOnClickListener(v->callNumber(4));
        findViewById(R.id.btn_contact5).setOnClickListener(v->callNumber(5));

    }
    private void callNumber(int pos){

        String[] list = {"625912421","616646319","622334455","657453212","658912421","654320001"};

        if(checkPermission()){
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+ list[pos]));
            startActivity(intent);
        }

    }
    private boolean checkPermission() {
        boolean permission = false;
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
        } else {
            permission = true;
        }
        return permission;
    }
}