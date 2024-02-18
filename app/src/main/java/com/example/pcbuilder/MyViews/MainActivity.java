package com.example.pcbuilder.MyViews;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pcbuilder.Models.Contacts;
import com.example.pcbuilder.MyViews.RecyclerViewContent.ContactAdapter;
import com.example.pcbuilder.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recylcerview);



        @SuppressLint({"MissingInflatedId", "LocalSuppress"})

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        List<Contacts> items = new ArrayList<Contacts>();
        items.add(new Contacts("John wick","john.wick@email.com",R.drawable.backicon));
        items.add(new Contacts("Robert j","robert.j@email.com",R.drawable.backicon));
        items.add(new Contacts("James Gunn","james.gunn@email.com",R.drawable.backicon));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ContactAdapter(getApplicationContext(),items));

    }


}