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

    public SimpleVerticalAdapter(Context context, List<SimpleVerticalModel> categoryModelList) {
        this.context = context;
        this.simpleVerticalModelList = categoryModelList;
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

        holder.simple_title.setText(simpleVerticalModel.getSimple_title());
        holder.simple_description.setText(simpleVerticalModel.getSimple_description());
        holder.simple_coupon.setText(simpleVerticalModel.getSimple_coupon());
        holder.simple_quantity.setText(simpleVerticalModel.getSimple_quantity());
        holder.simple_status.setText(simpleVerticalModel.getSimple_status());
        holder.simple_rating.setText(simpleVerticalModel.getSimple_rating());
        Glide.with(context).load(simpleVerticalModel.getPro_img()). into(holder.proImg);
    }

    @Override
    public int getItemCount() {
        return simpleVerticalModelList.size();
    }

    public class SimpleVerticalViewHolder extends RecyclerView.ViewHolder {

        private ImageView proImg;
        private TextView simple_title,simple_description, simple_coupon, simple_quantity, simple_status, simple_rating;

        public SimpleVerticalViewHolder(@NonNull View itemView) {
            super(itemView);
            proImg = (ImageView) itemView.findViewById(R.id.proImg);
            simple_title = (TextView) itemView.findViewById(R.id.simple_description);
            simple_description = (TextView) itemView.findViewById(R.id.simple_quantity);
            simple_coupon = (TextView) itemView.findViewById(R.id.simple_coupon);
            simple_quantity = (TextView) itemView.findViewById(R.id.simple_status);
            simple_status = (TextView) itemView.findViewById(R.id.simple_rating);
            simple_rating = (TextView) itemView.findViewById(R.id.simple_rating);
        }
    }
}
