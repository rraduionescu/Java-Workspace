package com.ase.ionescuradu.carexpress.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ase.ionescuradu.carexpress.R;
import com.ase.ionescuradu.carexpress.adapters.RentalAdapter;
import com.ase.ionescuradu.carexpress.utilities.DatabaseTask;

import org.json.JSONArray;

//  Created by Ionescu Radu Stefan  //

public class RentalsActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentals);

        //<editor-fold desc="Recycler View: Rentals">
        try
        {
            RecyclerView recyclerView = findViewById(R.id.rvRentals);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            String response = new DatabaseTask(getApplicationContext(), getIntent()).execute("select_rental").get();
            JSONArray array = new JSONArray(response);
            RentalAdapter rentalAdapter = new RentalAdapter(array, null, getApplicationContext(), getIntent());

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(rentalAdapter);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //</editor-fold>
    }
}