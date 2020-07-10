package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static android.R.color.white;
import static com.example.helloworld.R.color.punisher;

public class MainActivity extends AppCompatActivity {
    private TextView t;
    private Button cBtn;
    private FloatingActionButton fab;
    private ListView lv;
    private Spinner spinner;

    ArrayList<String> name = new ArrayList<>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.opt) {
           Intent intent=new Intent(this,MainActivity2.class);
           startActivity(intent);
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    protected void init() {

        fab = findViewById(R.id.fab);
        lv = findViewById(R.id.lv);
        t = findViewById(R.id.hellotxt);
        cBtn = findViewById(R.id.btn);
        spinner = findViewById(R.id.spinner);
        clickable();
        listViewCreate();
        spinnerResponse();
    }

    protected void listViewCreate() {

        name.add("Venkatesh");
        name.add("Haunter");
        name.add("Punisher");
        name.add(getResources().getString(R.string.app_name));
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name);
        lv.setAdapter(adapt);
        listResponse();
    }

    protected void listResponse() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for (int j = 0; j < name.size(); j++)
                    lv.getChildAt(j).setBackgroundColor(getResources().getColor(R.color.white));
                t.setVisibility(View.VISIBLE);
                t.setText(name.get(i) + " Selected");
                lv.getChildAt(i).setBackgroundColor(getResources().getColor(R.color.haunter));
            }
        });
    }

    protected void spinnerResponse() {

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                for(int j=0;j<adapterView.getCount();j++)
//                    spinner.getChildAt(j).setBackgroundColor(getResources().getColor(R.color.white));
                t.setVisibility(View.VISIBLE);
                t.setText(spinner.getItemAtPosition(i).toString());
                spinner.setBackgroundColor(getResources().getColor(punisher));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    protected void clickable() {
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cBtn.setVisibility(View.VISIBLE);
                t.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Hell With Yo!! You Clicked Text", Toast.LENGTH_SHORT).show();

            }
        });
        cBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText("Hello Yo !!");
                t.setVisibility(View.VISIBLE);
                cBtn.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(), "Hell With Yo!! You Clicked Button", Toast.LENGTH_SHORT).show();

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText("Hey Yo!!, You Clicked Smily :-)");
                t.setVisibility(View.VISIBLE);
                cBtn.setVisibility(View.VISIBLE);
            }
        });

    }


}