package fr.wildcodeschool.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class VehicleActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        final EditText brand=findViewById(R.id.editText_Brand);
        final EditText  model=findViewById(R.id.editText_Model);
        final EditText kilometre=findViewById(R.id.editText_Kilometers);
        final EditText hours=findViewById(R.id.editText_Hours);
        final EditText speed=findViewById(R.id.editText_speed);
        final Button sentVehicule=findViewById(R.id.buttonSentVehicule);


        //chercher spinner
        final Spinner spinner=findViewById(R.id.spinnerlist);
        //creer array utiliser un adapter pour rentrer les donner du spinner arrays
        final ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.listArray, android.R.layout.simple_spinner_item);
        //specifier le layout a utiliser lors affichage donné
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //appliquer ladapter au spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //vider les champs pour que quand on change itemps la liste se vide
                brand.setText("");
                model.setText("");
                switch(position){

                    case 0:
                        kilometre.setVisibility(View.GONE);
                        hours.setVisibility(View.GONE);
                        speed.setVisibility(View.GONE);

                        break;
                    case 1:
                        kilometre.setVisibility(View.VISIBLE);
                        hours.setVisibility(View.GONE);
                        speed.setVisibility(View.GONE);
                        sentVehicule.setEnabled(true);



                        sentVehicule.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String brand2=brand.getText().toString();
                                String model2=model.getText().toString();
                                String textkilo=kilometre.getText().toString();
                               // ligne avant string textkilo int kilo2=Integer.parseInt(kilometre.getText().toString());
                                int kilo2=0;
                                if(!textkilo.isEmpty()){


                                    kilo2=Integer.parseInt(hours.getText().toString());

                                }


                                final VehicleCar toast1=new VehicleCar(brand2, model2, kilo2);
                                    Toast.makeText(VehicleActivity.this, toast1.getDescription(), Toast.LENGTH_SHORT).show();


                            }
                        });

                        break;
                    case 2:
                        kilometre.setVisibility(View.GONE);
                        hours.setVisibility(View.VISIBLE);
                        speed.setVisibility(View.GONE);
                        sentVehicule.setEnabled(true);


                        sentVehicule.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String brand2=brand.getText().toString();
                                String model2=model.getText().toString();
                                String texthour=hours.getText().toString();
                                //pour ne pas que lappli crache car il n'y a pas de int linitier a 0 si jamais il n'y a pas de valeur
                                // la ligne avant int texthour=Integer.parseInt(kilometre.getText().toString());
                                int hours2=0;
                                if(!texthour.isEmpty()){


                                    hours2=Integer.parseInt(hours.getText().toString());

                                }


                                final VehicleBoat toast2=new VehicleBoat(brand2, model2, hours2);
                                Toast.makeText(VehicleActivity.this,toast2.getDescription(), Toast.LENGTH_SHORT).show();


                            }
                        });
                        break;
                    case 3:
                        speed.setVisibility(View.VISIBLE);
                        kilometre.setVisibility(View.GONE);
                        hours.setVisibility(View.GONE);
                        sentVehicule.setEnabled(true);

                        sentVehicule.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String brand2=brand.getText().toString();
                                String model2=model.getText().toString();
                                String textspeed=speed.getText().toString();
                                //int speed2=Integer.parseInt(speed.getText().toString());
                                int speed2=0;
                                if(!textspeed.isEmpty()){


                                    speed2=Integer.parseInt(hours.getText().toString());

                                }

                                final VehiclePlane toast3=new VehiclePlane(brand2, model2, speed2);
                                Toast.makeText(VehicleActivity.this,toast3.getDescription(), Toast.LENGTH_SHORT).show();

                            }
                        });
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }




}



