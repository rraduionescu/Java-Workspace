package com.ase.ionescuradu.carexpress.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.ase.ionescuradu.carexpress.R;
import com.ase.ionescuradu.carexpress.adapters.RentalAdapter;
import com.ase.ionescuradu.carexpress.utilities.DatabaseTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Objects;

//  Created by Ionescu Radu Stefan  //

public class ConfirmationActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        //<editor-fold desc="Recycler View: Confirmation">
        final JSONObject rentalVehicle;
        final JSONArray rentalVehicles;
        final JSONArray rentalOptions;

        try
        {
            RecyclerView recyclerView = findViewById(R.id.rvConfirmation);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            rentalVehicle = new JSONObject(Objects.requireNonNull(getIntent().getExtras()).getString("vehicle_json"));
            rentalVehicle.put("start_date", getIntent().getExtras().getString("start_date"));
            rentalVehicle.put("end_date", getIntent().getExtras().getString("end_date"));
            rentalVehicles = new JSONArray("[" + rentalVehicle.toString() + "]");
            rentalOptions = new JSONArray(getIntent().getExtras().getString("option_json"));
            RentalAdapter rentalAdapter = new RentalAdapter(rentalVehicles, rentalOptions, getApplicationContext(), getIntent());

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(rentalAdapter);

            //<editor-fold desc="Button Listeners: Confirm/Cancel">
            findViewById(R.id.bConfirm).setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    try
                    {
                        String response = new DatabaseTask(getApplicationContext(), getIntent()).execute("insert_rental").get();
                        JSONArray array = new JSONArray(response);
                        String id_rental = array.getJSONObject(0).getString("id_rental");
                        new DatabaseTask(getApplicationContext(), getIntent()).execute("insert_option_row", id_rental);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(ConfirmationActivity.this);
                    dialogBuilder.setTitle(R.string.title).setMessage(R.string.confirmation).setCancelable(false).setPositiveButton(R.string.bNeutral, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i)
                        {
                            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                            startActivity(intent);
                        }
                    });
                    AlertDialog alertDialog = dialogBuilder.create();
                    alertDialog.show();
                }
            });

            findViewById(R.id.bCancel).setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.tRentC), Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            });
            //</editor-fold>
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //</editor-fold>

        //<editor-fold desc="Button Listeners: Pressed Colors">
        findViewById(R.id.bConfirm).setOnTouchListener(new View.OnTouchListener()
        {
            @SuppressLint("ClickableViewAccessibility")
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                    {
                        v.getBackground().setColorFilter(0xe026A65B, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
        findViewById(R.id.bCancel).setOnTouchListener(new View.OnTouchListener()
        {
            @SuppressLint("ClickableViewAccessibility")
            public boolean onTouch(View v, MotionEvent event)
            {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                    {
                        v.getBackground().setColorFilter(0xe0EF4836, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
        //</editor-fold>
    }
}