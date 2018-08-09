package com.example.ember.disaster_checklist_v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class personalized_list extends AppCompatActivity{
    public static final String EXTRA_ITEM = "com.example.disaster_checklist_v2.personalize";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personlize);
    }
    public void sendListItem(View view){
        Intent intent = new Intent(this, DisplayListItem.class);
        EditText editText = findViewById(R.id.edit_list);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_ITEM, message);
        startActivity(intent);
    }
}
