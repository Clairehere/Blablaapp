package fr.wildcodeschool.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ItinerarySearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        Button search=findViewById(R.id.buttonSearch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView editTextDep =findViewById(R.id.editTextDeparture);
                String editTextDepart=editTextDep.getText().toString();
                TextView editTextDestination=findViewById(R.id.editTextDestination);
                String editTextDes=editTextDestination.getText().toString();

                TextView editTextDate=findViewById(R.id.editTextDate);
                String date=editTextDate.getText().toString();


                if(editTextDepart.equals("")||editTextDes.equals("")){
                    Toast.makeText(ItinerarySearchActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }

                else {
                   
                   // Intent intentSearch = new Intent(ItinerarySearchActivity.this, ItineraryListActivity.class);

                   // editTextDepart = editTextDestination.getText().toString();
                   // intentSearch.putExtra("des", editTextDepart);

                   // editTextDes=editTextDep.getText().toString();
                   // intentSearch.putExtra("dep", editTextDes);

                    Intent intentSearch = new Intent(ItinerarySearchActivity.this, ItineraryListActivity.class);
                    SearchModel troisEnUn=new SearchModel(editTextDepart, editTextDes, date);
                    intentSearch.putExtra("troisen1", troisEnUn);

                    startActivity(intentSearch);

                }
            }
        });
    }


    }

