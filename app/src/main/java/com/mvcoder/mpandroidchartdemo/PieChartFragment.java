package com.mvcoder.mpandroidchartdemo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;


public class PieChartFragment extends Fragment {

    private PieChart pieChart;

    public PieChartFragment() {
    }


    public static PieChartFragment newInstance() {
        PieChartFragment fragment = new PieChartFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pie_chart, container, false);
        pieChart = view.findViewById(R.id.pie_chart);
        initChart();
        return view;
    }

    private void initChart() {
        pieChart.getDescription().setEnabled(false);
        //pieChart.setCenterText(generateCenterText());
        //pieChart.setCenterTextSize(12);

        // radius of the center hole in percent of maximum radius
        pieChart.setHoleRadius(0f);
        pieChart.setTransparentCircleRadius(0f);

        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);

        pieChart.setRotationEnabled(false);
        pieChart.setDrawEntryLabels(false);
        pieChart.setData(generatePieData());

    }

    private CharSequence generateCenterText() {
        return "电子与通信工程";
    }

    private PieData generatePieData() {
        int count = 4;
        ArrayList<PieEntry> entries1 = new ArrayList<PieEntry>();



        PieEntry notStartLessionInTermEntry = new PieEntry(380, "学期未开课数：380");
        PieEntry hadStartLessionInTermEntry = new PieEntry(44, "学期已开课数：44");
        PieEntry startLessionInTodayEntry = new PieEntry(8, "学期未开课数：8");

        entries1.add(notStartLessionInTermEntry);
        entries1.add(hadStartLessionInTermEntry);
        entries1.add(startLessionInTodayEntry);

       /* for(int i = 0; i < count; i++) {
            entries1.add(new PieEntry((float) ((int)(Math.random() * 60) + 40), "Quarter " + (i+1)));
        }*/

        PieDataSet ds1 = new PieDataSet(entries1, "电子与通信工程系");
        ds1.setColors(ColorTemplate.VORDIPLOM_COLORS);
        //ds1.setSliceSpace(2f);
        ds1.setValueTextColor(Color.BLACK);
        ds1.setValueTextSize(12f);
        ds1.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        ds1.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        ds1.setSelectionShift(15f);
        //外线长度
        ds1.setValueLinePart1Length(1.2f);

        int sum = 0;
        for(PieEntry entry : entries1){
            sum += entry.getValue();
        }

        final int finalSum = sum;
        ds1.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                float percent = (float) Math.round(value * 10000 / finalSum) / 100;
                return percent + "%";
            }
        });

        PieData d = new PieData();
        d.addDataSet(ds1);
        return d;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
