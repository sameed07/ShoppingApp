package com.sameedshah.shoppingapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import Adapters.LatestProductAdapter;
import de.hdodenhof.circleimageview.CircleImageView;

@SuppressLint("ValidFragment")
class HomeFragment extends Fragment {
    View v;
    RecyclerView mRecycler;
    LatestProductAdapter adapter;
    CircleImageView mensIcon,womanIcon,electronicsIcon,kidsIcon,moreIcon;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.home_fragment, container, false);
         mensIcon = v.findViewById(R.id.mensIcon);
         womanIcon = v.findViewById(R.id.womanIcon);
         electronicsIcon = v.findViewById(R.id.electIcon);
         kidsIcon = v.findViewById(R.id.kidIcon);
         moreIcon = v.findViewById(R.id.moreIcon);


        int[] images = {R.drawable.shoes,R.drawable.jeans,R.drawable.laptop_one,R.drawable.laptop_two,
                R.drawable.mobile_one,R.drawable.mobile_two};
        String[] title ={"Sneakers","Skinny Jeans","Hp laptop i7,","Asus probook","X-ziox","Huawei Nova 3" };
        String[] price = {"100","150","500","550","300","440"};

         mRecycler = v.findViewById(R.id.mRecyclerView);
        mRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        adapter = new LatestProductAdapter(getActivity(),images,title,price);
        mRecycler.setAdapter(adapter);

        onClickFun();
        return v;
    }

    void onClickFun(){
        mensIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),MenFashionActivity.class));
            }
        });
        womanIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), WomansFashionActivity.class));
            }
        });

        electronicsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),ElectronicsActivity.class));
            }
        });
        kidsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),KidsFashionActivity.class));
            }
        });

        moreIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  startActivity(new Intent(getActivity(),CategoryFragment.class));
                replaceFragment(new CategoryFragment());
            }
        });
    }

    private void replaceFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

}
