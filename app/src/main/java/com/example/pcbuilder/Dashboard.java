package com.example.pcbuilder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.pcbuilder.MyViews.homeScreen;

public class Dashboard extends AppCompatActivity {

    CardView customList,contactsCard;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        customList=findViewById(R.id.clothingCard);
        contactsCard=findViewById(R.id.bigCard);

        customList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this, homeScreen.class);
                startActivity(intent);
            }
        });

        contactsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}

