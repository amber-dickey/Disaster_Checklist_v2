package com.example.ember.disaster_checklist_v2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayListItem extends AppCompatActivity {
    String message = "";
    ArrayList<String> newList= new ArrayList<>();
    private SharedPreferences preference;
    private SharedPreferences.Editor editThings;
    public ArrayList<String> listArray= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preference = PreferenceManager.getDefaultSharedPreferences(this);

        /*editThings = preference.edit();
        listArray.add(String.valueOf(message));
        editThings.putString("list", message);
//        editThings.putInt("index", listArray.size());
        editThings.apply();
        for (int i = 0; i < preference.getInt("index", 0); i++) {
            message += preference.getString(String.valueOf(i), "");
            newList.add(message);
            editThings.apply();

        }
        */
        message = preference.getString("list", "error");

        setContentView(R.layout.activity_display_list_item);



        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);



    }
}
