package com.example.charts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Highlight;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
  private BarChart chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         chart = findViewById(R.id.barchart);

        ArrayList noOfAlerts = new ArrayList();

        noOfAlerts.add(new BarEntry(48, 0));
        noOfAlerts.add(new BarEntry(10, 1));
        noOfAlerts.add(new BarEntry(25, 2));
        noOfAlerts.add(new BarEntry(50, 3));
        noOfAlerts.add(new BarEntry(35, 4));
        noOfAlerts.add(new BarEntry(64, 5));
        noOfAlerts.add(new BarEntry(3, 6));

        final ArrayList<String> weekdayXAxis = new ArrayList();

        weekdayXAxis.add("Mon");
        weekdayXAxis.add("Tue");
        weekdayXAxis.add("Wed");
        weekdayXAxis.add("Thu");
        weekdayXAxis.add("Fri");
        weekdayXAxis.add("Sat");
        weekdayXAxis.add("Sun");

       // ArrayList<IBarDataSet>iBarDataSets=new ArrayList<>();
        BarDataSet bardataset = new BarDataSet(noOfAlerts, "No Of People Entry & Exit");
        chart.animateY(5000);
       // iBarDataSets.add(bardataset);
        BarData data=new BarData(weekdayXAxis,bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getXAxis().setDrawGridLines(false);
//        XAxis xAxis = chart.getXAxis();
//       // xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
//       // xAxis.setValueFormatter(new IndexAxisValueFormatter(weekday));
//       // xAxis.setGranularity(1f); // minimum axis-step (interval) is 1
//        xAxis.setValueFormatter(new ValueFormatter() {
//            @Override
//            public String getFormattedValue(float value, AxisBase axis) {
//                return weekday.get((int)value);
//            }
//        });
        chart.setData(data);
        chart.invalidate();
        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                float x=e.getVal();
                String  value=weekdayXAxis.get(e.getXIndex());
                Log.i("sush",String.valueOf(x));
                Toast.makeText(getApplicationContext(),"No of People on day"+ " " + value + " " +
                        "is" + " " + String.valueOf(x),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected() {

            }
        });
    }

}
