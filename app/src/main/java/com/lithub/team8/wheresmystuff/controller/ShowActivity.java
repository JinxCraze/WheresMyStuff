package com.lithub.team8.wheresmystuff.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lithub.team8.wheresmystuff.R;
import com.lithub.team8.wheresmystuff.model.Item;
import com.lithub.team8.wheresmystuff.model.Model;

public class ShowActivity extends AppCompatActivity {
    /**
     *
     * @param savedInstanceState what is imported
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Model.getInstance();

    }

    public void setData(Item item) {

        String name = item.getName();
        String desc = item.getDescription();
        String location = item.getLocation();

        TextView nameText = (TextView) findViewById(R.id.iname);
        TextView descText = (TextView) findViewById(R.id.idescription);
        TextView locationText = (TextView) findViewById(R.id.ilocation);

        nameText.setText(name);
        descText.setText(desc);
        locationText.setText(location);
    }
}
