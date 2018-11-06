package com.mvcoder.mpandroidchartdemo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


public class LineChartFragment extends Fragment {

    private LineChart lineChart;

    public LineChartFragment() {
    }


    public static LineChartFragment newInstance() {
        LineChartFragment fragment = new LineChartFragment();
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
        View view = inflater.inflate(R.layout.fragment_line_chart, container, false);
        lineChart = view.findViewById(R.id.line_chart);
        initChart();
        return view;
    }

    private void initChart() {
        LineData lineData = new LineData();

        List<Entry> lineEntries1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Entry entry = new Entry(i + 1, i + 1);
            lineEntries1.add(entry);
        }
        LineDataSet dataSet = new LineDataSet(lineEntries1, "line chart");
        dataSet.setValueTextColor(Color.RED);
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        dataSet.setCircleColor(Color.BLACK);
        dataSet.setCircleColorHole(Color.GREEN);
        lineData.addDataSet(dataSet);

        List<Entry> lineEntries2 = new ArrayList<>();
        for (int k = 0; k < 5; k++) {
            Entry entry = new Entry(k + 1 , k + 2);
            lineEntries2.add(entry);
        }
        LineDataSet dataSet2 = new LineDataSet(lineEntries2, "line chart 2");
        dataSet2.setColor(Color.RED);
        dataSet2.setValueTextColor(Color.BLACK);
        lineData.addDataSet(dataSet2);

        lineChart.setDrawGridBackground(false);
        lineChart.getDescription().setEnabled(false);

        lineChart.getAxisRight().setEnabled(false);

        YAxis yAxis = lineChart.getAxisLeft();
        yAxis.setAxisMinimum(-6f);
        yAxis.setAxisMaximum(6f);

        Legend legend = lineChart.getLegend();
        //legend.setOrientation(Legend.LegendOrientation.VERTICAL);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);


        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.getXAxis().setAxisMaximum(6f);
        lineChart.getXAxis().setAxisMinimum(-6f);
        lineChart.getXAxis().setTextColor(Color.BLUE);

        lineChart.setData(lineData);
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
