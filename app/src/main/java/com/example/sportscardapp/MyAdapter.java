package com.example.sportscardapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Sport> itemList;
    MyOnClickListener mListener;

    public MyAdapter(List<Sport> itemList, Context context) {
        this.itemList = itemList;
        this.mListener = (MyOnClickListener) context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.card_item_layout, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Sport sports = itemList.get(position);
        holder.sportName.setText(sports.getSportName());
        holder.sportImage.setImageResource(sports.getSportImage());
        holder.bind(mListener, position);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView sportImage;
        TextView sportName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sportImage = itemView.findViewById(R.id.imageView);
            sportName = itemView.findViewById(R.id.textView);

        }
        void bind(final MyOnClickListener listener, final int pos){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onCLick(v, pos);
                }
            });
        }

    }

}
