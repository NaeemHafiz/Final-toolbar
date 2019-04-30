package com.example.freshfinaltoolbarwhatsapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class CustomTabFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<String> mTitleStrings = new ArrayList<>();

    public CustomTabFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mTitleStrings.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mTitleStrings.add(title);
    }
}
