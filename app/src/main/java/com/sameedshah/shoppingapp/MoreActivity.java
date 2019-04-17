package com.sameedshah.shoppingapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import Adapters.KidsFashionAdaoter;
import Adapters.MoreCategoryAdapter;

public class MoreActivity extends AppCompatActivity {


    RecyclerView mRecycler;
    MoreCategoryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        int[] images = {R.drawable.men_fashion,R.drawable.womans_fashion,R.drawable.electronics
                ,R.drawable.kids_fashions,R.drawable.ic_computer_black_24dp,R.drawable.ic_beauty,
                R.drawable.ic_restaurant};
        String[] title ={"Men's Fashion","Women'sFashion","Electronics and Mobiles,","Babies and kids",
        "Computer and Laptops","Beauty and Health","Service and Food"};
        String[] price = {"600 Items","150 items ","500 items ","550 items ","300k items a","440items,","50k Items"};

        mRecycler = findViewById(R.id.allCategories);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MoreCategoryAdapter(this,images,title,price);
        mRecycler.setAdapter(adapter);

    }

}
