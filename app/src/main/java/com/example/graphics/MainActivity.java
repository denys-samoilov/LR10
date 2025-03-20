package com.example.graphics;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        PieChart pieChart = findViewById(R.id.pieChart);
        pieChart.getDescription().setEnabled(false);

        ArrayList<PieEntry>  entries = new ArrayList<>();
        entries.add(new PieEntry(72f, "Android"));
        entries.add(new PieEntry(27f, "iOS"));
        entries.add(new PieEntry(1, "Інші"));

        PieDataSet dataSet = new PieDataSet(entries, "Статистика використання пристроїв");
        dataSet.setColors(Color.parseColor("#147800"), Color.parseColor("#060078"), Color.GRAY);

        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.invalidate();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}