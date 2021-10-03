package com.example.project_reser;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;


public class Map extends AppCompatActivity implements View.OnClickListener{

    Fragment fragment= new MapsFragment();
    GoogleMap googleMap;
    Button Finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Finish = findViewById(R.id.finish);
        Finish.setOnClickListener(this);


        if (ActivityCompat.checkSelfPermission(Map.this, Manifest.permission.ACCESS_FINE_LOCATION)==
                PackageManager.PERMISSION_GRANTED){
            getSupportFragmentManager().
                    beginTransaction()
                    .replace(R.id.framelayout,fragment)
                    .commit();




        } else{
            ActivityCompat.requestPermissions(Map.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44 );
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 44) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getSupportFragmentManager().
                        beginTransaction()
                        .replace(R.id.framelayout,fragment)
                        .commit();


            }
        }
    }



    @Override
    public void onClick(View v) {
        Intent f_ = new Intent(this,Reser_Result.class);
        startActivity(f_);
    }

}