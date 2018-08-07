package com.example.ember.disaster_checklist_v2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class itemRecyclerView extends AppCompatActivity {

    private static final String TAG = "RecyclerView";
    //vars
    private String[] mNames;
    private ArrayList<Integer> mValues = new ArrayList<>();


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
        RecyclerViewAdaptor adaptor = new RecyclerViewAdaptor(this, mNames, mValues);
        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initArrayList(){
        Log.d(TAG, "initArray: started.");
        mNames = getResources().getStringArray(R.array.list);
        for(int i = 0; i < mNames.length; i++ ){
            Log.d("TEstTAg", mNames[i]);
            mValues.add(1);
        }
    }
}
