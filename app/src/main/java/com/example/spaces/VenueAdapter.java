package com.example.spaces;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class VenueAdapter extends ArrayAdapter<Venue> {
    private Context mContext;
    private int mResource;


    public VenueAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Venue> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;


    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource,parent, false);

        ImageView imageView = convertView.findViewById(R.id.image);
        TextView vnuName = convertView.findViewById(R.id.vnuName);
        TextView vnuInfo = convertView.findViewById(R.id.vnuInfo);


        imageView.setImageResource(getItem(position).getImage());
        vnuName.setText(getItem(position).getName());
        vnuInfo.setText(getItem(position).getInfo()+ " positions available");
        return convertView;
    }
}
