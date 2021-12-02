package com.ase.ionescuradu.carexpress.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CalendarView;

import com.ase.ionescuradu.carexpress.R;

import java.text.SimpleDateFormat;
import java.util.Date;

//  Created by Ionescu Radu Stefan  //

public class CategoryActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        //<editor-fold desc="Dates: Default start/end">
        final Intent intent = new Intent(getApplicationContext(), RentActivity.class);

        final CalendarView cvStart = findViewById(R.id.cvStart);
        final CalendarView cvEnd = findViewById(R.id.cvEnd);

        Date minDateS = new Date();
        Date minDateE = new Date();
        minDateS.setDate(minDateS.getDate() + 1);
        minDateE.setDate(minDateE.getDate() + 2);

        cvStart.setMinDate(minDateS.getTime());
        cvEnd.setMinDate(minDateE.getTime());
        cvStart.setDate(minDateS.getTime());
        cvEnd.setDate(minDateE.getTime());

        @SuppressLint("SimpleDateFormat") final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        intent.putExtra("start_date", dateFormat.format(minDateS));
        intent.putExtra("end_date", dateFormat.format(minDateE));
        //</editor-fold>

        //<editor-fold desc="Calendar Views: Listeners">
        cvStart.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2)
            {
                Date selectedStart = new Date();
                selectedStart.setYear(i);
                selectedStart.setMonth(i1 + 1);
                selectedStart.setDate(i2);

                intent.putExtra("start_date", dateFormat.format(selectedStart));
                selectedStart.setDate(i2 + 1);
                intent.putExtra("end_date", dateFormat.format(selectedStart));

                selectedStart.setYear(i - 1900);
                selectedStart.setMonth(i1);
                cvEnd.setDate(selectedStart.getTime());
            }
        });

        cvEnd.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2)
            {
                Date selectedEnd = new Date();
                selectedEnd.setYear(i);
                selectedEnd.setMonth(i1 + 1);
                selectedEnd.setDate(i2);

                intent.putExtra("end_date", dateFormat.format(selectedEnd));
            }
        });
        //</editor-fold>

        //<editor-fold desc="Button Listeners: Categories">
        findViewById(R.id.bMicro).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent.putExtra("category", "micro");
                startActivity(intent);
            }
        });

        findViewById(R.id.bCompact).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent.putExtra("category", "compact");
                startActivity(intent);
            }
        });

        findViewById(R.id.bSedan).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent.putExtra("category", "sedan");
                startActivity(intent);
            }
        });

        findViewById(R.id.bWagon).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent.putExtra("category", "wagon");
                startActivity(intent);
            }
        });

        findViewById(R.id.bSuv).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent.putExtra("category", "suv");
                startActivity(intent);
            }
        });

        findViewById(R.id.bBus).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent.putExtra("category", "bus");
                startActivity(intent);
            }
        });

        findViewById(R.id.bAll).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent.putExtra("category", "*");
                startActivity(intent);
            }
        });
        //</editor-fold>
    }
}