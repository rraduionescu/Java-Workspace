package com.ase.ionescuradu.carexpress.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ase.ionescuradu.carexpress.R;
import com.ase.ionescuradu.carexpress.utilities.DatabaseTask;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

//  Created by Ionescu Radu Stefan  //

public class RentalAdapter extends RecyclerView.Adapter<RentalAdapter.RentalViewHolder>
{
    private final JSONArray jsonArray;
    private final JSONArray jsonOptions;
    private final Context context;
    private final Intent intent;

    static class RentalViewHolder extends RecyclerView.ViewHolder
    {
        final TextView tvStatus;
        final TextView tvrPower;
        final TextView tvrFuel;
        final TextView tvrGearbox;
        final TextView tvrConsumption;
        final TextView tvrTrunk;
        final TextView tvrDoors;
        final TextView tvrPrice;
        final TextView tvrId;
        final TextView tvrCentre;
        final TextView tvrStart;
        final TextView tvrEnd;
        final TextView tvrTotal;
        final TextView tvrCar;
        final TextView tvrOptions;
        final RecyclerView rvRentalOptions;
        final ImageView ivRental;

        RentalViewHolder(View itemView)
        {
            super(itemView);

            tvStatus = itemView.findViewById(R.id.tvStatus);
            tvrPower = itemView.findViewById(R.id.tvrPower);
            tvrFuel = itemView.findViewById(R.id.tvrFuel);
            tvrGearbox = itemView.findViewById(R.id.tvrGearbox);
            tvrConsumption = itemView.findViewById(R.id.tvrConsumption);
            tvrTrunk = itemView.findViewById(R.id.tvrTrunk);
            tvrDoors = itemView.findViewById(R.id.tvrDoors);
            tvrPrice = itemView.findViewById(R.id.tvrPrice);
            tvrId = itemView.findViewById(R.id.tvrId);
            tvrCentre = itemView.findViewById(R.id.tvrCentre);
            tvrStart = itemView.findViewById(R.id.tvrStart);
            tvrEnd = itemView.findViewById(R.id.tvrEnd);
            tvrTotal = itemView.findViewById(R.id.tvrTotal);
            tvrCar = itemView.findViewById(R.id.tvrCar);
            tvrOptions = itemView.findViewById(R.id.tvrOptions);
            rvRentalOptions = itemView.findViewById(R.id.rvRentalOptions);
            ivRental = itemView.findViewById(R.id.ivRental);
        }
    }

    public RentalAdapter(JSONArray jsonArray, JSONArray jsonOptions, Context context, Intent intent)
    {
        this.context = context;
        this.intent = intent;
        this.jsonOptions = jsonOptions;

        JSONArray sortedJsonArray = new JSONArray();

        List<JSONObject> jsonValues = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++)
        {
            try
            {
                jsonValues.add(jsonArray.getJSONObject(i));
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
        Collections.sort(jsonValues, new Comparator<JSONObject>()
        {
            private static final String KEY_NAME = "start_date";

            @Override
            public int compare(JSONObject a, JSONObject b)
            {
                try
                {
                    @SuppressLint("SimpleDateFormat")
                    Date valA = new SimpleDateFormat("yyyy-MM-dd").parse(a.getString(KEY_NAME));
                    @SuppressLint("SimpleDateFormat")
                    Date valB = new SimpleDateFormat("yyyy-MM-dd").parse(b.getString(KEY_NAME));
                    if (valA.getTime() < valB.getTime())
                    {
                        return 1;
                    }
                    else
                    {
                        return -1;
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                return 0;
            }
        });

        for (int i = 0; i < jsonArray.length(); i++)
        {
            sortedJsonArray.put(jsonValues.get(i));
        }
        this.jsonArray = sortedJsonArray;
    }

    @NonNull
    @Override
    public RentalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        @SuppressLint("InflateParams")
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_rental, null, false);
        return new RentalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RentalViewHolder holder, int position)
    {
        try
        {
            final JSONObject rental = jsonArray.getJSONObject(position);
            String vehicleResponse = new DatabaseTask(context, intent).execute("select_rental_vehicle", rental.get("id_vehicle").toString()).get();
            JSONArray vehicles = new JSONArray(vehicleResponse);
            JSONObject vehicle = vehicles.getJSONObject(0);
            String[] start = rental.get("start_date").toString().split("-");
            String[] end = rental.get("end_date").toString().split("-");
            String startDate = start[2] + " " + start[1] + " " + start[0];
            String endDate = end[2] + " " + end[1] + " " + end[0];
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayout.HORIZONTAL, false);
            Calendar startC = Calendar.getInstance();
            Calendar endC = Calendar.getInstance();
            startC.set(Integer.parseInt(start[0]), Integer.parseInt(start[1]) - 1, Integer.parseInt(start[2]));
            endC.set(Integer.parseInt(end[0]), Integer.parseInt(end[1]) - 1, Integer.parseInt(end[2]));
            Date startDateD = startC.getTime();
            Date endDateD = endC.getTime();
            long startTime = startDateD.getTime();
            long endTime = endDateD.getTime();
            long diffTime = endTime - startTime;
            long diffDays = diffTime / (1000 * 60 * 60 * 24);

            RentalOptionAdapter rentalOptionAdapter;
            if (jsonOptions == null)
            {
                Date current = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(current);
                c.add(Calendar.DATE, 1);
                if (endDateD.getTime() < current.getTime())
                {
                    holder.tvStatus.setText(context.getResources().getString(R.string.rst));
                    holder.tvStatus.setBackgroundResource(R.color.terminated_c);
                }
                else if (endDateD.getTime() >= current.getTime())
                {
                    if (startDateD.getTime() <= current.getTime())
                    {
                        holder.tvStatus.setText(context.getResources().getString(R.string.rsa));
                        holder.tvStatus.setBackgroundResource(R.color.active_c);
                    }
                    else if (startDateD.getDay() == c.getTime().getDay())
                    {
                        holder.tvStatus.setText(context.getResources().getString(R.string.rsr));
                        holder.tvStatus.setBackgroundResource(R.color.ready_c);
                    }
                    else if (startDateD.getTime() > current.getTime())
                    {
                        holder.tvStatus.setText(context.getResources().getString(R.string.rsp));
                        holder.tvStatus.setBackgroundResource(R.color.preparation_c);
                    }
                }
                String response = new DatabaseTask(context, intent).execute("select_rental_option", rental.get("id_rental").toString()).get();
                JSONArray options = new JSONArray(response);
                double carPrice = vehicle.getDouble("price");
                double optionsPrice = 0;
                for (int i = 0; i < options.length(); i++)
                {
                    optionsPrice += options.getJSONObject(i).getDouble("price");
                }
                holder.tvrCar.setText(context.getResources().getString(R.string.carprice, carPrice, (int) diffDays));
                holder.tvrOptions.setText(context.getResources().getString(R.string.optionprice, optionsPrice, (int) diffDays));
                holder.tvrTotal.setText(context.getResources().getString(R.string.totalprice, (optionsPrice + carPrice) * diffDays));
                rentalOptionAdapter = new RentalOptionAdapter(options, context);
            }
            else
            {
                double carPrice = vehicle.getDouble("price");
                double optionsPrice = 0;
                for (int i = 0; i < jsonOptions.length(); i++)
                {
                    optionsPrice += jsonOptions.getJSONObject(i).getDouble("price");
                }
                holder.tvrCar.setText(context.getResources().getString(R.string.carprice, carPrice, (int) diffDays));
                holder.tvrOptions.setText(context.getResources().getString(R.string.optionprice, optionsPrice, (int) diffDays));
                holder.tvrTotal.setText(context.getResources().getString(R.string.totalprice, (optionsPrice + carPrice) * diffDays));
                rentalOptionAdapter = new RentalOptionAdapter(jsonOptions, context);
            }

            holder.rvRentalOptions.setHasFixedSize(true);
            holder.rvRentalOptions.setLayoutManager(layoutManager);
            holder.rvRentalOptions.setAdapter(rentalOptionAdapter);

            holder.tvrPower.setText(context.getString(R.string.power, Integer.parseInt(vehicle.get("power").toString())));
            if (vehicle.get("fuel") == "0")
            {
                holder.tvrFuel.setText(context.getString(R.string.fuel1));
            }
            else
            {
                holder.tvrFuel.setText(context.getString(R.string.fuel2));
            }
            if (vehicle.get("gearbox") == "0")
            {
                holder.tvrGearbox.setText(context.getString(R.string.gearbox1));
            }
            else
            {
                holder.tvrGearbox.setText(context.getString(R.string.gearbox2));
            }
            holder.tvrConsumption.setText(context.getString(R.string.consumption, Float.parseFloat(vehicle.get("fuel_consumption").toString())));
            holder.tvrTrunk.setText(context.getString(R.string.trunk, Integer.parseInt(vehicle.get("trunk").toString())));
            holder.tvrDoors.setText(vehicle.get("doors").toString());
            holder.tvrPrice.setText(context.getString(R.string.price, Float.parseFloat(vehicle.get("price").toString())));
            holder.tvrId.setText(rental.get("id_vehicle").toString());
            holder.tvrCentre.setText(rental.get("id_centre").toString());
            holder.tvrStart.setText(startDate);
            holder.tvrEnd.setText(endDate);

            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference reference = storage.getReference().child("Vehicles/" + rental.get("id_vehicle") + ".png");
            reference.getBytes(1024 * 1024).addOnSuccessListener(new OnSuccessListener<byte[]>()
            {
                @Override
                public void onSuccess(byte[] bytes)
                {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    holder.ivRental.setImageBitmap(bitmap);
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount()
    {
        return jsonArray.length();
    }
}