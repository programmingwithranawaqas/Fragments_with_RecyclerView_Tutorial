package com.example.fragmentswithrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    ArrayList<Person> people;
    ContactSelected myActivity;
    public PersonAdapter(Context context, ArrayList<Person> list)
    {
        people = list;
        myActivity = (ContactSelected) context;
    }

    public interface ContactSelected
    {
        public void onContactClick(int index);
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvName;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myActivity.onContactClick(people.indexOf((Person)itemView.getTag()));
                }
            });
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(people.get(position).getName());
        holder.itemView.setTag(people.get(position));
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
