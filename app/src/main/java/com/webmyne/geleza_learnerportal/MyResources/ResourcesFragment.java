package com.webmyne.geleza_learnerportal.MyResources;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.webmyne.geleza_learnerportal.R;


public class ResourcesFragment extends Fragment implements View.OnClickListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private LinearLayout btnMyArchieves;
    private LinearLayout btnHigherLearningHub;
    private LinearLayout btnSchiolarships;
    private LinearLayout btnELibrary;
    private LinearLayout btnLearningTips;
    private LinearLayout btntheBrainCentre;
    private LinearLayout btnUseFulLinks;


    public static ResourcesFragment newInstance(String param1, String param2) {
        ResourcesFragment fragment = new ResourcesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ResourcesFragment() {
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

        View convertView = inflater.inflate(R.layout.fragment_resources, container, false);

        btnELibrary = (LinearLayout)convertView.findViewById(R.id.btnELibrary);
        btnHigherLearningHub = (LinearLayout)convertView.findViewById(R.id.btnHigherLearningHub);
        btnLearningTips = (LinearLayout)convertView.findViewById(R.id.btnLearningTips);
        btnMyArchieves = (LinearLayout)convertView.findViewById(R.id.btnMyArchieves);
        btnSchiolarships = (LinearLayout)convertView.findViewById(R.id.btnScholarships);
        btntheBrainCentre = (LinearLayout)convertView.findViewById(R.id.btnTheBrainCentre);
        btnUseFulLinks = (LinearLayout)convertView.findViewById(R.id.btnUsefulLinks);

        btnELibrary.setOnClickListener(this);
        btnHigherLearningHub.setOnClickListener(this);
        btnLearningTips.setOnClickListener(this);
        btnMyArchieves.setOnClickListener(this);
        btnSchiolarships.setOnClickListener(this);
        btntheBrainCentre.setOnClickListener(this);
        btnUseFulLinks.setOnClickListener(this);


        return convertView;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnELibrary:

                break;

            case R.id.btnHigherLearningHub:

                showHigherLearningHub();

                break;

            case R.id.btnLearningTips:

                break;

            case R.id.btnMyArchieves:

                showMyArchieves();

                break;

            case R.id.btnScholarships:

                break;

            case R.id.btnTheBrainCentre:

                break;

            case R.id.btnUsefulLinks:

                break;

        }

    }

    private void showMyArchieves() {

        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        FragmentMyArchieves frg = new FragmentMyArchieves();
        ft.replace(R.id.parentResources,frg,"hi");
        ft.addToBackStack(null);
        ft.commit();

    }

    private void showHigherLearningHub() {

        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        FragmentHigherLearningHub frg = new FragmentHigherLearningHub();
        ft.replace(R.id.parentResources,frg,"learninghub");
        ft.addToBackStack(null);
        ft.commit();

    }
}
