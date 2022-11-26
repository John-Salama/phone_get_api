package com.ahmdalii.mvvmdemo.ui.home.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmdalii.mvvmdemo.R;
import com.ahmdalii.mvvmdemo.model.Products;
import com.bumptech.glide.Glide;

import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder> {
    static Context context;
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
        holder.ratingBar.setRating(product.getRating());
        if (product.getDiscountPercentage() != 0) {
            holder.phonePriceText.setPaintFlags(holder.phonePriceText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.discount.setText("-" + Float.toString(product.getDiscountPercentage())+ "%");
            holder.priceAfterDiscount.setText("EGP "+ Float.toString((float) (product.getPrice() - product.getDiscountPercentage() * product.getPrice() / 100)));
        } else
        {
            holder.discount.setVisibility(View.INVISIBLE);
            holder.priceAfterDiscount.setVisibility(View.INVISIBLE);
        }
        holder.CurrentPosition = holder.getAdapterPosition();
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
        RatingBar ratingBar;
        TextView discount;
        TextView priceAfterDiscount;
        public int CurrentPosition;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            phoneNameText = itemView.findViewById(R.id.name_phone);
            phonePriceText = itemView.findViewById(R.id.phone_price);
            PhoneDescriptionText = itemView.findViewById(R.id.description_phone);
            phoneImage = itemView.findViewById(R.id.phone_image);
            ratingBar = itemView.findViewById(R.id.rating_bar);
            discount = itemView.findViewById(R.id.phone_discount);
            priceAfterDiscount = itemView.findViewById(R.id.phone_price_disc);
            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(context, InfoPage.class);
                intent.putExtra("position", CurrentPosition);
                context.startActivity(intent);
            });
        }
    }
}
