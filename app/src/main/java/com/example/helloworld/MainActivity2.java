package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;

import java.net.URI;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView rView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rView=findViewById(R.id.rv);
        ArrayList<Name> array=new ArrayList<>();
       // String url="http://goo.gl/gEgYUd\";
      array.add(new Name("Venkatesh","https://www.google.com/imgres?imgurl=https%3A%2F%2Fimage.shutterstock.com%2Fimage-photo%2Fbright-spring-view-cameo-island-260nw-1048185397.jpg&imgrefurl=https%3A%2F%2Fwww.shutterstock.com%2Fcategory%2Fnature&tbnid=PDxUM2uh-Nz6cM&vet=12ahUKEwix-ezN8qvqAhW0xHMBHYVlDzAQMygBegUIARDRAQ..i&docid=LlgDpz1LoiuznM&w=475&h=280&q=imges&ved=2ahUKEwix-ezN8qvqAhW0xHMBHYVlDzAQMygBegUIARDRAQ"));
        array.add(new Name("Hunter","http://goo.gl/gEgYUd"));
        array.add(new Name("Venky","http://goo.gl/gEgYUd"));
        RecAdapter adapter=new RecAdapter(array);
        rView.setAdapter(adapter);
        rView.setLayoutManager(new LinearLayoutManager(this));
    }
}