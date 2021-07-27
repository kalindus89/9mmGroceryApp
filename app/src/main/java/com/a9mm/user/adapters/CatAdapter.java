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
import com.a9mm.user.models.CategoryModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CategoryViewHolder> {

    private Context context;
    private List<CategoryModel> categoryModelList;

    public CatAdapter(Context context, List<CategoryModel> categoryModelList) {
        this.context = context;
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_category , viewGroup, false);
        return new CategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryModel categoryModel = categoryModelList.get(position);

        holder.cat_title.setText(categoryModel.getCat_title());
        Glide.with(context).load(categoryModel .getCat_image() ).placeholder(R.drawable.logo_app_grey). into(holder.cat_image);
    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        private ImageView cat_image;
        private TextView cat_title;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            cat_image = (ImageView) itemView.findViewById(R.id.cat_image);
            cat_title = (TextView) itemView.findViewById(R.id.cat_title);
        }
    }
}
