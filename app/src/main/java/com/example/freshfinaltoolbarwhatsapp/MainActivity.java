package com.example.freshfinaltoolbarwhatsapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tableLayout;
    private TabsAdapter tabsAdapter;
    private FloatingActionButton floatingActionButton;
    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.fab_btn);
        v = findViewById(R.id.main_layout);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v, "Snackbar Example", Snackbar.LENGTH_LONG);
                snackbar.setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.show();
            }
        });


        toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.navigation);
        toolbar.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.common_google_signin_btn_icon_dark_focused));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hi", Toast.LENGTH_SHORT).show();
            }
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("WhatsApp");
        }

        viewPager = findViewById(R.id.viewpager);
        tabsAdapter = new TabsAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabsAdapter);

        tableLayout = findViewById(R.id.tablayoutnew);
        tableLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;
    }

}
