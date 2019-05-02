package com.example.freshfinaltoolbarwhatsapp;

import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NavigationActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private List<String> listHeader;
    private HashMap<String, List<String>> listHashMap;
    private ExpandableAdapter expandableAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        listView = findViewById(R.id.listview);
        initData();
        expandableAdapter = new ExpandableAdapter(NavigationActivity.this, listHeader, listHashMap);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                50, r.getDisplayMetrics());
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            listView.setIndicatorBounds(width - px, width);
        } else {
            listView.setIndicatorBoundsRelative(width - px, width);
        }
        listView.setAdapter(expandableAdapter);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.setDrawerIndicatorEnabled(false);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        toggle.setHomeAsUpIndicator(R.drawable.ic_menu_camera);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void initData() {
        listHeader = new ArrayList<>();
        listHashMap = new HashMap<>();
        listHeader.add("EDMtDev");
        listHeader.add("Android");
        listHeader.add("IOS");
        listHeader.add("Symbian");

        List<String> edmtdev = new ArrayList<>();
        edmtdev.add("This is ExpandableListView");

        List<String> androistudio = new ArrayList<>();
        androistudio.add("android");
        androistudio.add("android");
        androistudio.add("android");
        androistudio.add("android");
        androistudio.add("android");

        List<String> mac = new ArrayList<>();
        mac.add("android");
        mac.add("android");
        mac.add("android");
        mac.add("android");
        mac.add("android");

        List<String> nokia = new ArrayList<>();
        nokia.add("android");
        nokia.add("android");
        nokia.add("android");
        nokia.add("android");
        nokia.add("android");
        listHashMap.put(listHeader.get(0), edmtdev);
        listHashMap.put(listHeader.get(1), androistudio);
        listHashMap.put(listHeader.get(2), mac);
        listHashMap.put(listHeader.get(3), nokia);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")

    private void changeFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.screen_container, fragment, "MyFragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
