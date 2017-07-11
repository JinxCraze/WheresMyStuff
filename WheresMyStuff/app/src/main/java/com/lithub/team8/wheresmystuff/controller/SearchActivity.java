/**
 *
 */
package com.lithub.team8.wheresmystuff.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.lithub.team8.wheresmystuff.R;
import com.lithub.team8.wheresmystuff.model.Item;
import com.lithub.team8.wheresmystuff.model.Model;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ArrayAdapter<Item> adapter;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final ListView lv = (ListView) findViewById(R.id.ListViewSearch);

        ArrayList<Item> arrayItems = new ArrayList<>();
        arrayItems.addAll(Model.getItems());

        adapter = new ArrayAdapter<>(SearchActivity.this, android.R.layout.simple_list_item_1, arrayItems);
        lv.setAdapter(adapter);

//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            TextView name = (TextView) findViewById(R.id.iname);
//            TextView description = (TextView) findViewById(R.id.idescription);
//            TextView location = (TextView) findViewById(R.id.ilocation);
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Item selected = (Item) (lv.getItemAtPosition(position));
//                name.setText(selected.getName());
//                description.setText(selected.getDescription());
//                location.setText(selected.getLocation());
//                startActivity(new Intent(getApplicationContext(), ShowActivity.class));
//            }
//        });
    }

    /**
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
