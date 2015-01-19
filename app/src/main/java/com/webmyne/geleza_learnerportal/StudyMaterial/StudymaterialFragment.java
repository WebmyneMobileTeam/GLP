package com.webmyne.geleza_learnerportal.StudyMaterial;

import android.graphics.Color;
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

public class StudymaterialFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private LinearLayout linearSideStudyMaterial;
    private LinearLayout linearMainStudyMaterial;
    private ImageView imgMainStudy;

    public  String[] subject_names = {"Chemistry","Economics","Languages",
            "Physics","Biology"};

    private int[] subject_icons = {R.drawable.ic_chemistry,R.drawable.ic_economics,R.drawable.ic_languages,
            R.drawable.ic_physics,R.drawable.ic_biology};


    public static StudymaterialFragment newInstance(String param1, String param2) {
        StudymaterialFragment fragment = new StudymaterialFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public StudymaterialFragment() {
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

        View convertView = inflater.inflate(R.layout.fragment_studymaterial, container, false);
        linearSideStudyMaterial = (LinearLayout)convertView.findViewById(R.id.linearSideStudyMaterial);
        linearMainStudyMaterial = (LinearLayout)convertView.findViewById(R.id.linearMainStudyMaterial);
        imgMainStudy = (ImageView)convertView.findViewById(R.id.imgMainStudyMaterial);

        return convertView;
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
            tabView.resizeImage(120,120);

            if(i == 2){
                tabView.displayBadge(2);
            }

            tabView.setOnClickListener(mySubjectClick);
            linearSideStudyMaterial.addView(tabView, params);
            linearSideStudyMaterial.invalidate();

        }

        displayStaticBajeToLeft();

    }

    private void displayStaticBajeToLeft() {

        CustomTabView leftView = new CustomTabView(getActivity());
        leftView.clearBadge();
        leftView.clearColor(Color.TRANSPARENT);
        leftView.setVisibility(View.INVISIBLE);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(300, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearMainStudyMaterial.addView(leftView,0,params);

    }

    private View.OnClickListener mySubjectClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            CustomTabView tabV = (CustomTabView)v;
            int index = linearSideStudyMaterial.indexOfChild(tabV);
            selectSubject(index);
            //
            imgMainStudy.setImageResource(R.drawable.study_material);


        }
    };

    @Override
    public void onStop() {
        super.onStop();

        imgMainStudy.setImageBitmap(null);

    }

    private void selectSubject(int index) {
        for(int i=0;i< linearSideStudyMaterial.getChildCount();i++){

            CustomTabView customTabView = (CustomTabView) linearSideStudyMaterial.getChildAt(i);
            if(index == i){
                customTabView.setSelected();
            }else{
                customTabView.setUnSelected();
            }
        }

        CustomTabView leftView = (CustomTabView) linearMainStudyMaterial.getChildAt(0);

        if(leftView.getVisibility() == View.INVISIBLE){
            leftView.setVisibility(View.VISIBLE);
        }

        leftView.setImage(subject_icons[index]);
        leftView.setName(subject_names[index]);

    }
}
