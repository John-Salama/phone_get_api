package com.ahmdalii.mvvmdemo.ui.home.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmdalii.mvvmdemo.R;
import com.ahmdalii.mvvmdemo.model.Products;
import com.bumptech.glide.Glide;

import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder> {
    Context context;
    List<Products> phones;

    public PhoneAdapter(Context context,List<Products> phones){
        this.context = context;
        this.phones = phones;
    }

    @NonNull
    @Override
    public PhoneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.phone_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneAdapter.ViewHolder holder, int position) {
        Products product = phones.get(position);
        holder.phoneNameText.setText(product.getTitle());
        holder.phonePriceText.setText(""+product.getPrice());
        Glide.with(context)
                .load(product.getProductImage())
                .override(600, 600)
                .into(holder.phoneImage);
        holder.PhoneDescriptionText.setText(product.getDescription());
        holder.PhoneRateText.setText(""+product.getRating());
    }

    @Override
    public int getItemCount() {
         return phones.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView phoneNameText;
        TextView phonePriceText;
        ImageView phoneImage;
        TextView PhoneDescriptionText;
        TextView PhoneRateText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            phoneNameText = itemView.findViewById(R.id.name_phone);
            phonePriceText = itemView.findViewById(R.id.phone_price);
            PhoneDescriptionText = itemView.findViewById(R.id.description_phone);
            phoneImage = itemView.findViewById(R.id.phone_image);
            PhoneRateText = itemView.findViewById(R.id.rate_phone);
        }
    }
}
