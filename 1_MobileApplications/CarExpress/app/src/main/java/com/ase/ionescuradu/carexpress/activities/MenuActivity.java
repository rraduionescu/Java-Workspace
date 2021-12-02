package com.ase.ionescuradu.carexpress.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ase.ionescuradu.carexpress.R;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

//  Created by Ionescu Radu Stefan  //

public class MenuActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //<editor-fold desc="Button Listeners: Menu">
        findViewById(R.id.bRentCar).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), CategoryActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.bMyRentals).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), RentalsActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.bProfile).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.bAbout).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.bLogout).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(MenuActivity.this, getResources().getString(R.string.tLogout), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                startActivity(intent);
                firebaseAuth.signOut();
                LoginManager.getInstance().logOut();
                GoogleSignInOptions gOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getResources().getString(R.string.oauth)).requestEmail().build();
                GoogleSignIn.getClient(getApplicationContext(), gOptions).signOut();
            }
        });
        //</editor-fold>
    }
}