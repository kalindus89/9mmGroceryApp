package com.a9mm.user.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.a9mm.user.R;
import com.a9mm.user.models.BannerModel;
import com.a9mm.user.models.PlateModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {

    private Context context;
    private List<BannerModel> bannerModelList;

    public BannerAdapter(Context context, List<BannerModel> bannerModelList) {
        this.context = context;
        this.bannerModelList = bannerModelList;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_banner, viewGroup, false);
        return new BannerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        BannerModel plateModel = bannerModelList.get(position);
        Glide.with(context).load(plateModel.getBanner_img()).placeholder(R.drawable.logo_app_grey).into(holder.bannerImg);
    }

    @Override
    public int getItemCount() {
        return bannerModelList.size();
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {

        private ImageView bannerImg;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerImg = (ImageView) itemView.findViewById(R.id.bannerImg);
        }
    }
}
