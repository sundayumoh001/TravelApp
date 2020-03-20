package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
TextView name,frm,to;
Context context;
SharedPreferences sharedpreferences;
    // Recycler View object
    RecyclerView recyclerView;
    DatePicker simpleDatePicker;
    ImageButton submit;
    // Array list for recycler view data source
    ArrayList<String> source;

    // Layout Manager
    RecyclerView.LayoutManager RecyclerViewLayoutManager;

    // adapter class object
    Adapter adapter;

    // Linear Layout Manager
    LinearLayoutManager HorizontalLayout;

    View ChildView;
    int RecyclerViewItemPosition;

Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        b =(Button)findViewById(R.id.btnfind);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),Second.class);

                startActivity(i);


            }
        });


        name=(TextView) findViewById(R.id.mname);
        frm=(TextView) findViewById(R.id.mFrm);
        to=(TextView) findViewById(R.id.mTo);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            name.setText("Hey,"+extras.getString("name"));
            frm.setText(extras.getString("from"));
            to.setText(extras.getString("to"));

        }
        // Recycler View object
       // initialisation with id's
        recyclerView
                = (RecyclerView)findViewById(
                R.id.recyclerview);
        RecyclerViewLayoutManager
                = new LinearLayoutManager(
                getApplicationContext());

        // Set LayoutManager on Recycler View
        recyclerView.setLayoutManager(
                RecyclerViewLayoutManager);

        // Adding items to RecyclerView.
        AddItemsToRecyclerViewArrayList();

        // calling constructor of adapter
        // with source list as a parameter
        adapter = new Adapter(source);

        // Set Horizontal Layout Manager
        // for Recycler view
        HorizontalLayout
                = new LinearLayoutManager(
                Home.this,
                LinearLayoutManager.HORIZONTAL,
                false);
        recyclerView.setLayoutManager(HorizontalLayout);
//recyclerView.setBackgroundResource(R.drawable.clckchngbtn);
        // Set adapter on recycler view
        recyclerView.setAdapter(adapter);
        sharedpreferences = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
//        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);



        View bottomSheet = findViewById(R.id.design_bottom_sheet);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
behavior.setPeekHeight(0);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_DRAGGING:
                        Log.i("BottomSheetCallback", "BottomSheetBehavior.STATE_DRAGGING");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        Log.i("BottomSheetCallback", "BottomSheetBehavior.STATE_SETTLING");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        Log.i("BottomSheetCallback", "BottomSheetBehavior.STATE_EXPANDED");
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        Log.i("BottomSheetCallback", "BottomSheetBehavior.STATE_COLLAPSED");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        Log.i("BottomSheetCallback", "BottomSheetBehavior.STATE_HIDDEN");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.i("BottomSheetCallback", "slideOffset: " + slideOffset);
            }
        });

        ImageButton button = (ImageButton) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        simpleDatePicker = (DatePicker) findViewById(R.id.simpleDatePicker);
        submit = (ImageButton) findViewById(R.id.dateButton);
        // perform click event on submit button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the values for day of month , month and year from a date picker
                String day = "Day = " + simpleDatePicker.getDayOfMonth();
                String month = "Month = " + (simpleDatePicker.getMonth() + 1);
                String year = "Year = " + simpleDatePicker.getYear();
                // display the values by using a toast
                Toast.makeText(getApplicationContext(), day + "\n" + month + "\n" + year, Toast.LENGTH_LONG).show();

            }
        });




    }


    public void AddItemsToRecyclerViewArrayList()
    {
        // Adding items to ArrayList
        source = new ArrayList<>();
        source.add("1 seat");
        source.add("2 seat");
        source.add("3 seat");
        source.add("4 seat");
        source.add("5 seat");
        source.add("6 seat");
        source.add("7 seat");
    }
}
