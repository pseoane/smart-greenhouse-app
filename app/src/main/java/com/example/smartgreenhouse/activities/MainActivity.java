package com.example.smartgreenhouse.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.smartgreenhouse.R;
import com.example.smartgreenhouse.view.PagerController;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    TabItem tabItemSen,tabItemAct,tabItemSta;
    PagerController pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabItemSen = findViewById(R.id.tabItemSen);
        tabItemAct = findViewById(R.id.tabItemAct);
        tabItemSta = findViewById(R.id.tabItemSta);

        pagerAdapter = new PagerController(this);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                int position = tab.getPosition();
                switch (position){
                    case 0:
                        pagerAdapter.notifyDataSetChanged();
                    case 1:
                        pagerAdapter.notifyDataSetChanged();
                    case 2:
                        pagerAdapter.notifyDataSetChanged();

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

}