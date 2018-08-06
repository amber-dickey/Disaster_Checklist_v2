package com.example.ember.disaster_checklist_v2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class menu_main extends AppCompatActivity {
    TextView waterValue;
    int waterCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        waterValue = (TextView) findViewById(R.id.waterValue);
    }
    //creates the options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    //shows the checklist menu options
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.checklist:
               setContentView(R.layout.checklist_menu);
               return true;
               //original test to see if method worked
                /*Toast.makeText(this, "Checklist", Toast.LENGTH_LONG).show();
                return true;*/
                }
        return true;
    }

    //increases the click of the water button
    public void increaseButton(View view) {
        waterCounter++;
        waterValue.setText(Integer.toString(waterCounter));
    }
    //decreases the click of the water button
    public void decreaseButton(View view) {
        waterCounter--;
        waterValue.setText(Integer.toString(waterCounter));
    }
}
