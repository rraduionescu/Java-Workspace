package com.ase.ionescuradu.carexpress.activities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.ase.ionescuradu.carexpress.R;
import com.ase.ionescuradu.carexpress.utilities.DatabaseTask;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.json.JSONArray;
import org.json.JSONObject;

//  Created by Ionescu Radu Stefan  //

public class ProfileActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //<editor-fold desc="Text Views: set up">
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser != null)
        {
            JSONArray jsonArray;
            JSONObject jsonObject;
            try
            {
                jsonArray = new JSONArray(new DatabaseTask(getApplicationContext(), getIntent()).execute("select_address").get());
                jsonObject = jsonArray.getJSONObject(0);
                ((EditText) findViewById(R.id.etName)).setText(firebaseUser.getDisplayName());
                ((EditText) findViewById(R.id.etEmail)).setText(firebaseUser.getEmail());
                ((EditText) findViewById(R.id.etAddress)).setText(jsonObject.get("address").toString());
                if (jsonObject.get("address").toString().compareTo("null") == 0)
                {
                    ((EditText) findViewById(R.id.etAddress)).setText(R.string.etpAddress);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        //</editor-fold>

        //<editor-fold desc="Image View: Profile picture">
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference reference = null;
        if (firebaseUser != null)
        {
            reference = storage.getReference().child("ProfilePictures/" + firebaseUser.getUid());
        }
        if (reference != null)
        {
            reference.getBytes(1024 * 1024).addOnSuccessListener(new OnSuccessListener<byte[]>()
            {
                @Override
                public void onSuccess(byte[] bytes)
                {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                    ((ImageView) findViewById(R.id.ivProfile)).setImageBitmap(bitmap);
                }
            });
        }
        //</editor-fold>
    }
}