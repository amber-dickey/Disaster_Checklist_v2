package com.example.ember.disaster_checklist_v2;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class itemRecyclerView extends AppCompatActivity {

    private static final String TAG = "RecyclerView";
    //vars


    private String[] mNames;
   /* private CheckBox checked = findViewById(R.id.checkBox);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initArrayList();
        initRecyclerView();
        Log.d(TAG, "onCreateRV: started.");


    }

    private void initRecyclerView() {
        Log.d(TAG, "initRV: initRV.");
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdaptor adaptor = new RecyclerViewAdaptor(this, mNames, PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initArrayList() {
        Log.d(TAG, "initArray: started.");
        mNames = getResources().getStringArray(R.array.list);
    }

}
