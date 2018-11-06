package com.mvcoder.mpandroidchartdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;
import java.util.List;


public class HorizontalBarChartFragment extends Fragment implements OnChartGestureListener {

    private HorizontalBarChart barChart;

    public HorizontalBarChartFragment() {

    }


    public static HorizontalBarChartFragment newInstance() {
        HorizontalBarChartFragment fragment = new HorizontalBarChartFragment();
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
        View view = inflater.inflate(R.layout.fragment_hor_bar_chart, container, false);
        barChart = view.findViewById(R.id.bar_chart);
        initChart();
        return view;
    }

    private String[] COMPANYS = new String[]{
            "C-A",
            "C-B",
            "C-C",
            "C-D",
            "C-E",
            "C-F",
            "C-G",
            "C-H"
    };

    private void initChart() {
        int range = 20000;
        List<BarEntry> barEntries = new ArrayList<>(8);
        for(int i = 0 ; i < 8; i++){
            BarEntry barEntry = new BarEntry(i, (float) (Math.random() * range) + range / 4);
            barEntries.add(barEntry);
        }

        BarDataSet dataSet = new BarDataSet(barEntries, "bar chart");
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);

        BarData barData = new BarData(dataSet);

        barChart.getDescription().setEnabled(false);
        //barChart.setOnChartGestureListener(this);

        barChart.getAxisRight().setEnabled(false);
        //barChart.getXAxis().setEnabled(false);

        XAxis xAxis =  barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        barChart.getXAxis().setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                int index = (int) value;
                if(index >= COMPANYS.length) index = index % COMPANYS.length;
                return COMPANYS[index];
            }
        });

        barChart.getAxisLeft().setAxisMinimum(0f);
        barChart.getAxisLeft().setDrawGridLines(false);
        //barChart.getAxisLeft().setAxisMaximum(0f);

        barChart.setDrawGridBackground(false);
        barChart.setDrawBarShadow(false);

        MarkerView markerView = new MyMarkView(getContext(), R.layout.custom_markview);
        markerView.setChartView(barChart);

        barChart.setMarker(markerView);
        barChart.animateY(2000);

        barChart.setData(barData);
    }

    class MyMarkView extends MarkerView{

        private TextView tvContent;
        /**
         * Constructor. Sets up the MarkerView with a custom layout resource.
         *
         * @param context
         * @param layoutResource the layout resource to use for the MarkerView
         */
        public MyMarkView(Context context, int layoutResource) {
            super(context, layoutResource);
            tvContent = findViewById(R.id.tv_content);
        }

        @Override
        public void refreshContent(Entry e, Highlight highlight) {
            tvContent.setText("" + (int)e.getY());
            super.refreshContent(e, highlight);
        }

        @Override
        public MPPointF getOffset() {
            return new MPPointF(-(getWidth() / 2), -getHeight() - 10);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        LogUtils.e("onChartGestureStart");
    }

    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        LogUtils.e("onChartGestureEnd");
    }

    @Override
    public void onChartLongPressed(MotionEvent me) {
        LogUtils.e("onChartLongPressed");
    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {
        LogUtils.e("onChartDoubleTapped");
    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {
        LogUtils.e("onChartSingleTapped");
    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {
        LogUtils.e("onChartFling");
    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
        LogUtils.e("onChartScale");
    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {
        LogUtils.e("onChartTranslate");
    }
}
