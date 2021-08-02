package com.a9mm.user.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.a9mm.user.R;
import com.a9mm.user.models.SimpleVerticalModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class SimpleVerticalAdapter extends RecyclerView.Adapter<SimpleVerticalAdapter.SimpleVerticalViewHolder> {

    private Context context;
    private List<SimpleVerticalModel> simpleVerticalModelList;

    public SimpleVerticalAdapter(Context context, List<SimpleVerticalModel> simpleVerticalModelList) {
        this.context = context;
        this.simpleVerticalModelList = simpleVerticalModelList;
    }

    @NonNull
    @Override
    public SimpleVerticalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.simple_vertical_slider , viewGroup, false);
        return new SimpleVerticalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleVerticalViewHolder holder, int position) {
        SimpleVerticalModel simpleVerticalModel = simpleVerticalModelList.get(position);

        holder.shop_name.setText(simpleVerticalModel.getShop_name());
        holder.shop_owner_name.setText(simpleVerticalModel.getShop_owner_name());
        holder.shop_location.setText(simpleVerticalModel.getLandmark());
        holder.shop_discount.setText(simpleVerticalModel.getDiscount()+" - use code "+simpleVerticalModel.getCoupon());
        holder.shop_description.setText(simpleVerticalModel.getDescription()+"..");
        holder.shop_rating.setText(simpleVerticalModel.getRating());
        Glide.with(context).load(simpleVerticalModel.getShop_image()).placeholder(R.drawable.logo_app_grey).into(holder.proImg);
    }

    @Override
    public int getItemCount() {
        return simpleVerticalModelList.size();
    }

    public class SimpleVerticalViewHolder extends RecyclerView.ViewHolder {

        private ImageView proImg;
        private TextView shop_owner_name,shop_location, shop_name, shop_discount, shop_rating, shop_description;

        public SimpleVerticalViewHolder(@NonNull View itemView) {
            super(itemView);
            proImg = (ImageView) itemView.findViewById(R.id.proImg);
            shop_name = (TextView) itemView.findViewById(R.id.shop_name);
            shop_owner_name = (TextView) itemView.findViewById(R.id.shop_owner_name);
            shop_location = (TextView) itemView.findViewById(R.id.shop_location);
            shop_discount = (TextView) itemView.findViewById(R.id.shop_discount);
            shop_description = (TextView) itemView.findViewById(R.id.shop_description);
            shop_rating = (TextView) itemView.findViewById(R.id.shop_rating);
        }
    }
}
