package com.example.spaces;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;

import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageButton infoBtn;
    ImageButton homeBtn;
    ImageButton profileBtn;

    ListView listView;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spaces_home);

        homeBtn = findViewById(R.id.homeBtn);
        homeBtn.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (infoBtn.getVisibility() == View.VISIBLE) {
                    infoBtn.setVisibility(View.INVISIBLE);
                } else {
                    infoBtn.setVisibility(View.VISIBLE);
                }

                if (profileBtn.getVisibility() == View.VISIBLE) {
                    profileBtn.setVisibility(View.INVISIBLE);
                } else {
                    profileBtn.setVisibility(View.VISIBLE);
                }

                return false;
            }
        });

        infoBtn = findViewById(R.id.infoBtn);
        infoBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent userGuide = new Intent(MainActivity.this, SpacesGuide.class);
                startActivity(userGuide);
            }
        });

        profileBtn = findViewById(R.id.profileBtn);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent userAccount = new Intent(MainActivity.this, SpacesAccount.class);
                startActivity(userAccount);
            }
        });


        listView = findViewById(R.id.venuesList);


        //Create database and insert data
        db = new DBHelper(this);

        String[] name = {"Pilkington Library", "Haslegrave Building"};
        String[] description = {"The Library is the largest open access study space on campus.", "Computer Labs is open to all staff and students at the University and home to a many computers."};
        int[] freeSpaces = {22, 7};

        for (int i=0; i <name.length; i++) {
            if (db.insertData(name[i], description[i], freeSpaces[i])) {
                //Toast.makeText(MainActivity.this, "Welcome to Spaces!", Toast.LENGTH_SHORT).show();
            } else {
                //Toast.makeText(MainActivity.this, "Data not added", Toast.LENGTH_SHORT).show();
            }
        }


        try {
            viewData();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }


        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                String pos = String.valueOf(position);
                Intent bookVenue = new Intent(getBaseContext(), SpacesBooking.class);
                bookVenue.putExtra("chosenVenue", pos);
                startActivity(bookVenue);
            }
        });

    }

    public void viewData() {
        Cursor cursor = db.viewData();
        ArrayList<Venue> arrayList = new ArrayList<>();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data to show", Toast.LENGTH_SHORT).show();
        } else {
            for (int i = 1; i < 3; i++) {
                cursor.moveToNext();
                int id = getResources().getIdentifier("item" + i, "drawable", getPackageName());

                Venue toAdd = new Venue(id, cursor.getString(1), cursor.getString(3), cursor.getString(2), cursor.getInt(3), cursor.getInt(0));
                arrayList.add(toAdd);
            }

            try {
                VenueAdapter venueAdapter = new VenueAdapter(this, R.layout.venue_listrow,arrayList);
                listView.setAdapter(venueAdapter);
            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }

    }
}