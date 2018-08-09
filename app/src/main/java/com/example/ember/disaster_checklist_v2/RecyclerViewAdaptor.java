package com.example.ember.disaster_checklist_v2;

import android.content.Context;
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


public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.ViewHolder>{
    private static final String TAG = "RecyclerViewAdaptor";
    private String[] mItemNames;
    private Context mContext;
    private ArrayList<Boolean> booleans = new ArrayList<>();


    RecyclerViewAdaptor(Context mContext, String[] mItemNames) {
        this.mItemNames = mItemNames;
        this.mContext = mContext;

        for (int i = 0; i < mItemNames.length; i++) {
            booleans.add(false);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.itemName.setText(mItemNames[position]);
        holder.bind(position);



    }

    @Override
    public int getItemCount() {
        return mItemNames.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;

        RelativeLayout parentLayout;
        CheckBox checkbox;
        ViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_Name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            checkbox= itemView.findViewById(R.id.checkBox);



//            itemView.setOnClickListener(this);
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
                    booleans.set(adapterPosition,checkbox.isChecked());
                }
            });
        }

}}
