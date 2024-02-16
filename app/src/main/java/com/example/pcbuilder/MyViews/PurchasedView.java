package com.example.pcbuilder.MyViews;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pcbuilder.Models.Product;
import com.example.pcbuilder.R;

import java.util.ArrayList;
import java.util.List;

public class PurchasedView extends AppCompatActivity {
    private RecyclerView purchasedRecyclerView;
    private List<Product> purchasedList;
  //  private PurchasedListAdapter purchasedAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchased_view);

        purchasedRecyclerView = findViewById(R.id.purchasedRecyclerView);
        purchasedList = new ArrayList<>();
    }
}
