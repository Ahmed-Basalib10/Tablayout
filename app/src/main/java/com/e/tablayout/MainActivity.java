package com.e.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout ;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout =(TabLayout) findViewById(R.id.tablayout);
        viewPager =(ViewPager) findViewById(R.id.view_pager);
        FragmentAdapter fragmentAdapter =new FragmentAdapter(getSupportFragmentManager());
        fragmentAdapter.addFragment(new Fragment1(),"Chat");
        fragmentAdapter.addFragment(new Fragment2(),"Setting");
        fragmentAdapter.addFragment(new Fragment3(),"Camera");
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0) {
                    setTitle("Chat");
                } else if (position == 1)
                {
                    setTitle("Seting");
                }
                else
                {
                    setTitle("Camera");
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}