package com.ase.ionescuradu.carexpress.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ase.ionescuradu.carexpress.R;
import com.ase.ionescuradu.carexpress.adapters.VehicleAdapter;
import com.ase.ionescuradu.carexpress.utilities.DatabaseTask;

import org.json.JSONArray;

//  Created by Ionescu Radu Stefan  //

public class RentActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);

        //<editor-fold desc="Recycler View: Vehicles">
        try
        {
            RecyclerView recyclerView = findViewById(R.id.rvVehicles);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            String response = new DatabaseTask(getApplicationContext(), getIntent()).execute("select_vehicle").get();
            JSONArray array = new JSONArray(response);
            VehicleAdapter vehicleAdapter = new VehicleAdapter(array, getApplicationContext(), getIntent());

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(vehicleAdapter);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //</editor-fold>
    }
}