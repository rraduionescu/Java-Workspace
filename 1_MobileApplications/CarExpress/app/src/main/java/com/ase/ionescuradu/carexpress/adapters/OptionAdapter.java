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
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.ase.ionescuradu.carexpress.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.json.JSONArray;
import org.json.JSONObject;

//  Created by Ionescu Radu Stefan  //

public class OptionAdapter extends RecyclerView.Adapter<OptionAdapter.OptionViewHolder>
{
    private final JSONArray jsonArray;
    private final Context context;

    static class OptionViewHolder extends RecyclerView.ViewHolder
    {
        final TextView tvoName;
        final TextView tvoPrice;
        final TextView tvoDescription;
        final CheckBox cbSelect;
        final ImageView ivOption;

        OptionViewHolder(View itemView)
        {
            super(itemView);

            tvoName = itemView.findViewById(R.id.tvoName);
            tvoPrice = itemView.findViewById(R.id.tvoPrice);
            tvoDescription = itemView.findViewById(R.id.tvoDescription);
            cbSelect = itemView.findViewById(R.id.cbSelect);
            ivOption = itemView.findViewById(R.id.ivOption);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    cbSelect.performClick();
                }
            });
        }
    }

    public OptionAdapter(JSONArray jsonArray, Context context)
    {
        this.jsonArray = jsonArray;
        this.context = context;
    }

    @NonNull
    @Override
    public OptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        @SuppressLint("InflateParams")
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_option, null, false);
        return new OptionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final OptionViewHolder holder, int position)
    {
        try
        {
            final JSONObject o = jsonArray.getJSONObject(position);

            holder.tvoName.setText(o.get("name").toString());
            holder.tvoPrice.setText(context.getResources().getString(R.string.price, Float.parseFloat(o.get("price").toString())));
            holder.tvoDescription.setText(o.get("description").toString());

            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference reference = storage.getReference().child("Options/" + o.get("name") + ".jpg");
            reference.getBytes(1024 * 1024).addOnSuccessListener(new OnSuccessListener<byte[]>()
            {
                @Override
                public void onSuccess(byte[] bytes)
                {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    holder.ivOption.setImageBitmap(bitmap);
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