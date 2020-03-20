package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
Context context;
SharedPreferences sharedpreferences;
    Button b;
    EditText editnm;
    EditText editfr;
    EditText editTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         editnm = (EditText) findViewById(R.id.nm);
        editfr = (EditText) findViewById(R.id.fr);
        editTo = (EditText) findViewById(R.id.to);
        b =(Button)findViewById(R.id.sub);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nm = editnm.getText().toString();
                String fr = editfr.getText().toString();
                String to = editTo.getText().toString();

                Intent i = new Intent(getApplicationContext(),Home.class);
                i.putExtra("name",nm);
                i.putExtra("from",fr);
                i.putExtra("to",to);
                startActivity(i);

                sharedpreferences = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("name", editnm.getText().toString());
                editor.putString("from", editfr.getText().toString());
                editor.putString("to", editTo.getText().toString());

                editor.commit();
//                Toast.makeText(getApplicationContext(),sharedpreferences.getString("name",null),Toast.LENGTH_SHORT).show();




            }
        });
     //   sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);


    }

//    // Function to add items in RecyclerView.
//    public void AddItemsToRecyclerViewArrayList()
//    {
//        // Adding items to ArrayList
//        source = new ArrayList<>();
//        source.add("gfg");
//        source.add("is");
//        source.add("best");
//        source.add("site");
//        source.add("for");
//        source.add("interview");
//        source.add("preparation");
//    }

    public void onButtonClick(View view){


        EditText editnm = (EditText) findViewById(R.id.nm);
        EditText editfr = (EditText) findViewById(R.id.fr);
        EditText editTo = (EditText) findViewById(R.id.to);

        String nm = editnm.getText().toString();
        String fr = editfr.getText().toString();
        String to = editTo.getText().toString();

        Intent i = new Intent(this,Home.class);
        i.putExtra("name",nm);
        i.putExtra("from",fr);
        i.putExtra("to",to);
    startActivity(i);
    }
}
