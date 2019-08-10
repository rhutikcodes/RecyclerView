package com.aldindo.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aldindo.recyclerviewnew.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ExampleViewHolder> {

    private ArrayList<ExampleItem> exampleItemsList;
    public CustomAdapter(ArrayList<ExampleItem> exampleItems) {
        exampleItemsList=exampleItems;

    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);
        }
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
     ExampleViewHolder exampleViewHolder=new ExampleViewHolder(view);
     return exampleViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem currentItem=exampleItemsList.get(position);
        holder.imageView.setImageResource(currentItem.getmImageResource());
        holder.textView.setText(currentItem.getmText());

    }

    @Override
    public int getItemCount() {
        return exampleItemsList.size() ;
    }


}
