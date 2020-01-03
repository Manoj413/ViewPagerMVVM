package com.example.viewpagermvvm.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.viewpagermvvm.R;
import com.example.viewpagermvvm.base.BaseActivity;
import com.example.viewpagermvvm.ui.adapter.TabsPagerAdapter;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;


    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_main);


     //   inject();
        ButterKnife.bind(MainActivity.this);

        FragmentManager fragmentManager= getSupportFragmentManager();
        TabsPagerAdapter tabsPagerAdapter = new TabsPagerAdapter(fragmentManager,1,getApplicationContext());

        viewPager.setAdapter(tabsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

   /* private void inject() {
        DaggerAppComponent.builder()
                .applicationBind(getApplication())
                .build().inject(this);
    }*/
}
