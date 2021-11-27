package android.example.reportcardsapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ReportCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.report_cards);
        ArrayList<ReportCard> reportCards = new ArrayList<ReportCard>();
        reportCards.add(new ReportCard("akshay",1002,85));
        reportCards.add(new ReportCard("akash",1002,70));
        reportCards.add(new ReportCard("sanjay",1002,80));
        reportCards.add(new ReportCard("sanchay",1002,82));
        reportCards.add(new ReportCard("siddharth",1002,90));
        reportCards.add(new ReportCard("akshaySharma",1002,85));
        reportCards.add(new ReportCard("akashVerma",1002,70));
        reportCards.add(new ReportCard("sanjayBhandari",1002,80));
        reportCards.add(new ReportCard("sanchaySingh",1002,82));
        reportCards.add(new ReportCard("siddharthSingh",1002,65));

            ReportCardAdapter adapter = new ReportCardAdapter(this,reportCards);
        ListView lv = (ListView)findViewById(R.id.reportCardsList);
        lv.setAdapter(adapter);
    }
    }

