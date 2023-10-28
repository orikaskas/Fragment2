package com.example.fragment2;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class bottomfragment extends Fragment implements View.OnClickListener {
    View tmp;
    TableLayout tableLayout;

    List<CheckBox> c1=new LinkedList<>();
    List<TextView> name2 = new LinkedList<>();


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
        init();
        return tmp;
    }
    public void init()
    {
         tableLayout = tmp.findViewById(R.id.Tlbottom);


         getParentFragmentManager().setFragmentResultListener("datafrom1", this, new FragmentResultListener() {
             @Override
             public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                 TableRow t1 = new TableRow(getActivity());
                 TableLayout.LayoutParams params = new TableLayout.LayoutParams(-1,50);
                 params.setMargins(60,0,60,0);
                 t1.setLayoutParams(params);
                 TextView textView = new TextView(getActivity());
                 CheckBox c = new CheckBox(getActivity());
                 c1.add(c);
                 name2.add(textView);
                 textView.setTextColor(Color.BLACK);
                 c.setOnClickListener(bottomfragment.this::onClick);
                 TableRow.LayoutParams params1= new TableRow.LayoutParams(100,50);
                 params1.setMargins(98,0,0,0);
                 textView.setLayoutParams(params1);
                 textView.setText(result.getString("name"));
                 t1.addView(c);
                 t1.addView(textView);
                 t1.setBackground(getResources().getDrawable(R.drawable.tablec));
                 tableLayout.addView(t1);
             }
         });
    }
    @Override
    public void onClick(View v) {
        for (int j = 0; j < c1.size(); j++)
        {
            if (c1.get(j)==v) {
                if (c1.get(j).isChecked())
                {
                    name2.get(j).setTextColor(Color.BLUE);
                }
                else
                    name2.get(j).setTextColor(Color.BLACK);
            }
        }

    }
}