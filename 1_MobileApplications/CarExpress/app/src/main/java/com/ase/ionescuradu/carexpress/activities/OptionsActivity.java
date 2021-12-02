package com.ase.ionescuradu.carexpress.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.ase.ionescuradu.carexpress.R;
import com.ase.ionescuradu.carexpress.adapters.OptionAdapter;
import com.ase.ionescuradu.carexpress.utilities.DatabaseTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.Objects;

//  Created by Ionescu Radu Stefan  //

public class OptionsActivity extends Activity
{
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        //<editor-fold desc="Recycler View: Options">
        try
        {
            RecyclerView recyclerView = findViewById(R.id.rvOptions);
            layoutManager = new GridLayoutManager(this, 2);
            String response = new DatabaseTask(getApplicationContext(), getIntent()).execute("select_option").get();
            JSONArray array = new JSONArray(response);
            OptionAdapter optionAdapter = new OptionAdapter(array, getApplicationContext());

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(optionAdapter);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //</editor-fold>

        //<editor-fold desc="Button Listener: Add options">
        findViewById(R.id.bAddOptions).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final JSONArray jsonArray = new JSONArray();
                String address = null;
                int index = 0;
                boolean delivery = false;
                for (int i = 0; i < layoutManager.getItemCount(); i++)
                {
                    CheckBox cbSelect = layoutManager.findViewByPosition(i).findViewById(R.id.cbSelect);
                    final TextView tvoName = layoutManager.findViewByPosition(i).findViewById(R.id.tvoName);
                    final TextView tvoPrice = layoutManager.findViewByPosition(i).findViewById(R.id.tvoPrice);
                    final TextView tvoDescription = layoutManager.findViewByPosition(i).findViewById(R.id.tvoDescription);

                    if (cbSelect.isChecked())
                    {
                        if (tvoName.getText().toString().compareTo("Delivery") == 0)
                        {
                            delivery = true;
                            try
                            {
                                JSONArray addressArray = new JSONArray(new DatabaseTask(getApplicationContext(), getIntent()).execute("select_address").get());
                                address = addressArray.getJSONObject(0).getString("address");
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                            assert address != null;
                            if (address.compareTo("null") == 0)
                            {
                                final EditText etAddress = new EditText(getApplicationContext());
                                etAddress.setTextColor(Color.parseColor("#FFC4E6FF"));
                                ColorStateList colorStateList = ColorStateList.valueOf(Color.parseColor("#FFC4E6FF"));
                                etAddress.setBackgroundTintList(colorStateList);
                                try
                                {
                                    Field field = TextView.class.getDeclaredField("mCursorDrawableRes");
                                    field.setAccessible(true);
                                    int drawableResId = field.getInt(etAddress);
                                    field = TextView.class.getDeclaredField("mEditor");
                                    field.setAccessible(true);
                                    Object editor = field.get(etAddress);
                                    Drawable drawable = ContextCompat.getDrawable(etAddress.getContext(), drawableResId);
                                    assert drawable != null;
                                    drawable.setColorFilter(Color.parseColor("#FFC4E6FF"), PorterDuff.Mode.SRC_IN);
                                    Drawable[] drawables = {drawable, drawable};
                                    field = editor.getClass().getDeclaredField("mCursorDrawable");
                                    field.setAccessible(true);
                                    field.set(editor, drawables);
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }
                                etAddress.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                                AlertDialog.Builder builder = new AlertDialog.Builder(OptionsActivity.this);
                                builder.setTitle("Address");
                                builder.setMessage("You selected the Delivery option but didn't complete your address! Please complete your address.");
                                builder.setView(etAddress);
                                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i)
                                    {
                                        new DatabaseTask(getApplicationContext(), getIntent()).execute("insert_address", etAddress.getText().toString());
                                        Intent intent = new Intent(getApplicationContext(), ConfirmationActivity.class);
                                        intent.putExtra("start_date", Objects.requireNonNull(getIntent().getExtras()).getString("start_date"));
                                        intent.putExtra("end_date", getIntent().getExtras().getString("end_date"));
                                        intent.putExtra("vehicle_json", getIntent().getExtras().getString("vehicle_json"));
                                        intent.putExtra("option_json", jsonArray.toString());
                                        startActivity(intent);
                                    }
                                });
                                AlertDialog dialog = builder.create();
                                dialog.show();
                            }
                        }
                        try
                        {
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("name", tvoName.getText().toString());
                            jsonObject.put("price", tvoPrice.getText().toString().substring(0, tvoPrice.getText().toString().length() - 7));
                            jsonObject.put("description", tvoDescription.getText().toString());
                            jsonArray.put(index, jsonObject);
                            index++;
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
                if (!delivery || address.compareTo("null") != 0)
                {
                    Intent intent = new Intent(getApplicationContext(), ConfirmationActivity.class);
                    intent.putExtra("start_date", Objects.requireNonNull(getIntent().getExtras()).getString("start_date"));
                    intent.putExtra("end_date", getIntent().getExtras().getString("end_date"));
                    intent.putExtra("vehicle_json", getIntent().getExtras().getString("vehicle_json"));
                    intent.putExtra("option_json", jsonArray.toString());
                    startActivity(intent);
                }
            }
        });
        //</editor-fold>
    }
}