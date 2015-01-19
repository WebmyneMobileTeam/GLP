package com.webmyne.geleza_learnerportal.WorkDue;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.webmyne.geleza_learnerportal.CustomViews.CustomTabView;
import com.webmyne.geleza_learnerportal.R;

public class WorkDueFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private LinearLayout linearSideWorkDue;
    private LinearLayout linearMainWorkDue;

    public  String[] subject_names = {"Chemistry","Economics","Languages",
            "Physics","Biology"};

    private int[] subject_icons = {R.drawable.ic_chemistry,R.drawable.ic_economics,R.drawable.ic_languages,
            R.drawable.ic_physics,R.drawable.ic_biology};

    private ImageView imgMainWorkDue;



    public static WorkDueFragment newInstance(String param1, String param2) {
        WorkDueFragment fragment = new WorkDueFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public WorkDueFragment() {
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

        View convertView = inflater.inflate(R.layout.fragment_workdue, container, false);
        linearSideWorkDue = (LinearLayout)convertView.findViewById(R.id.linearSideWorkDue);
        linearMainWorkDue = (LinearLayout)convertView.findViewById(R.id.linearMainWorkDue);
        imgMainWorkDue = (ImageView)convertView.findViewById(R.id.imgMainWorkDue);

        return convertView;
    }

    @Override
    public void onStop() {
        super.onStop();
        imgMainWorkDue.setImageBitmap(null);
    }

    @Override
    public void onResume() {
        super.onResume();

        fillupVerticalTabs();

    }

    private void fillupVerticalTabs() {

        for(int i=0;i<subject_names.length;i++){

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(300, ViewGroup.LayoutParams.MATCH_PARENT);
            params.weight = 1;
            params.gravity = Gravity.CENTER;

            CustomTabView tabView = new CustomTabView(getActivity());
            tabView.setImage(subject_icons[i]);
            tabView.setName(subject_names[i]);
            tabView.clearBadge();
            tabView.resizeImage(120, 120);

            if(i == 0){
                tabView.displayBadge(3);
            }

            tabView.setOnClickListener(mySubjectClick);
            linearSideWorkDue.addView(tabView,params);
            linearSideWorkDue.invalidate();



        }

        displayStaticBajeToLeft();
        selectSubject(0);

    }

    private void displayStaticBajeToLeft() {

       CustomTabView leftView = new CustomTabView(getActivity());
       leftView.clearBadge();
       leftView.clearColor(Color.TRANSPARENT);
       LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(300, ViewGroup.LayoutParams.WRAP_CONTENT);
       linearMainWorkDue.addView(leftView,0,params);


    }

    private View.OnClickListener mySubjectClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            CustomTabView tabV = (CustomTabView)v;
            int index = linearSideWorkDue.indexOfChild(tabV);
            selectSubject(index);

        }
    };

    private void selectSubject(int index) {

        for(int i=0;i<linearSideWorkDue.getChildCount();i++){

            CustomTabView customTabView = (CustomTabView)linearSideWorkDue.getChildAt(i);
            if(index == i){
                customTabView.setSelected();
            }else {
                customTabView.setUnSelected();
            }

        }
        //
        CustomTabView leftView = (CustomTabView)linearMainWorkDue.getChildAt(0);
        leftView.setImage(subject_icons[index]);
        leftView.setName(subject_names[index]);


    }
}
