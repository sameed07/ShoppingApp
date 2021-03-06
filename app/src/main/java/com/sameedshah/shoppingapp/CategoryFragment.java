package com.sameedshah.shoppingapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import Adapters.MoreCategoryAdapter;

@SuppressLint("ValidFragment")
class CategoryFragment extends Fragment {

    RecyclerView mRecycler;
    MoreCategoryAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.category_fragment, container, false);

        int[] images = {R.drawable.men_fashion,R.drawable.womans_fashion,R.drawable.electronics
                ,R.drawable.kids_fashions,R.drawable.ic_computer_black_24dp,R.drawable.ic_beauty,
                R.drawable.ic_restaurant};
        String[] title ={"Men's Fashion","Women'sFashion","Electronics and Mobiles,","Babies and kids",
                "Computer and Laptops","Beauty and Health","Service and Food"};
        String[] price = {"600 Items","150 items ","500 items ","550 items ","300k items a","440items,","50k Items"};

        mRecycler = v.findViewById(R.id.allCategories);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MoreCategoryAdapter(getActivity(),images,title,price);
        mRecycler.setAdapter(adapter);

        return v;
    }



}
