package com.ase.ionescuradu.carexpress.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ase.ionescuradu.carexpress.R;

//  Created by Ionescu Radu Stefan  //

public class AboutActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //<editor-fold desc="Text Views: Symbols & Colors">
        ((TextView) findViewById(R.id.tvrDoors2)).setText(R.string.doordesc);
        ((TextView) findViewById(R.id.tvrTrunk2)).setText(R.string.trunkdesc);
        ((TextView) findViewById(R.id.tvrCentre2)).setText(R.string.centredesc);
        ((TextView) findViewById(R.id.tvrConsumption2)).setText(R.string.consdesc);
        ((TextView) findViewById(R.id.tvrGearbox2)).setText(R.string.geardesc);
        ((TextView) findViewById(R.id.tvrId2)).setText(R.string.iddesc);
        ((TextView) findViewById(R.id.tvrFuel2)).setText(R.string.fueldesc);
        ((TextView) findViewById(R.id.tvrPower2)).setText(R.string.powdesc);

        ((TextView) findViewById(R.id.tvrPrep)).setText(R.string.prepdesc);
        ((TextView) findViewById(R.id.tvrReady)).setText(R.string.readydesc);
        ((TextView) findViewById(R.id.tvrActive)).setText(R.string.activedesc);
        ((TextView) findViewById(R.id.tvrTerm)).setText(R.string.termdesc);
        //</editor-fold>

        //<editor-fold desc="Button Listeners: Rental centres">
        Button bAviatiei = findViewById(R.id.bAviatiei);
        bAviatiei.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri gmmIntentUri = Uri.parse("geo:44.479482,26.097270?q=" + Uri.encode("soseaua pipera, 17, bucharest"));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                startActivity(mapIntent);
            }
        });

        Button bCotroceni = findViewById(R.id.bCotroceni);
        bCotroceni.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri gmmIntentUri = Uri.parse("geo:44.426131,26.018940?q=" + Uri.encode("bulevardul timisoara, 284, bucharest"));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                startActivity(mapIntent);
            }
        });

        Button bDristor = findViewById(R.id.bDristor);
        bDristor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri gmmIntentUri = Uri.parse("geo:44.418840,26.137071?q=" + Uri.encode("aleea scolarilor, 5, bucharest"));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                startActivity(mapIntent);
            }
        });

        Button bMosilor = findViewById(R.id.bMosilor);
        bMosilor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri gmmIntentUri = Uri.parse("geo:44.436995,26.112907?q=" + Uri.encode("calea mosilor, 152, bucharest"));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                startActivity(mapIntent);
            }
        });

        Button bRomana = findViewById(R.id.bRomana);
        bRomana.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri gmmIntentUri = Uri.parse("geo:44.448590,26.099266?q=" + Uri.encode("calea dorobanti, 33, bucharest"));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                startActivity(mapIntent);
            }
        });

        Button bTineretului = findViewById(R.id.bTineretului);
        bTineretului.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri gmmIntentUri = Uri.parse("geo:44.412798,26.114449?q=" + Uri.encode("calea vacaresti, 189, bucharest"));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                startActivity(mapIntent);
            }
        });

        Button bUnirii = findViewById(R.id.bUnirii);
        bUnirii.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Uri gmmIntentUri = Uri.parse("geo:44.431457,26.101705?q=" + Uri.encode("strada gabroveni, 8, bucharest"));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                startActivity(mapIntent);
            }
        });
        //</editor-fold>
    }

    //<editor-fold desc="Landscape">
    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            Button bUnirii = findViewById(R.id.bUnirii);
            android.widget.LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(500,80);
            bUnirii.setLayoutParams(lp);
        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            Button bUnirii = findViewById(R.id.bUnirii);
            android.widget.LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(384,80);
            bUnirii.setLayoutParams(lp);
        }
    }
    //</editor-fold>
}