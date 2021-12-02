package com.ase.ionescuradu.carexpress.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ase.ionescuradu.carexpress.activities.OptionsActivity;
import com.ase.ionescuradu.carexpress.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Objects;

//  Created by Ionescu Radu Stefan  //

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>
{
    private final JSONArray jsonArray;
    private final Context context;
    private final Intent intent;

    static class VehicleViewHolder extends RecyclerView.ViewHolder
    {
        final TextView tvPower;
        final TextView tvFuel;
        final TextView tvGearbox;
        final TextView tvConsumption;
        final TextView tvTrunk;
        final TextView tvDoors;
        final TextView tvPrice;
        final TextView tvId;
        final TextView tvCentre;
        final ImageView ivcVehicle;
        final Button bRent;

        VehicleViewHolder(View itemView)
        {
            super(itemView);

            tvPower = itemView.findViewById(R.id.tvPower);
            tvFuel = itemView.findViewById(R.id.tvFuel);
            tvGearbox = itemView.findViewById(R.id.tvGearbox);
            tvConsumption = itemView.findViewById(R.id.tvConsumption);
            tvTrunk = itemView.findViewById(R.id.tvTrunk);
            tvDoors = itemView.findViewById(R.id.tvDoors);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvId = itemView.findViewById(R.id.tvId);
            tvCentre = itemView.findViewById(R.id.tvCentre);
            ivcVehicle = itemView.findViewById(R.id.ivcVehicle);
            bRent = itemView.findViewById(R.id.bRent);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    bRent.performClick();
                }
            });
        }
    }

    public VehicleAdapter(JSONArray jsonArray, Context context, Intent intent)
    {
        this.jsonArray = jsonArray;
        this.context = context;
        this.intent = intent;
    }

    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        @SuppressLint("InflateParams")
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_vehicle, null, false);
        return new VehicleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final VehicleViewHolder holder, int position)
    {
        try
        {
            final JSONObject vehicle = jsonArray.getJSONObject(position);

            if (vehicle.get("fuel").toString().compareTo("1") == 0)
            {
                holder.tvFuel.setText(context.getString(R.string.fuel1));
            }
            else
            {
                holder.tvFuel.setText(context.getString(R.string.fuel2));
            }
            if (vehicle.get("gearbox").toString().compareTo("1") == 0)
            {
                holder.tvGearbox.setText(context.getString(R.string.gearbox1));
            }
            else
            {
                holder.tvGearbox.setText(context.getString(R.string.gearbox2));
            }
            holder.tvPower.setText(context.getString(R.string.power, Integer.parseInt(vehicle.get("power").toString())));
            holder.tvConsumption.setText(context.getString(R.string.consumption, Float.parseFloat(vehicle.get("fuel_consumption").toString())));
            holder.tvTrunk.setText(context.getString(R.string.trunk, Integer.parseInt(vehicle.get("trunk").toString())));
            holder.tvDoors.setText(vehicle.get("doors").toString());
            holder.tvId.setText(vehicle.get("id_vehicle").toString());
            holder.tvCentre.setText(vehicle.get("id_centre").toString());
            holder.tvPrice.setText(context.getString(R.string.price, Float.parseFloat(vehicle.get("price").toString())));

            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference reference = storage.getReference().child("Vehicles/" + vehicle.get("id_vehicle") + ".png");
            reference.getBytes(1024 * 1024).addOnSuccessListener(new OnSuccessListener<byte[]>()
            {
                @Override
                public void onSuccess(byte[] bytes)
                {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    holder.ivcVehicle.setImageBitmap(bitmap);
                }
            });

            holder.bRent.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    try
                    {
                        Intent intent = new Intent(context, OptionsActivity.class);

                        intent.putExtra("start_date", Objects.requireNonNull(VehicleAdapter.this.intent.getExtras()).getString("start_date"));
                        intent.putExtra("end_date", VehicleAdapter.this.intent.getExtras().getString("end_date"));
                        intent.putExtra("vehicle_json", vehicle.toString());
                        context.startActivity(intent);
                    }
                    catch (NullPointerException e)
                    {
                        e.printStackTrace();
                    }
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