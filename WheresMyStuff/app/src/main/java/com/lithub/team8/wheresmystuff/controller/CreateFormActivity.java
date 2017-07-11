package com.lithub.team8.wheresmystuff.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.lithub.team8.wheresmystuff.R;
import com.lithub.team8.wheresmystuff.model.Item;
import com.lithub.team8.wheresmystuff.model.Model;

public class CreateFormActivity extends AppCompatActivity {

    private EditText mItemName;
    private EditText mItemLocation;
    private EditText mItemDescription;
    private Spinner mItemType;
    private Button submit;

    private String itemType;
    private String itemName;
    private String itemLocation;
    private String itemDescription;

    /**
     * does this when activity is created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_form);
        setTitle("Lost Form");
        submit = (Button) findViewById(R.id.submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
    /**
     *
     */
    public void getData() {
        mItemName = (EditText) findViewById(R.id.name_text);
        mItemLocation = (EditText) findViewById(R.id.location_text);
        mItemDescription = (EditText) findViewById(R.id.description_text);
        mItemType = (Spinner) findViewById(R.id.form_option);

        itemName = mItemName.getText().toString();
        itemLocation = mItemLocation.getText().toString();
        itemDescription = mItemDescription.getText().toString();
        itemType = mItemType.getSelectedItem().toString();

    }
    /**
     *
     */
    public void setData() {
        getData();
        Item item = new Item(itemName, itemDescription, itemLocation, itemType);
        Model.getInstance().add(item);
    }
}
