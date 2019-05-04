package com.example.freshfinaltoolbarwhatsapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import retrofit2.http.GET;

public class CustomTablayoutActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customtablayout);
        frameLayout = findViewById(R.id.framelayout);
        tabLayout = findViewById(R.id.tablayout);
        // Create a new Tab named "First"
        TabLayout.Tab firstTab = tabLayout.newTab();
        firstTab.setText("First"); // set the Text for the first Tab
        firstTab.setIcon(R.drawable.ic_nav_home); // set an icon for the
// first tab
        tabLayout.addTab(firstTab); // add  the tab at in the TabLayout
// Create a new Tab named "Second"
        TabLayout.Tab secondTab = tabLayout.newTab();
        secondTab.setText("Second"); // set the Text for the second Tab
        secondTab.setIcon(R.drawable.ic_nav_home); // set an icon for the second tab
        tabLayout.addTab(secondTab); // add  the tab  in the TabLayout
// Create a new Tab named "Third"
        TabLayout.Tab thirdTab = tabLayout.newTab();
        thirdTab.setText("Third"); // set the Text for the first Tab
        thirdTab.setIcon(R.drawable.ic_nav_home); // set an icon for the first tab
        tabLayout.addTab(thirdTab); // add  the tab at in the TabLayout

        tabLayout.getTabAt(0).select();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // get the current selected tab's position and replace the fragment accordingly
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new ChatsFragment();
                        changeFragment(fragment);
                        break;
                    case 1:
                        fragment = new CallsFragment();
                        changeFragment(fragment);
                        break;
                    case 2:
                        fragment = new StatusFragment();
                        changeFragment(fragment);
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void changeFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.framelayout, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

//    https://api.demo.com/Login?email=abc@gmail.com&password=Password@123
//    @GET("https://api.demo.com/Login")
//    Call<Data> getData(@Query("email") String email,@Query("password") String password);
}
