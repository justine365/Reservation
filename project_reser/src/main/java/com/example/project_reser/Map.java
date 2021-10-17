package com.example.project_reser;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Map extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback {
    String lat;
    String lng;
    String name;
    String address;
    String phone;
    Fragment fragment = new MapsFragment();
    GoogleMap googleMap;
    Button Finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);


        Intent intent = getIntent();

        lat = intent.getExtras().getString("lat");
        lng = intent.getExtras().getString("lng");
        name = intent.getExtras().getString("name");
        address = intent.getExtras().getString("address");
        phone = intent.getExtras().getString("phone");

        Log.d("shjang", "lat,lng ==>" + lat + "" + lng);


//        Finish = findViewById(R.id.finish);
//        Finish.setOnClickListener(this);


        if (ActivityCompat.checkSelfPermission(Map.this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            SupportMapFragment mapFragment = SupportMapFragment.newInstance();
            getSupportFragmentManager().
                    beginTransaction()
                    .replace(R.id.map, mapFragment)
                    .commit();
            mapFragment.getMapAsync(this);


        } else {
            ActivityCompat.requestPermissions(Map.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 44) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                SupportMapFragment mapFragment = SupportMapFragment.newInstance();
                getSupportFragmentManager().
                        beginTransaction()
                        .replace(R.id.map, mapFragment)
                        .commit();
                mapFragment.getMapAsync(this);

            }
        }
    }


    @Override
    public void onClick(View v) {
        Intent f_ = new Intent(this, Reser_Result.class);
        startActivity(f_);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap = googleMap;
        MarkerOptions mOptions = new MarkerOptions();
        LatLng seoul = new LatLng(Double.parseDouble(lat), Double.parseDouble(lng));


        MarkerOptions makerOptions = new MarkerOptions();
        makerOptions
                .position(seoul)
                .title(name)
                .snippet(address+" "+phone);


        // 마커를 생성한다. showInfoWindow를 쓰면 처음부터 마커에 상세정보가 뜨게한다. (안쓰면 마커눌러야뜸)
        googleMap.addMarker(makerOptions); //.showInfoWindow();

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seoul, 16));

    }
}