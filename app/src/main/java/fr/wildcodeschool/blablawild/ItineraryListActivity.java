package fr.wildcodeschool.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);


        String destination = getIntent().getStringExtra("des");
        String dep;
        switch (dep = getIntent().getStringExtra("dep")) {
        }
        this.setTitle(dep+" >> "+destination);



    }
}
