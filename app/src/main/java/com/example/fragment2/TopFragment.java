package com.example.fragment2;

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
        editText = tmp.findViewById(R.id.etname);
        btn = tmp.findViewById(R.id.btnadd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().length() ==0)
                    Toast.makeText(getActivity(), "לא כתבת ", Toast.LENGTH_SHORT).show();
                else {
                    Bundle result = new Bundle();
                    result.putString("name",editText.getText().toString());
                    getParentFragmentManager().setFragmentResult("datafrom1",result);
                    editText.setText("");
                }
            }
        });
    }
}