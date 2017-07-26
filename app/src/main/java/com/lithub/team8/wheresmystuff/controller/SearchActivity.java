
package com.lithub.team8.wheresmystuff.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.lithub.team8.wheresmystuff.R;
import com.lithub.team8.wheresmystuff.model.Item;
import com.lithub.team8.wheresmystuff.model.Model;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private ArrayAdapter<Item> adapter;

    /**
     *
     * @param savedInstanceState what is imported
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final ListView lv = (ListView) findViewById(R.id.ListViewSearch);

        ArrayList<Item> arrayItems = new ArrayList<>();
        arrayItems.addAll(Model.getItems());

        adapter = new ArrayAdapter<>(SearchActivity.this,
            android.R.layout.simple_list_item_1, arrayItems);
        lv.setAdapter(adapter);
    }

    /**
     *
     * @param menu Menu Object
     * @return true if created, else false
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
