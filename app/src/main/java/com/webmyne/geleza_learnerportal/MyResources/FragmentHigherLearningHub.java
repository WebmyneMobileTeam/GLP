package com.webmyne.geleza_learnerportal.MyResources;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.webmyne.geleza_learnerportal.R;

public class FragmentHigherLearningHub extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    ImageView btn1,btn2,btn3,mainView;

    public static FragmentHigherLearningHub newInstance(String param1, String param2) {
        FragmentHigherLearningHub fragment = new FragmentHigherLearningHub();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentHigherLearningHub() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View convertView = inflater.inflate(R.layout.fragment_fragment_higher_learning_hub, container, false);
        btn1 = (ImageView)convertView.findViewById(R.id.btn1);
        btn2 = (ImageView)convertView.findViewById(R.id.btn2);
        btn3 = (ImageView)convertView.findViewById(R.id.btn3);
        mainView = (ImageView)convertView.findViewById(R.id.main);

        mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainView.setImageResource(R.drawable.a8);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setImageResource(R.drawable.a2);
                btn2.setImageResource(R.drawable.a3);
                btn3.setImageResource(R.drawable.a4);
                mainView.setImageResource(R.drawable.a6);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setImageResource(R.drawable.a22);
                btn2.setImageResource(R.drawable.a33);
                btn3.setImageResource(R.drawable.a4);
                mainView.setImageResource(R.drawable.a7);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setImageResource(R.drawable.a22);
                btn2.setImageResource(R.drawable.a3);
                btn3.setImageResource(R.drawable.a44);
                mainView.setImageResource(R.drawable.a7);
            }
        });


        return convertView;
    }


}
