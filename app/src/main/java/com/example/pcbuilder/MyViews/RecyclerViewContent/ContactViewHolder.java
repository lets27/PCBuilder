package com.example.pcbuilder.MyViews.RecyclerViewContent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brandnewsuitecase.R;

public class ContactViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView nameView,emailView;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageview);
        nameView = itemView.findViewById(R.id.name);
        emailView = itemView.findViewById(R.id.email);

    }
}
