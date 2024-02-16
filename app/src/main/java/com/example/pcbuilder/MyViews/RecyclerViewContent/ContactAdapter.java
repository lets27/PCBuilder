package com.example.pcbuilder.MyViews.RecyclerViewContent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.brandnewsuitecase.Models.Contacts;
import com.example.brandnewsuitecase.R;

import java.util.List;

// Import statements for necessary classes and libraries


public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    // Context to be used in the adapter
    private Context context;

    // List to store contact items
    private List<Contacts> items;


    public ContactAdapter(Context context, List<Contacts> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item view layout and create a new ViewHolder
        return new ContactViewHolder(LayoutInflater.from(context).inflate(R.layout.itemview, parent, false));
    }

    // Replacing the contents of a view
    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {


        holder.nameView.setText(items.get(position).getName());


        holder.emailView.setText(items.get(position).getEmail());

        // Set the image resource for the contact
        holder.imageView.setImageResource(items.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        // Return the total number of items in the dataset
        return items.size();
    }
}




