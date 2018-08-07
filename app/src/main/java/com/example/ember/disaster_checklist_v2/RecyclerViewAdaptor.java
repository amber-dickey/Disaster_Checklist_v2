package com.example.ember.disaster_checklist_v2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerViewAdaptor.ViewHolder>{
    private static final String TAG = "RecyclerViewAdaptor";

    private String[] mItemNames;
    private ArrayList<Integer> mItemValues = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdaptor(Context mContext, String[] mItemNames, ArrayList<Integer> mItemValues) {
        this.mItemNames = mItemNames;
        this.mItemValues = mItemValues;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.itemName.setText(mItemNames[position]);
        holder.itemValues.setText((mItemValues.get(position).toString()));

    }

    @Override
    public int getItemCount() {
        return mItemNames.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        TextView itemValues;
        RelativeLayout parentLayout;
        Button increaseButton;
        Button decreaseButton;
        public ViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_Name);
            itemValues = itemView.findViewById(R.id.item_Value);
            increaseButton = itemView.findViewById(R.id.button_Increase);
            decreaseButton = itemView.findViewById(R.id.button_Decrease);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
