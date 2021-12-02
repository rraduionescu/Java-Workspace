package com.ase.ionescuradu.carexpress.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ase.ionescuradu.carexpress.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.json.JSONArray;
import org.json.JSONObject;

//  Created by Ionescu Radu Stefan //

public class RentalOptionAdapter extends RecyclerView.Adapter<RentalOptionAdapter.RentalOptionViewHolder>
{
    private final JSONArray jsonArray;
    private final Context context;

    static class RentalOptionViewHolder extends RecyclerView.ViewHolder
    {
        final TextView tvroName;
        final ImageView ivroOption;

        RentalOptionViewHolder(View itemView)
        {
            super(itemView);

            tvroName = itemView.findViewById(R.id.tvroName);
            ivroOption = itemView.findViewById(R.id.ivroOption);
        }
    }

    RentalOptionAdapter(JSONArray jsonArray, Context context)
    {
        this.jsonArray = jsonArray;
        this.context = context;
    }

    @NonNull
    @Override
    public RentalOptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        @SuppressLint("InflateParams")
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_rental_option, null, false);
        return new RentalOptionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final RentalOptionViewHolder holder, int position)
    {
        try
        {
            final JSONObject o = jsonArray.getJSONObject(position);
            context.getResources();

            holder.tvroName.setText(o.get("name").toString());

            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference reference = storage.getReference().child("Options/" + o.get("name") + ".jpg");
            reference.getBytes(1024 * 1024).addOnSuccessListener(new OnSuccessListener<byte[]>()
            {
                @Override
                public void onSuccess(byte[] bytes)
                {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    holder.ivroOption.setImageBitmap(bitmap);
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