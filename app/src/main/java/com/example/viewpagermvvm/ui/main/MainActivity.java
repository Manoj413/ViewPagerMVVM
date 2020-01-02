package com.example.viewpagermvvm.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.viewpagermvvm.R;
import com.example.viewpagermvvm.base.BaseActivity;
import com.example.viewpagermvvm.ui.adapter.TabsPagerAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

   // @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
   // @BindView(R.id.view_pager)
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        appBarLayout = findViewById(R.id.appBarLayout);
        viewPager = findViewById(R.id.view_pager);

        TabsPagerAdapter tabsPagerAdapter = new TabsPagerAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(tabsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }
}
