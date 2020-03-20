package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Second extends AppCompatActivity {
TextView fm1,fm2,fm3,t1,t2,t3,t4;


    Context context;
    SharedPreferences sharedpreferences;
    private SeekBar simpleSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//fm1 = (TextView)findViewById(R.id.frm1);

        fm1 = (TextView)findViewById(R.id.frm1);
fm3 = (TextView)findViewById(R.id.frm13);
t1 = (TextView)findViewById(R.id.frm2);
        t2 = (TextView)findViewById(R.id.frm22);
        t4 = (TextView)findViewById(R.id.frm24);


        sharedpreferences = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
fm1.setText(sharedpreferences.getString("from",null));
        fm3.setText(sharedpreferences.getString("from",null));
        t1.setText(sharedpreferences.getString("to",null));
        t2.setText(sharedpreferences.getString("to",null));
        t4.setText(sharedpreferences.getString("to",null));


//        Toast.makeText(getApplicationContext(),sharedpreferences.getString("to",null),Toast.LENGTH_SHORT).show();


        View bottomSheet = findViewById(R.id.design_bottom_sheet);
        bottomSheet.setClipToOutline(true);

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

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        final RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.simpleRatingBar);
        Button submitButton = (Button) findViewById(R.id.submitButton);
        // perform click event on button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get values and then displayed in a toast
                String totalStars = "Total Stars:: " + simpleRatingBar.getNumStars();
                String rating = "Rating :: " + simpleRatingBar.getRating();
                Toast.makeText(getApplicationContext(), totalStars + "\n" + rating, Toast.LENGTH_LONG).show();
            }
        });


        // initiate  views
        simpleSeekBar=(SeekBar)findViewById(R.id.simpleSeekBar);
        // perform seek bar change listener event used for getting the progress value
        simpleRatingBar.incrementProgressBy(50);
        simpleRatingBar.setMax(150);
        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Second.this, "Seek bar progress is :" + progressChangedValue,
                        Toast.LENGTH_SHORT).show();
            }
        });



    }
}
