package com.example.paisadivide;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    List<Data> ls;
    Context c;
    ManageTimeAdapterListen listener;

    public MainAdapter(List<Data> ls, Context c) {
        this.c = c;
        this.ls = ls;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MainAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemrow = LayoutInflater.from(c).inflate(R.layout.activity_main_row, parent, false);
        return new MyViewHolder(itemrow);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MyViewHolder holder, final int position) {

        final Data currentItem = ls.get(position);

        holder.name.setText(currentItem.getName());
        holder.img.setImageDrawable(c.getDrawable(currentItem.getImage()));
        holder.amount.setText(currentItem.getAmount());
        holder.row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, position + "", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(c,SettleActivity.class);

                i.putExtra("Name", currentItem.getName());
                i.putExtra("Amount", currentItem.getAmount());

                c.startActivity(i);
            }
        });


//        holder.edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listener.onItemEditClick(currentItem);
//            }
//        });
//
//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listener.onItemDeleteClick(currentItem);
//            }
//        });
    }

    public void setContactList( List<Data> contactList){
        // ls.clear();
        ls = contactList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, amount;
        ImageView img;
        RelativeLayout row;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.img);
            amount = itemView.findViewById(R.id.amount);
            row = itemView.findViewById(R.id.row);
//            delete = itemView.findViewById(R.id.delete);
//            edit = itemView.findViewById(R.id.edit);
        }
    }

    public interface  ManageTimeAdapterListen{
        void onItemDeleteClick(Data deletItem);
        void onItemEditClick(Data editItem);
    }
}

