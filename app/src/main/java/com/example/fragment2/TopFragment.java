package com.example.fragment2;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TopFragment extends Fragment {
    View tmp;
    EditText editText ;
    Button btn;
    MyDatabaseHelper myDatabaseHelper;
   public TopFragment() {
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
        tmp= inflater.inflate(R.layout.fragment_top, container, false);
        init();
        return tmp;
    }
    public void init()
    {
        myDatabaseHelper = new MyDatabaseHelper(requireActivity());
        editText = tmp.findViewById(R.id.etname);
        btn = tmp.findViewById(R.id.btnadd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().length() ==0||editText.length()>15)
                    Toast.makeText(getActivity(), "לא כתבת ", Toast.LENGTH_SHORT).show();
                else {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment2,new bottomfragment()).addToBackStack(null).commit();
                    myDatabaseHelper.addproduct(editText.getText().toString(),0);
                    editText.setText("");
                }
            }
        });
    }
}