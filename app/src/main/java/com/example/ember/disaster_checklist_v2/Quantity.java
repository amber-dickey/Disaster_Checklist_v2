package com.example.ember.disaster_checklist_v2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Quantity extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor edit;
    //water
    TextView showValueWater;
    int waterCounter = 0;
    ArrayList<Integer> waterValue = new ArrayList<>();
    //food
    TextView showValueFood;
    int foodCounter = 0;
    ArrayList<Integer> foodValue = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantity);
        //shows the waterValue
        showValueWater = findViewById(R.id.waterValue);
        waterValue.add(Integer.valueOf(Integer.toString(waterCounter)));
        //saves the waterValues
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        edit = pref.edit();
        showValueWater.setText(Integer.toString(pref.getInt("water", waterCounter)));

        //shows the foodValue
        showValueFood = findViewById(R.id.foodValue);
        foodValue.add(Integer.valueOf(Integer.toString(foodCounter)));
        //saves the waterValues
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        edit = pref.edit();
        showValueFood.setText(Integer.toString(pref.getInt("food", foodCounter)));
    }
    public void increaseWater(View view){
        //on each click the button will increase
        waterCounter++;
        showValueWater.setText(Integer.toString(waterCounter));
        edit.putInt("water", waterCounter);
    }  public void decreaseWater(View view){
        //on each click the button will increase
        waterCounter--;
        showValueWater.setText(Integer.toString(waterCounter));
        edit.putInt("water", waterCounter);
    }
    public void increaseFood(View view){
        //on each click the button will increase
        foodCounter++;
        showValueFood.setText(Integer.toString(foodCounter));
        edit.putInt("food", foodCounter);
    }  public void decreaseFood(View view){
        //on each click the button will decrease
        foodCounter--;
        showValueFood.setText(Integer.toString(foodCounter));
        edit.putInt("food", foodCounter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        edit.apply();
    }
}
