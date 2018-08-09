package com.example.ember.disaster_checklist_v2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.viewHolder>{
    private static final String TAG = "RecyclerViewAdaptor";
    private String[] mItemNames;
    private Context mContext;
    private ArrayList<Boolean> booleans = new ArrayList<>();
    private SharedPreferences mPreference;
    private SharedPreferences.Editor mEditor;
    private Boolean someBool;

    RecyclerViewAdaptor(Context mContext, String[] mItemNames, SharedPreferences mPreference) {
        this.mItemNames = mItemNames;
        this.mContext = mContext;
        for (int i = 0; i < mItemNames.length; i++) {
            someBool = mPreference.getBoolean(String.valueOf(i), false);
            booleans.add(someBool);
        }
        this.mPreference = mPreference;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        return new viewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.itemName.setText(mItemNames[position]);
        holder.bind(position);



    }

    @Override
    public int getItemCount() {
        return mItemNames.length;
    }

    class viewHolder extends RecyclerView.ViewHolder {

        TextView itemName;

        RelativeLayout parentLayout;
        public CheckBox checkbox;
        viewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_Name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            checkbox= itemView.findViewById(R.id.checkBox);
            this.setIsRecyclable(false);
        }


        void bind(int position) {
            if (booleans.get(position)) {
                checkbox.setChecked(true);
            }

            checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int adapterPosition = getAdapterPosition();

                    //creates the saved list
                    mPreference = PreferenceManager.getDefaultSharedPreferences(v.getContext());
                    mEditor = mPreference.edit();
                    mEditor.putBoolean(Integer.toString(adapterPosition),checkbox.isChecked());
                    mEditor.apply();
                    booleans.set(adapterPosition,checkbox.isChecked());
                    mEditor.apply();
                   checkedSharedPreference();
                    }
                });
                }
            public void checkedSharedPreference() {
                Log.d(TAG, "checkedSHared : checking for checks");
                //checked for shared preferences and sets them
                if (checkbox.isChecked()) {
                    mEditor.putBoolean(String.valueOf(booleans), true);
                    mEditor.apply();
                    }
                else{
                    mEditor.putBoolean(String.valueOf(booleans), false);
                    mEditor.apply();
                }
            }
        }
    }