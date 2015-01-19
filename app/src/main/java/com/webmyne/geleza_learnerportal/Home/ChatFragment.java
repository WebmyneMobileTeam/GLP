package com.webmyne.geleza_learnerportal.Home;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andexert.expandablelayout.library.ExpandableLayout;
import com.webmyne.geleza_learnerportal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private ExpandableLayout expand_mosttalkedabout;
    private ExpandableLayout expand_friends_online;
    private ExpandableLayout expand_educators_online;
    private ExpandableLayout expand_group;
    private ExpandableLayout expand_chats;

    TextView txtChats;
    TextView txtMostTalkedAbout;
    TextView txtGroup;
    TextView txtFriendsOnline;
    TextView txtEducatorsOnline;

    ImageView img_t1,img_t2,img_t3,img_t4;
    int flag1,flag2,flag3,flag4;

    TextView txtChatsBadge;
    TextView txtMostTalkedAboutBadge;
    TextView txtGroupBadge;
    TextView txtFriendsOnlineBadge;
    TextView txtEducatorsOnlineBadge;




    public static ChatFragment newInstance(String param1, String param2) {
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ChatFragment() {
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

        View vv = inflater.inflate(R.layout.fragment_chat, container, false);
        img_t1 = (ImageView)vv.findViewById(R.id.img_t1);
        img_t2 = (ImageView)vv.findViewById(R.id.img_t2);
        img_t3 = (ImageView)vv.findViewById(R.id.img_t3);
        img_t4 = (ImageView)vv.findViewById(R.id.img_t4);

        expand_chats = (ExpandableLayout)vv.findViewById(R.id.expand_chats);
        expand_educators_online = (ExpandableLayout)vv.findViewById(R.id.expand_educators_online);
        expand_friends_online = (ExpandableLayout)vv.findViewById(R.id.expand_friends_online);
        expand_group = (ExpandableLayout)vv.findViewById(R.id.expand_group);
        expand_mosttalkedabout = (ExpandableLayout)vv.findViewById(R.id.expand_mostTalkedAbout);
        expand_chats.show();





        return vv;
    }

    @Override
    public void onResume() {
        super.onResume();
        initHeaders();
    }

    private void initHeaders() {


         txtChats = (TextView)expand_chats.getHeaderRelativeLayout().findViewById(R.id.header_text);
         txtMostTalkedAbout = (TextView)expand_mosttalkedabout.getHeaderRelativeLayout().findViewById(R.id.header_text);
         txtGroup = (TextView)expand_group.getHeaderRelativeLayout().findViewById(R.id.header_text);
         txtFriendsOnline = (TextView)expand_friends_online.getHeaderRelativeLayout().findViewById(R.id.header_text);
         txtEducatorsOnline = (TextView)expand_educators_online.getHeaderRelativeLayout().findViewById(R.id.header_text);

         txtChatsBadge = (TextView)expand_chats.getHeaderRelativeLayout().findViewById(R.id.header_text_right);
         txtMostTalkedAboutBadge = (TextView)expand_mosttalkedabout.getHeaderRelativeLayout().findViewById(R.id.header_text_right);
         txtGroupBadge = (TextView)expand_group.getHeaderRelativeLayout().findViewById(R.id.header_text_right);
         txtFriendsOnlineBadge = (TextView)expand_friends_online.getHeaderRelativeLayout().findViewById(R.id.header_text_right);
         txtEducatorsOnlineBadge = (TextView)expand_educators_online.getHeaderRelativeLayout().findViewById(R.id.header_text_right);

         txtChats.setText("Chats");
         txtEducatorsOnline.setText("Educators (Online)");
         txtFriendsOnline.setText("Friends (Online)");
         txtGroup.setText("Group Discussions");
         txtMostTalkedAbout.setText("Most Talked About");


        Drawable image = getResources().getDrawable( R.drawable.ic_communicate_with_learners );
        image.setBounds( 10,00,90,90 );
        txtMostTalkedAboutBadge.setCompoundDrawables( null, null, image, null );
        txtMostTalkedAboutBadge.setText("");

        txtFriendsOnlineBadge.setText("3");
        txtEducatorsOnlineBadge.setText("2");
        txtGroupBadge.setText("4");
        txtChatsBadge.setText("6");

        flag1=0;
        flag2=0;
        flag3=0;
        flag4=0;

        txtMostTalkedAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag1==0) {
                    img_t1.setVisibility(View.VISIBLE);
                    flag1=1;
                }
                else{
                    img_t1.setVisibility(View.GONE);
                    flag1=0;
                }
            }
        });

        txtFriendsOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag2==0) {
                    img_t2.setVisibility(View.VISIBLE);
                    flag2=1;
                }
                else{
                    img_t2.setVisibility(View.GONE);
                    flag2=0;
                }
            }
        });


        txtEducatorsOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag3==0) {
                    img_t3.setVisibility(View.VISIBLE);
                    flag3=1;
                }
                else{
                    img_t3.setVisibility(View.GONE);
                    flag3=0;
                }
            }
        });

        txtGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag4==0) {
                    img_t4.setVisibility(View.VISIBLE);
                    flag4=1;
                }
                else{
                    img_t4.setVisibility(View.GONE);
                    flag4=0;
                }
            }
        });



    }
}
