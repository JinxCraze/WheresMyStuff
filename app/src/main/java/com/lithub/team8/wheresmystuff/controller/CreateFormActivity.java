package com.lithub.team8.wheresmystuff.controller;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lithub.team8.wheresmystuff.R;
import com.lithub.team8.wheresmystuff.model.Item;
import com.lithub.team8.wheresmystuff.model.Model;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CreateFormActivity extends FragmentActivity
        implements GoogleMap.OnMapClickListener, OnMapReadyCallback {

    private EditText mItemName;
    private EditText mItemDescription;
    private Spinner mItemType;
    private Button submit;
    private GoogleMap mMap;
    private Marker mMarker;
    private LatLng currentPosition;

    private String itemType;
    private String itemName;
    private String itemLocation;
    private String itemDescription;
    private LatLng itemLatLng;

    private DatabaseReference mDatabase;

    /**
     * does this when activity is created
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_form);
        setTitle("Lost Form");
        mDatabase = FirebaseDatabase.getInstance().getReference();

        //Set up Google Maps
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        submit = (Button) findViewById(R.id.submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData();
                startActivity(new Intent(getApplicationContext(),
                    MainActivity.class));
            }
        });
    }
    /**
     *
     */
    private void getData() {
        mItemName = (EditText) findViewById(R.id.name_text);
        mItemDescription = (EditText) findViewById(R.id.description_text);
        mItemType = (Spinner) findViewById(R.id.form_option);

        itemName = mItemName.getText().toString();
        itemLocation = getAddress();
        itemDescription = mItemDescription.getText().toString();
        itemType = mItemType.getSelectedItem().toString();
        itemLatLng = currentPosition;
    }
    /**
     *
     */
    private void setData() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        getData();
        Item item = new Item(itemName, itemDescription, itemLocation, itemType, itemLatLng.latitude, itemLatLng.longitude);
        mDatabase.child("Item").push().setValue(item);
        Model.getInstance().add(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng atlanta = new LatLng(33.7490, -84.3880);
        currentPosition = atlanta;


        mMarker = mMap.addMarker(new MarkerOptions()
                .position(atlanta)
                .title("Tap to move marker to position")
                .draggable(true));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(atlanta));

        mMap.setOnMapClickListener(this);
    }

    public void onMapClick(LatLng point) {
        currentPosition = point;
        mMarker.setPosition(point);
    }

    private String getAddress(){
        StringBuilder address = new StringBuilder();
        try {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(currentPosition.latitude,
                    currentPosition.longitude, 1);
            if (addresses.size() > 0) {
                Address addressName = addresses.get(0);
                address.append(addressName.getAddressLine(0)).append("\n");
                address.append(addressName.getLocality()).append(", ");
                address.append(addressName.getAdminArea()).append(", ");
                address.append(addressName.getCountryName());
            }
        } catch(IOException e) {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return address.toString();
    }
}
