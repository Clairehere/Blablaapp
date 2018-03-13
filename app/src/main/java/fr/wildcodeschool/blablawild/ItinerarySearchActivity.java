package fr.wildcodeschool.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

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

        final Calendar myCalendar = Calendar.getInstance();

        final EditText edittext= (EditText) findViewById(R.id.editTextDate);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                            //rajouter les noms
                updateLabel(edittext, myCalendar);
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ItinerarySearchActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


    }
                                //rajouter les parametres et les noms de la nouvelle methode
    private void updateLabel(EditText edittext, Calendar myCalendar) {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        edittext.setText(sdf.format(myCalendar.getTime()));
    }


}

