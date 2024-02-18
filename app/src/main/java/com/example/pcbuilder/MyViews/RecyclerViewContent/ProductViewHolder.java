package com.example.pcbuilder.MyViews.RecyclerViewContent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pcbuilder.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    ImageView viewImage;
    TextView nameView, priceView;
    CardView myCrdItem;
    ImageView delete,edit,sendBtn;
    private View itemView;

    public ProductViewHolder(@NonNull View itemView) {

        super(itemView);
        this.itemView = itemView;

        viewImage =  itemView.findViewById(R.id.viewImage);
        nameView =  itemView.findViewById(R.id.nameView);
        priceView = itemView.findViewById(R.id.priceView);
        myCrdItem=itemView.findViewById(R.id.myCardview);
        delete=itemView.findViewById(R.id.deleteBtn);
        edit=itemView.findViewById(R.id.editBtn);
        sendBtn=itemView.findViewById(R.id.send);

    }
}
