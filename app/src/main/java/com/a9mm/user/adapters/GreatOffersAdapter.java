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
import com.a9mm.user.models.GreatOffersModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class GreatOffersAdapter extends RecyclerView.Adapter<GreatOffersAdapter.GreatOffersViewHolder> {

    private Context context;
    private List<GreatOffersModel> greatOffersModelList;

    public GreatOffersAdapter(Context context, List<GreatOffersModel> greatOffersModelList) {
        this.context = context;
        this.greatOffersModelList = greatOffersModelList;
    }

    @NonNull
    @Override
    public GreatOffersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_horizontal_great_offers , viewGroup, false);
        return new GreatOffersViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GreatOffersViewHolder holder, int position) {
        GreatOffersModel greatOffersModel = greatOffersModelList.get(position);

        holder.offers_shop_name.setText(greatOffersModel.getShop_name());
        holder.shop_landmark.setText(greatOffersModel.getLandmark());
        holder.offers_discount.setText(greatOffersModel.getDiscount());
        holder.offers_rating.setText(greatOffersModel.getRating());
        Glide.with(context).load(greatOffersModel.getShop_image()).placeholder(R.drawable.logo_app_grey).into(holder.offers_shop_img);
    }

    @Override
    public int getItemCount() {
        return greatOffersModelList.size();
      //  return 8;
    }

    public class GreatOffersViewHolder extends RecyclerView.ViewHolder {

        private ImageView offers_shop_img;
        private  TextView offers_shop_name, shop_landmark, offers_discount, offers_rating;

        public GreatOffersViewHolder(@NonNull View itemView) {
            super(itemView);
            offers_shop_img = (ImageView) itemView.findViewById(R.id.offers_shop_img);
            offers_shop_name = (TextView) itemView.findViewById(R.id.offers_shop_name);
            shop_landmark = (TextView) itemView.findViewById(R.id.shop_landmark);
            offers_discount = (TextView) itemView.findViewById(R.id.offers_discount);
            offers_rating = (TextView) itemView.findViewById(R.id.offers_rating);
        }
    }
}
