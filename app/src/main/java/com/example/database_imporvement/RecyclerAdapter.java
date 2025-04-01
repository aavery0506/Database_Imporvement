package com.example.database_imporvement;

import android.content.Context;
import android.util.Log;
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

    private ArrayList<String> productList;


    public RecyclerAdapter(){
        super();
        this.productList = new ArrayList<>();

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

        holder.description.setText(this.productList.get(position));

    }

    @Override
    public int getItemCount() {
        return this.productList.size();
    }

    public void updateAdapter(ArrayList<Product> product){
        this.productList.clear();
        for(Product temp: product){
            productList.add(temp.toString());
        }
        Log.d("test",product.toString());
        notifyDataSetChanged();
    }
}
//dynamically add and remove from recycler view
//link database array list to adapter via method?