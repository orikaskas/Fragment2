package com.example.fragment2;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class bottomfragment extends Fragment  {
    View tmp;


    MyDatabaseHelper myDatabaseHelper1;
    Cursor cursor;
    TableLayout t;
    int n2;


    public bottomfragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        tmp= inflater.inflate(R.layout.fragment_bottomfragment, container, false);

        myDatabaseHelper1 = new MyDatabaseHelper(requireActivity());
        cursor = myDatabaseHelper1.readAllData();
        t=tmp.findViewById(R.id.Tlbottom);
        int n =cursor.getCount();
        cursor.moveToFirst();
        for (int i = 0; i < n; i++) {
            String s = cursor.getString(1);
            int p = cursor.getInt(2);
            init(s,p, Integer.parseInt(cursor.getString(0)));
            cursor.moveToNext();
        }

        return tmp;
    }
    public void init(String s, int p, int i)
    {

            TableRow row = new TableRow(requireActivity());
            row.setTag(i);
            TableRow.LayoutParams rowp = new TableRow.LayoutParams(-2, -2);
            row.setLayoutParams(rowp);
            row.setBackgroundColor(Color.WHITE);
            TextView tvName = new TextView(requireActivity());
            tvName.setTag("name");
            TableRow.LayoutParams ll = new TableRow.LayoutParams(-1, -2);
            ll.setMargins(0, 1, 0, 0);
            tvName.setLayoutParams(ll);
            tvName.setTextColor(Color.BLACK);
            tvName.setTextSize(15);
            tvName.setGravity(Gravity.CENTER);
            tvName.setText(s);
            CheckBox tvPrice = new CheckBox(requireActivity());
            tvPrice.setTag("Checked");
            tvPrice.setLayoutParams(ll);
            tvPrice.setTextColor(Color.BLACK);
            tvPrice.setTextSize(15);
            tvPrice.setGravity(Gravity.CENTER);
            if (p == 1){
                tvPrice.setChecked(true);
                tvName.setTextColor(Color.BLUE);
            }
            else{
                tvPrice.setChecked(false);

                tvName.setTextColor(Color.BLACK);
            }
            tvPrice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if ((tvPrice.isChecked())){
                        myDatabaseHelper1.updateData(String.valueOf(i),1);
                        tvName.setTextColor(Color.BLUE);
                    }
                    else{
                        myDatabaseHelper1.updateData(String.valueOf(i),0);
                        tvName.setTextColor(Color.BLACK);
                    }

                }
            });
            row.addView(tvPrice);
            row.addView(tvName);
            t.addView(row);
        }
    }
