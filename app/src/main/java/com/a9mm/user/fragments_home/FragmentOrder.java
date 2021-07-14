package com.a9mm.user.fragments_home;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.a9mm.user.R;
import com.a9mm.user.adapters.BannerAdapter;
import com.a9mm.user.adapters.CatAdapter;
import com.a9mm.user.models.BannerModel;
import com.a9mm.user.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentOrder#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class FragmentOrder extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private View view;

    private RecyclerView catRecyclerView;
    private List<CategoryModel> categoryModelList;
    private CatAdapter catAdapter;

    private RecyclerView bannerRecyclerView;
    private List<BannerModel> bannerModelList;
    private BannerAdapter bannerAdapter;

    public static FragmentOrder newInstance(String param1, String param2) {
        FragmentOrder fragment = new FragmentOrder();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentOrder() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_order, container, false);

        init();
        return view;
    }

    private void init() {

        // category list display
        catRecyclerView = (RecyclerView) view.findViewById(R.id.catRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        catRecyclerView.setLayoutManager(layoutManager);

        categoryModelList = new ArrayList<>();
        categoryModelList.add(new CategoryModel(R.drawable.logo_app_grey,"Grocery & Staples"));
        categoryModelList.add(new CategoryModel(R.drawable.logo_app_grey,"Vegetables & Fruits"));
        categoryModelList.add(new CategoryModel(R.drawable.logo_app_grey,"Personal Care"));
        categoryModelList.add(new CategoryModel(R.drawable.logo_app_grey,"Household Items"));
        categoryModelList.add(new CategoryModel(R.drawable.logo_app_grey,"Home & Kitchen"));
        categoryModelList.add(new CategoryModel(R.drawable.logo_app_grey,"Biscuits * Chocolates"));
        categoryModelList.add(new CategoryModel(R.drawable.logo_app_grey,"Beverages"));
        categoryModelList.add(new CategoryModel(R.drawable.logo_app_grey,"Breakfast & Diary"));
        categoryModelList.add(new CategoryModel(R.drawable.logo_app_grey,"Best Values"));
        categoryModelList.add(new CategoryModel(R.drawable.logo_app_grey,"Noodles & Instant Foods"));
        categoryModelList.add(new CategoryModel(R.drawable.logo_app_grey,"Furnishing & Home Needs"));
        categoryModelList.add(new CategoryModel(R.drawable.logo_app_grey,"Baby Care"));
        categoryModelList.add(new CategoryModel(R.drawable.logo_app_grey,"Pet Care"));
        categoryModelList.add(new CategoryModel(R.drawable.logo_app_grey,"Fashion"));

        catAdapter = new CatAdapter(getActivity(), categoryModelList);
        catRecyclerView.setAdapter(catAdapter);
        catAdapter.notifyDataSetChanged();


        // banner list display
        bannerRecyclerView = (RecyclerView) view.findViewById(R.id.bannerRecyclerView);
        LinearLayoutManager layoutManagerBanner = new LinearLayoutManager(getActivity());
        layoutManagerBanner.setOrientation(RecyclerView.HORIZONTAL);
        bannerRecyclerView.setLayoutManager(layoutManagerBanner);

        bannerModelList = new ArrayList<>();
        bannerModelList.add(new BannerModel(R.drawable.logo_app_grey));
        bannerModelList.add(new BannerModel(R.drawable.logo_app_grey));
        bannerModelList.add(new BannerModel(R.drawable.logo_app_grey));
        bannerModelList.add(new BannerModel(R.drawable.logo_app_grey));
        bannerModelList.add(new BannerModel(R.drawable.logo_app_grey));
        bannerModelList.add(new BannerModel(R.drawable.logo_app_grey));
        bannerModelList.add(new BannerModel(R.drawable.logo_app_grey));
        bannerModelList.add(new BannerModel(R.drawable.logo_app_grey));
        bannerModelList.add(new BannerModel(R.drawable.logo_app_grey));
        bannerModelList.add(new BannerModel(R.drawable.logo_app_grey));
        bannerModelList.add(new BannerModel(R.drawable.logo_app_grey));

        bannerAdapter = new BannerAdapter(getActivity(),bannerModelList);
        bannerRecyclerView.setAdapter(bannerAdapter);
        bannerAdapter.notifyDataSetChanged();



    }
}