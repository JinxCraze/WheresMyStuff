package com.lithub.team8.wheresmystuff.controller;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.lithub.team8.wheresmystuff.R;
import com.lithub.team8.wheresmystuff.model.Item;
import com.lithub.team8.wheresmystuff.model.Model;

import java.util.List;

public class GoogleMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<Item> list = Model.getItems();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googlemap);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        //googleMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        mMap = googleMap;
        Marker m;
        Item current;
        LatLng currentLL;
        String currentType;
        String name;

        LatLng atlanta = new LatLng(33.7490, -84.3880);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(atlanta));

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                current = list.get(i);
                currentLL = current.getLocationLL();
                currentType = current.getType();
                name = current.getName();

                if (currentType.equals("Found Item")) {
                    //Found items have green markers
                    m = mMap.addMarker(new MarkerOptions()
                            .position(currentLL)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                            .title(currentType)
                            .snippet(name));
                } else {
                    //Lost items have red markers
                    m = mMap.addMarker(new MarkerOptions()
                            .position(currentLL)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                            .title(currentType)
                            .snippet(name));
                }

            }
        }
    }
}
