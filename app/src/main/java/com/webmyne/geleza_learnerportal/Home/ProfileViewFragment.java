package com.webmyne.geleza_learnerportal.Home;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.webmyne.geleza_learnerportal.Application.MainTabActivity;
import com.webmyne.geleza_learnerportal.R;


public class ProfileViewFragment extends Fragment implements View.OnClickListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private ImageView imgProfileViewPic;


    public static ProfileViewFragment newInstance(String param1, String param2) {
        ProfileViewFragment fragment = new ProfileViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ProfileViewFragment() {
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

        View convertView = inflater.inflate(R.layout.fragment_profile_view, container, false);
        imgProfileViewPic = (ImageView)convertView.findViewById(R.id.imgProfileViewPic);
        imgProfileViewPic.setOnClickListener(this);

        return convertView;
    }


    public void onButtonPressed(Uri uri) {

    }


    @Override
    public void onDetach() {
        super.onDetach();

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.imgProfileViewPic:
                FragmentManager manager = getActivity().getSupportFragmentManager();

                HomeFragment homeFragment = (HomeFragment)manager.findFragmentByTag(MainTabActivity.tab_names[0]);

                if(homeFragment.getFriendsVisibility() == true){
                    homeFragment.setFriendsVisibility(false);
                }else{
                    homeFragment.setFriendsVisibility(true);
                }



                break;
        }


    }
}
