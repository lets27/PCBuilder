package com.example.pcbuilder.MyViews.RecyclerViewContent;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.brandnewsuitecase.Models.Product;
import com.example.brandnewsuitecase.MyViews.EditActivity;
import com.example.brandnewsuitecase.MyViews.ItemDetails;
import com.example.brandnewsuitecase.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    Context context;
    List<Product> productList;


    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ProductViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.itemlistview, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Glide.with(context).load(productList.get(position).getImage()).into(holder.viewImage);
        holder.nameView.setText(productList.get(position).getItemName());
        holder.priceView.setText(productList.get(position).getPrice());

        holder.myCrdItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemDetails.class);
                intent.putExtra("image", productList.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("description", productList.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("itemName", productList.get(holder.getAdapterPosition()).getItemName());
                intent.putExtra("price", productList.get(holder.getAdapterPosition()).getPrice());
                intent.putExtra("key", productList.get(holder.getAdapterPosition()).getKey());

                context.startActivity(intent);

            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtra("image", productList.get(holder.getAdapterPosition()).getImage());
                intent.putExtra("description", productList.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("itemName", productList.get(holder.getAdapterPosition()).getItemName());
                intent.putExtra("price", productList.get(holder.getAdapterPosition()).getPrice());
                intent.putExtra("key", productList.get(holder.getAdapterPosition()).getKey());

                context.startActivity(intent);
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                handleDeleteAction(holder.getAdapterPosition());
            }
        });


    }



    private void handleDeleteAction(int position) {
        Product productToDelete = productList.get(position);

        // Delete the item from Firebase and update the RecyclerView
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Shopping Items");
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference = storage.getReferenceFromUrl(productToDelete.getImage());

        storageReference.delete().addOnSuccessListener(unused -> {
            reference.child(productToDelete.getKey()).removeValue();
            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
            // Remove the item from the list and notify the adapter
            productList.remove(position);
            notifyItemRemoved(position);
        }).addOnFailureListener(e -> {
            // Handle failure (e.g., show an error toast)
            Toast.makeText(context, "Deletion failed", Toast.LENGTH_SHORT).show();
        });
    }






    @Override
    public int getItemCount() {
        return productList.size();
    }


}
