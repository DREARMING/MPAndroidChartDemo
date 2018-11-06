package com.mvcoder.mpandroidchartdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
    }


    class MyPageAdapter extends FragmentPagerAdapter {

        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            switch (i){
                case 0:
                    fragment = LineChartFragment.newInstance();
                    break;
                case 1:
                    fragment = BarChartFragment.newInstance();
                    break;
                case 2:
                    fragment = HorizontalBarChartFragment.newInstance();
                    break;
                case 3:
                    fragment = PieChartFragment.newInstance();
                    break;
            }
            return fragment;
        }
    }

    private void lineChart(){
        LineChart chart = new LineChart(this);
        IBarDataSet dataSet;
        PieEntry pieEntry;

    }
}
