package com.nourasa.bootcampcourses;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.LocationSource;

import java.security.Provider;

public class AddEvent extends AppCompatActivity implements LocationListener {

    protected LocationManager locationManager;
    protected LocationListener locationListener;
    private Location location;
    private Provider provider;
    protected Context context;
    TextView txt_loc;
    Button save;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        txt_loc = findViewById(R.id.location);
        save = findViewById(R.id.save);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        locationManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, this, null);

        txt_loc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),MapsActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onLocationChanged(Location location) {
        Log.d("Location ","Location done");
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        Log.d("Location ","Location changed");
    }

    @Override
    public void onProviderEnabled(String s) {
        Log.d("Location ","Enable");
    }

    @Override
    public void onProviderDisabled(String s) {
        Log.d("Location ","Disable");
    }
}
