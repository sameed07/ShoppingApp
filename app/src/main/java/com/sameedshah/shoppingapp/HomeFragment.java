package com.sameedshah.shoppingapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import Adapters.LatestProductAdapter;

@SuppressLint("ValidFragment")
class HomeFragment extends Fragment {
    View v;
    RecyclerView mRecycler;
    LatestProductAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.home_fragment, container, false);

        int[] images = {R.drawable.shoes,R.drawable.jeans,R.drawable.laptop_one,R.drawable.laptop_two,
                R.drawable.mobile_one,R.drawable.mobile_two};
        String[] title ={"Sneakers","Skinny Jeans","Hp laptop i7,","Asus probook","X-ziox","Huawei Nova 3" };
        String[] price = {"100","150","500","550","300","440"};

         mRecycler = v.findViewById(R.id.mRecyclerView);
        mRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        adapter = new LatestProductAdapter(getActivity(),images,title,price);
        mRecycler.setAdapter(adapter);

        return v;
    }
}
