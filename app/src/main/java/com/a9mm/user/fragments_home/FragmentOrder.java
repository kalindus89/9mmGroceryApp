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
import com.a9mm.user.adapters.GreatOffersAdapter;
import com.a9mm.user.adapters.SimpleVerticalAdapter;
import com.a9mm.user.models.BannerModel;
import com.a9mm.user.models.CategoryModel;
import com.a9mm.user.models.GreatOffersModel;
import com.a9mm.user.models.SimpleVerticalModel;
import com.a9mm.user.retrofit_api.ApiClient;
import com.a9mm.user.retrofit_api.ApiInterface;
import com.a9mm.user.retrofit_api.Users;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    private RecyclerView simpleRecyclerView;
    private List<SimpleVerticalModel> simpleVerticalModelList;
    private SimpleVerticalAdapter simpleVerticalAdapter;

    private RecyclerView greatHorizontalRecyclerView;
    private List<GreatOffersModel> greatOffersModelList;
    private GreatOffersAdapter greatOffersAdapter;

    private RecyclerView simpleSecondVerticalRecyclerView;
    private RecyclerView newArriveHorizontalRecyclerView;
    private RecyclerView newArriveVerticalRecyclerView;

    public static ApiInterface apiInterface;

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
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        init();
        return view;
    }

    private void init() {

        // (1) category list display
        catRecyclerView = (RecyclerView) view.findViewById(R.id.catRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        catRecyclerView.setLayoutManager(layoutManager);

        categoryModelList = new ArrayList<>();

        Call<Users> categoryCall = apiInterface.getCategories() ;
        categoryCall.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {


                // database column names nand adaper ides must match: eg: both as to cat_title or cat_image
                categoryModelList = response.body().getCategory();
                catAdapter = new CatAdapter(getActivity(), categoryModelList);
                catRecyclerView.setAdapter(catAdapter);
                catAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
            }
        });

        // End of category list display
        // (2)  banner list display

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

        // End of banner list
        // (3) simple vertical model list

        simpleRecyclerView = (RecyclerView) view.findViewById(R.id.simpleRecyclerView);
        LinearLayoutManager layoutManageSimple = new LinearLayoutManager(getActivity());
        layoutManageSimple.setOrientation(RecyclerView.VERTICAL);
        simpleRecyclerView.setLayoutManager(layoutManageSimple);

        simpleVerticalModelList = new ArrayList<>();
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.logo_app_grey,"Lanka Dal 1","Yellow healthy food, eat everyday","20% OFF - use code ZOMATO","Rs.100 per Kg | 2 hours","Well sanitized kitchen * Rider hand wash","4.6"));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.logo_app_grey,"Lanka Dal 1","Yellow healthy food, eat everyday","20% OFF - use code ZOMATO","Rs.100 per Kg | 2 hours","Well sanitized kitchen * Rider hand wash","4.6"));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.logo_app_grey,"Lanka Dal 1","Yellow healthy food, eat everyday","20% OFF - use code ZOMATO","Rs.100 per Kg | 2 hours","Well sanitized kitchen * Rider hand wash","4.6"));

        simpleVerticalAdapter = new SimpleVerticalAdapter(getActivity(),simpleVerticalModelList);
        simpleRecyclerView.setAdapter(simpleVerticalAdapter);
        simpleVerticalAdapter.notifyDataSetChanged();

        // End of Simple Vertical List
        // (4) Great Offers List

        greatHorizontalRecyclerView = (RecyclerView) view.findViewById(R.id.greatHorizontalRecyclerView);
        LinearLayoutManager layoutManageGreatOffers = new LinearLayoutManager(getActivity());
        layoutManageGreatOffers.setOrientation(RecyclerView.HORIZONTAL);
        greatHorizontalRecyclerView.setLayoutManager(layoutManageGreatOffers);

        greatOffersModelList = new ArrayList<>();
        greatOffersModelList.add(new GreatOffersModel(R.drawable.logo_app_grey,"Vegetable Junction 1","39 mins","32% OFF","3.9"));
        greatOffersModelList.add(new GreatOffersModel(R.drawable.logo_app_grey,"Vegetable Junction 1","39 mins","32% OFF","3.9"));
        greatOffersModelList.add(new GreatOffersModel(R.drawable.logo_app_grey,"Vegetable Junction 1","39 mins","32% OFF","3.9"));
        greatOffersModelList.add(new GreatOffersModel(R.drawable.logo_app_grey,"Vegetable Junction 1","39 mins","32% OFF","3.9"));
        greatOffersModelList.add(new GreatOffersModel(R.drawable.logo_app_grey,"Vegetable Junction 1","39 mins","32% OFF","3.9"));
        greatOffersModelList.add(new GreatOffersModel(R.drawable.logo_app_grey,"Vegetable Junction 1","39 mins","32% OFF","3.9"));
        greatOffersModelList.add(new GreatOffersModel(R.drawable.logo_app_grey,"Vegetable Junction 1","39 mins","32% OFF","3.9"));
        greatOffersModelList.add(new GreatOffersModel(R.drawable.logo_app_grey,"Vegetable Junction 1","39 mins","32% OFF","3.9"));
        greatOffersModelList.add(new GreatOffersModel(R.drawable.logo_app_grey,"Vegetable Junction 1","39 mins","32% OFF","3.9"));

        greatOffersAdapter = new GreatOffersAdapter(getActivity(),greatOffersModelList);
        greatHorizontalRecyclerView.setAdapter(greatOffersAdapter);
        greatOffersAdapter.notifyDataSetChanged();

        // End of Offers List
        // (5) Second Simple Vertical List

        simpleSecondVerticalRecyclerView = (RecyclerView) view.findViewById(R.id.simpleSecondVerticalRecyclerView);
        LinearLayoutManager layoutManageSimpleSecond = new LinearLayoutManager(getActivity());
        layoutManageSimpleSecond.setOrientation(RecyclerView.VERTICAL);
        simpleSecondVerticalRecyclerView.setLayoutManager(layoutManageSimpleSecond);

        simpleVerticalModelList = new ArrayList<>();
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.logo_app_grey,"Lanka Dal 2","Yellow healthy food, eat everyday","20% OFF - use code ZOMATO","Rs.100 per Kg | 2 hours","Well sanitized kitchen * Rider hand wash","4.6"));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.logo_app_grey,"Lanka Dal 2","Yellow healthy food, eat everyday","20% OFF - use code ZOMATO","Rs.100 per Kg | 2 hours","Well sanitized kitchen * Rider hand wash","4.6"));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.logo_app_grey,"Lanka Dal 2","Yellow healthy food, eat everyday","20% OFF - use code ZOMATO","Rs.100 per Kg | 2 hours","Well sanitized kitchen * Rider hand wash","4.6"));

        simpleVerticalAdapter = new SimpleVerticalAdapter(getActivity(),simpleVerticalModelList);
        simpleSecondVerticalRecyclerView.setAdapter(simpleVerticalAdapter);
        simpleVerticalAdapter.notifyDataSetChanged();

        // End of Second Simple Vertical List
        // (6) newArriveHorizontalRecyclerView List

        newArriveHorizontalRecyclerView = (RecyclerView) view.findViewById(R.id.newArriveHorizontalRecyclerView);
        LinearLayoutManager layoutManageNewArriveHorizontal = new LinearLayoutManager(getActivity());
        layoutManageNewArriveHorizontal.setOrientation(RecyclerView.HORIZONTAL);
        newArriveHorizontalRecyclerView.setLayoutManager(layoutManageNewArriveHorizontal);

        greatOffersModelList = new ArrayList<>();
        greatOffersModelList.add(new GreatOffersModel(R.drawable.logo_app_grey,"Vegetable Junction 2","39 mins","32% OFF","3.9"));
        greatOffersModelList.add(new GreatOffersModel(R.drawable.logo_app_grey,"Vegetable Junction 2","39 mins","32% OFF","3.9"));
        greatOffersModelList.add(new GreatOffersModel(R.drawable.logo_app_grey,"Vegetable Junction 2","39 mins","32% OFF","3.9"));
        greatOffersModelList.add(new GreatOffersModel(R.drawable.logo_app_grey,"Vegetable Junction 2","39 mins","32% OFF","3.9"));
        greatOffersModelList.add(new GreatOffersModel(R.drawable.logo_app_grey,"Vegetable Junction 2","39 mins","32% OFF","3.9"));
        greatOffersModelList.add(new GreatOffersModel(R.drawable.logo_app_grey,"Vegetable Junction 2","39 mins","32% OFF","3.9"));
        greatOffersModelList.add(new GreatOffersModel(R.drawable.logo_app_grey,"Vegetable Junction 2","39 mins","32% OFF","3.9"));
        greatOffersModelList.add(new GreatOffersModel(R.drawable.logo_app_grey,"Vegetable Junction 2","39 mins","32% OFF","3.9"));

        greatOffersAdapter = new GreatOffersAdapter(getActivity(),greatOffersModelList);
        newArriveHorizontalRecyclerView.setAdapter(greatOffersAdapter);
        greatOffersAdapter.notifyDataSetChanged();

        // End of newArriveHorizontalRecyclerView
        // (7) newArriveVerticalRecyclerView List

        newArriveVerticalRecyclerView = (RecyclerView) view.findViewById(R.id.newArriveVerticalRecyclerView);
        LinearLayoutManager layoutManageNewArriveVertical = new LinearLayoutManager(getActivity());
        layoutManageNewArriveVertical.setOrientation(RecyclerView.VERTICAL);
        newArriveVerticalRecyclerView.setLayoutManager(layoutManageNewArriveVertical);

        simpleVerticalModelList = new ArrayList<>();
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.logo_app_grey,"Lanka Dal 3","Yellow healthy food, eat everyday","20% OFF - use code ZOMATO","Rs.100 per Kg | 2 hours","Well sanitized kitchen * Rider hand wash","4.6"));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.logo_app_grey,"Lanka Dal 3","Yellow healthy food, eat everyday","20% OFF - use code ZOMATO","Rs.100 per Kg | 2 hours","Well sanitized kitchen * Rider hand wash","4.6"));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.logo_app_grey,"Lanka Dal 3","Yellow healthy food, eat everyday","20% OFF - use code ZOMATO","Rs.100 per Kg | 2 hours","Well sanitized kitchen * Rider hand wash","4.6"));
        simpleVerticalModelList.add(new SimpleVerticalModel(R.drawable.logo_app_grey,"Lanka Dal 3","Yellow healthy food, eat everyday","20% OFF - use code ZOMATO","Rs.100 per Kg | 2 hours","Well sanitized kitchen * Rider hand wash","4.6"));

        simpleVerticalAdapter = new SimpleVerticalAdapter(getActivity(),simpleVerticalModelList);
        newArriveVerticalRecyclerView.setAdapter(simpleVerticalAdapter);
        simpleVerticalAdapter.notifyDataSetChanged();
    }
}