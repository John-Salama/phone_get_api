package com.ahmdalii.mvvmdemo.ui.home.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmdalii.mvvmdemo.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    Context context;
    List<String> images;

    public ImageAdapter(Context context, List<String> images){
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.info_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ViewHolder holder, int position) {
        String imageUrl = images.get(position);
        Glide.with(context)
                .load(imageUrl)
                .override(600, 600)
                .into(holder.productImage);
    }

    @Override
    public int getItemCount() {
         return images.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView productImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.phone_image);
        }
    }
}
