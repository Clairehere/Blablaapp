package fr.wildcodeschool.blablawild;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import fr.wildcodeschool.blablawild.R;

import java.util.ArrayList;
import java.util.Date;
/**
 * Created by wilder on 05/03/18.
 */

public class TripAdapter extends ArrayAdapter<TripModel> {
    public TripAdapter(Context context, ArrayList<TripModel> trips) {
        super(context, 0, trips);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            TripModel trip = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);
            }
            // Lookup view for data population


            TextView textViewName = (TextView) convertView.findViewById(R.id.textViewName);
            TextView textViewLastname=(TextView) convertView.findViewById(R.id.textViewLastname);
            TextView price=(TextView) convertView.findViewById(R.id.textViewPrice);
            TextView textViewDate= convertView.findViewById(R.id.textViewDate);
            // Populate the data into the template view using the data object



            textViewLastname.setText(trip.getLastname());
            textViewName.setText(trip.getFirstname());

             String priceFormat=String.valueOf(trip.getPrice());
             String price2="$ "+priceFormat;
             price.setText(price2);


            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy hh:mm");
            String date=sdf.format(trip.getDate());
            String dateformat =date+" PM";
            textViewDate.setText(dateformat);
            // Return the completed view to render on screen
            return convertView;
        }
    }




