package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import android.support.v4.content.ContextCompat;

public class QuakeAdapter extends ArrayAdapter<Quake> {
    private String SEPARATOR = " of ";

    QuakeAdapter(Context c, ArrayList<Quake> q)
    {
        super(c,0,q);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemview = convertView;
        if(listitemview==null)
        {
            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.quake_list,parent,false);

        }
        Quake currentloc = getItem(position);

        TextView magnitude = (TextView) listitemview.findViewById(R.id.mag);
        DecimalFormat formag= new DecimalFormat("0.0");
        String outmag =formag.format(currentloc.getMagnitude());
        magnitude.setText(outmag);
        GradientDrawable gradientDrawable = (GradientDrawable)magnitude.getBackground();
        int magColor = getMagColor(currentloc.getMagnitude());
        gradientDrawable.setColor(magColor);

        String prLoc,offLoc;
        String orgLoc=currentloc.getPlace();

        if(orgLoc.contains(SEPARATOR))
        {
            String[] parts = orgLoc.split(SEPARATOR);
            offLoc=parts[0]+SEPARATOR;
            prLoc=parts[1];
        }
        else
        {
            offLoc=getContext().getString(R.string.near_the);
            prLoc=orgLoc;
        }

        TextView primLoc =(TextView) listitemview.findViewById(R.id.place);
        primLoc.setText(prLoc);

        TextView offsetLoc =(TextView) listitemview.findViewById(R.id.nearby);
        offsetLoc.setText(offLoc);



        TextView date =(TextView) listitemview.findViewById(R.id.date);
        Date dt = new Date(currentloc.getDate());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("LLL dd,yyyy");
        String det =simpleDateFormat.format(dt);
        date.setText(det);

        TextView time = (TextView) listitemview.findViewById(R.id.time);
        SimpleDateFormat tymformat = new SimpleDateFormat("h:mm a");
        String formtym = tymformat.format(dt);
        time.setText(formtym);

        //View textContainer = listitemview.findViewById(R.id.textContainer);

        return listitemview;

    }

    int getMagColor(double mag)
    {
        int colorIdMag;
        int magint = (int)Math.floor(mag);
        switch(magint)
        {
            case 0:
            case 1:  colorIdMag= R.color.magnitude1;
                    break;

            case 2:  colorIdMag= R.color.magnitude2;
break;

            case 3:  colorIdMag= R.color.magnitude3;
break;

            case 4:  colorIdMag= R.color.magnitude4;
break;

            case 5:  colorIdMag= R.color.magnitude5;
break;

            case 6:  colorIdMag= R.color.magnitude6;
break;

            case 7:  colorIdMag= R.color.magnitude7;
break;

            case 8:  colorIdMag= R.color.magnitude8;
break;

            case 9:  colorIdMag= R.color.magnitude9;
break;

           default:  colorIdMag= R.color.magnitude10plus;


        }

    return ContextCompat.getColor(getContext(),colorIdMag);
    }
}
