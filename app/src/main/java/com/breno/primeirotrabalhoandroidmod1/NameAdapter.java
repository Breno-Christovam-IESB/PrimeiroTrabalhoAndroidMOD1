package com.breno.primeirotrabalhoandroidmod1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {

    private List<String> names;

    public NameAdapter(List<String> names) {
        this.names = names;
    }


    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);
       return new NameViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder nameViewHolder, int position) {
        String name = names.get(position);
        nameViewHolder.tv_name.setText(name);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    class NameViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;

        NameViewHolder(View view) {
            super(view);
            tv_name = view.findViewById(R.id.tv_name);
        }
    }
}
