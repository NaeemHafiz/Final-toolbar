package com.example.freshfinaltoolbarwhatsapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomTabActivity extends AppCompatActivity {

    private CustomTabFragmentAdapter customTabFragmentAdapter;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private View customTabView;
    TextView tvTabTitle;
    private ImageView tabimageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        toolbar = findViewById(R.id.toolbr);
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.viewpager1);
        tabLayout = findViewById(R.id.tablayout2);
        customTabFragmentAdapter = new CustomTabFragmentAdapter(getSupportFragmentManager());

        initFragment(customTabFragmentAdapter);

//        viewPager.setOffscreenPageLimit(2);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(customTabFragmentAdapter);


        customTabView = LayoutInflater.from(this).inflate(R.layout.nav_tab, null);
        tvTabTitle = customTabView.findViewById(R.id.label);
        tabimageView = customTabView.findViewById(R.id.icon);
        tabLayout.getTabAt(0).setCustomView(customTabView);
        tvTabTitle.setText("STATUS");
        tabimageView.setImageResource(R.drawable.ic_nav_home);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tab.setCustomView(customTabView);
                        tvTabTitle.setText("STATUS");
                        tabimageView.setImageResource(R.drawable.ic_nav_home);
                        break;
                    case 1:
                        tab.setCustomView(customTabView);
                        tvTabTitle.setText("CALLS");
                        tabimageView.setImageResource(R.drawable.ic_nav_search);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tab.setCustomView(null);
                        tab.setText("STATUS");
                        tab.setIcon(R.drawable.ic_nav_home);
                        break;
                    case 1:
                        tab.setCustomView(null);
                        tab.setText("CALLS");
                        tab.setIcon(R.drawable.ic_nav_search);
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void initFragment(CustomTabFragmentAdapter adapterForHomeTabLayout) {
        adapterForHomeTabLayout.addFragment(new StatusFragment(), "STATUS");
        adapterForHomeTabLayout.addFragment(new CallsFragment(), "CALLS");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
