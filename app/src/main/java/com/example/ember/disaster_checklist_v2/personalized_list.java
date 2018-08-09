package com.example.ember.disaster_checklist_v2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class personalized_list extends AppCompatActivity{
    private static final String TAG = "Personal List";
    private SharedPreferences preference;
    private SharedPreferences.Editor editThings;
    public EditText editText;
    public String message;
    public ArrayList<String> listArray= new ArrayList<>();
    public static final String EXTRA_ITEM = "com.example.disaster_checklist_v2.personalize";
    private String someString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.personlize);
        editText = findViewById(R.id.edit_list);
        preference = PreferenceManager.getDefaultSharedPreferences(this);
        editText.setText(preference.getString("list", ""));
    }
    public void sendListItem(View view){
        Intent intent = new Intent(this, DisplayListItem.class);
//        EditText editText = findViewById(R.id.edit_list);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_ITEM, message);
//        preference = PreferenceManager.getDefaultSharedPreferences(this);
        editThings = preference.edit();
        listArray.add(String.valueOf(message));
        editThings.putString("list", message);
        editThings.putInt("index", listArray.size());
        editThings.apply();
        startActivity(intent);


    }
}
