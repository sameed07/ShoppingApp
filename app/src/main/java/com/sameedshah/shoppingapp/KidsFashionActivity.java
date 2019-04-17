package com.sameedshah.shoppingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import Adapters.KidsFashionAdaoter;
import Adapters.WomansFashionAdapter;

public class KidsFashionActivity extends AppCompatActivity {

    RecyclerView mRecycler;
    KidsFashionAdaoter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids_fashion);

        int[] images = {R.drawable.shoes,R.drawable.jeans,R.drawable.laptop_one,R.drawable.laptop_two,
                R.drawable.mobile_one,R.drawable.mobile_two};
        String[] title ={"Sneakers","Skinny Jeans","Hp laptop i7,","Asus probook","X-ziox","Huawei Nova 3" };
        String[] price = {"100","150","500","550","300","440"};

        mRecycler = findViewById(R.id.kidsRecycler);
        mRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new KidsFashionAdaoter(this,images,title,price);
        mRecycler.setAdapter(adapter);

        setToolbar();
    }
    private void setToolbar(){
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        getSupportActionBar().setTitle("Kid's Fashion");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch(itemId) {
            // Android home
            case android.R.id.home:
                // drawerLayout.openDrawer(GravityCompat.START);
                return true;
            // manage other entries if you have it ...
        }
        return true;
    }
}
