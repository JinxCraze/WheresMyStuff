package com.lithub.team8.wheresmystuff.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.lithub.team8.wheresmystuff.R;
import com.lithub.team8.wheresmystuff.model.Item;
import com.lithub.team8.wheresmystuff.model.Model;

import java.util.List;

import static android.graphics.Color.RED;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "";
    private List<Item> list = Model.getItems();
    DatabaseReference mItemReference;

    @Override
    protected  void onStart() {
        super.onStart();
        ValueEventListener itemListener = new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Item item = dataSnapshot.getValue(Item.class);
                list.add(item);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        mItemReference.addValueEventListener(itemListener);
    }

    /**
     * does this when activity is created
     * @param savedInstanceState the saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View mRecyclerView = findViewById(R.id.items_list);
        assert mRecyclerView != null;
        setupRecyclerView((RecyclerView) mRecyclerView);
        setTitle("Where\'s My Stuff? Feed");

        RVAdapter adapter = new RVAdapter(list);
        ((RecyclerView) mRecyclerView).setAdapter(adapter);

        Button mLogoutButton = (Button) findViewById(R.id.buttonLogout);
        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(),
                        LoginActivity.class));
            }
        });

        FloatingActionButton search
            = (FloatingActionButton) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(),
                        SearchActivity.class));
                }
        });

        FloatingActionButton fab
            = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(),
                        CreateFormActivity.class));
                }
        });

        FloatingActionButton map =
                (FloatingActionButton) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),
                        GoogleMapActivity.class));
            }
        });
    }

    /**
     * Set up an adapter and hook it to the provided view
     * @param recyclerView  the view that needs this adapter
     */
    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        Model model = Model.getInstance();
        recyclerView.setAdapter(new RVAdapter(model.getItems()));
    }


    private static class RVAdapter extends
        RecyclerView.Adapter<RVAdapter.ViewHolder> {

        /**
         * Collection of the items to be shown in this list.
         */
        private final List<Item> items;

        /**
         * set the items to be used by the adapter
         * @param items the list of items to be displayed in the recycler view
         */
        private RVAdapter(List<Item> items) {
            this.items = items;
        }

        /**
         *
         */
        @Override
        public int getItemCount() {
            return items.size();
        }

        /**
         * @param viewGroup type of group
         * @param i postition
         */
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_layout_content, viewGroup, false);
            return new ViewHolder(v);
        }

        /**
         * @param viewHolder type of group
         * @param i position
         */
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            final Model model = Model.getInstance();

            if(model.get(i).getType().equals("Lost Item")) {
                viewHolder.itemName.setTextColor(RED);
            }
            viewHolder.itemName.setText(model.get(i).getType() + ": "
                + model.get(i).getName());
            viewHolder.itemLocation.setText(model.get(i).getLocation());
            viewHolder.itemDescription.setText(model.get(i).getDescription());

        }

        /**
         * @param recyclerView this is the wanted recycler view
         */
        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }

        /**
         * Inner class to work with recyclerView
         */
        protected class ViewHolder extends RecyclerView.ViewHolder {

            private final TextView itemName;
            private final TextView itemLocation;
            private final TextView itemDescription;

            /**
             * Contstruction
             * @param itemView the itemview we want
             */
            ViewHolder(View itemView) {
                super(itemView);
                itemName = (TextView) itemView.findViewById(R.id.name);
                itemLocation = (TextView) itemView.findViewById(R.id.location);
                itemDescription
                    = (TextView) itemView.findViewById(R.id.description);
            }

            /**
             * toString method
             */
            public String toString() {
                return super.toString() + " ";
            }
        }
    }
}
