package com.example.database_imporvement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    final private ArrayList<String> details;


    public RecyclerAdapter(){
        super();
        details = new ArrayList<>();

        details.add("Card 1");

        details.add("Card 2");

        details.add("Card 3");

        details.add("Card 4");

        details.add("Card 5");

        details.add("Card 6");

        details.add("Card 7");

    }
    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.textViewCard);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.description.setText(details.get(position));

    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public void addCard(Product product){
        details.add(product.toString());
    }
}
//dynamically add and remove from recycler view
//link database array list to adapter via method?