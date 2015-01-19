package com.webmyne.geleza_learnerportal.Application;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentTabHost;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.webmyne.geleza_learnerportal.CustomViews.CustomBadgeView;
import com.webmyne.geleza_learnerportal.CustomViews.CustomTabView;
import com.webmyne.geleza_learnerportal.Home.HomeFragment;
import com.webmyne.geleza_learnerportal.MyCalender.MyCalenderFragment;
import com.webmyne.geleza_learnerportal.MyHonours.MyHonoursFragment;
import com.webmyne.geleza_learnerportal.MyProgress.MyProgressFragment;
import com.webmyne.geleza_learnerportal.MyResources.ResourcesFragment;
import com.webmyne.geleza_learnerportal.R;
import com.webmyne.geleza_learnerportal.StudyMaterial.StudymaterialFragment;
import com.webmyne.geleza_learnerportal.WorkDue.WorkDueFragment;

import java.util.ArrayList;

public class MainTabActivity extends BaseActivity {

    private FragmentTabHost mTabHost;
    private FrameLayout actionStrip;
    private CustomBadgeView btnMyGroups;
    private CustomBadgeView btnMessages;
    private CustomBadgeView btnRequests;

    public static String[] tab_names = {"Home\n","My Progress \nRecord","Work \nDue",
                                   "Study \nMaterial","My \nCalender","My \nHonours","Resources\n"};
    private int[] tab_icons = {R.drawable.ic_home,R.drawable.ic_my_progress_record,R.drawable.ic_work_due,
                               R.drawable.ic_study_material,R.drawable.ic_my_calendar,R.drawable.ic_my_honours,
                               R.drawable.ic_resources};
    private ArrayList<Class<?>> tab_fragments;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);

        initTabHost();
        fetchResources();
        insertStripOptions();
        mTabHost.setCurrentTab(0);
        selectTAB(0);
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                for(int i=0;i<mTabHost.getTabWidget().getTabCount();i++){
                    selectTAB(i);
                }
            }
        });


        new CountDownTimer(2500, 1000) {

            @Override
            public void onFinish() {

                CustomTabView viewAnother = (CustomTabView)mTabHost.getTabWidget().getChildAt(1);
                viewAnother.displayBadge(3);
                CustomTabView viewAnother2 = (CustomTabView)mTabHost.getTabWidget().getChildAt(2);
                viewAnother2.displayBadge(4);
            }

            @Override
            public void onTick(long millisUntilFinished) {
            }
        }.start();

        new CountDownTimer(3500, 1000) {

            @Override
            public void onFinish() {

                CustomTabView viewAnother = (CustomTabView)mTabHost.getTabWidget().getChildAt(3);
                viewAnother.displayBadge(4);

                CustomTabView viewAnother2 = (CustomTabView)mTabHost.getTabWidget().getChildAt(4);
                viewAnother2.displayBadge(7);
            }

            @Override
            public void onTick(long millisUntilFinished) {
            }
        }.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
       getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    private void insertStripOptions() {

        FrameLayout.LayoutParams paramsFrame = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsFrame.gravity = Gravity.RIGHT|Gravity.CENTER_VERTICAL;
        paramsFrame.rightMargin = 32;

        LinearLayout lineatActionStrip = new LinearLayout(MainTabActivity.this);
        lineatActionStrip.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams paramsLinear = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        btnRequests = new CustomBadgeView(MainTabActivity.this);
        btnRequests.setImage(R.drawable.ic_requests);
        btnRequests.clearBadge();
        btnRequests.setName("Requests");

        btnMessages = new CustomBadgeView(MainTabActivity.this);
        btnMessages.setImage(R.drawable.ic_messages);
        btnMessages.clearBadge();
        btnMessages.setName("Messages");

        btnMyGroups = new CustomBadgeView(MainTabActivity.this);
        btnMyGroups.setImage(R.drawable.ic_social_group);
        btnMyGroups.clearBadge();
        btnMyGroups.setName("My Groups/ Societies");

       lineatActionStrip.addView(btnMyGroups,paramsLinear);

       paramsLinear.leftMargin = 22;
       lineatActionStrip.addView(btnMessages,paramsLinear);
       lineatActionStrip.addView(btnRequests,paramsLinear);
       actionStrip.addView(lineatActionStrip,paramsFrame);

        new CountDownTimer(2500, 1000) {

            @Override
            public void onFinish() {

                btnMyGroups.displayBadge(2);
                btnMessages.displayBadge(6);
                btnRequests.displayBadge(1);

            }

            @Override
            public void onTick(long millisUntilFinished) {

            }
        }.start();




    }

    private void fetchResources() {
        actionStrip = (FrameLayout)findViewById(R.id.actionStrip);
    }

    private void selectTAB(int i) {

        CustomTabView v = (CustomTabView)mTabHost.getTabWidget().getChildAt(i);
        if(i==mTabHost.getCurrentTab()){
            v.setSelected();
        }else{
            v.setUnSelected();
        }
    }


    private void initTabHost() {

        tab_fragments = new ArrayList<Class<?>>();
        tab_fragments.add(HomeFragment.class);
        tab_fragments.add(MyProgressFragment.class);
        tab_fragments.add(WorkDueFragment.class);
        tab_fragments.add(StudymaterialFragment.class);
        tab_fragments.add(MyCalenderFragment.class);
        tab_fragments.add(MyHonoursFragment.class);
        tab_fragments.add(ResourcesFragment.class);

        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        for(int i=0;i<tab_names.length;i++){

            CustomTabView view = new CustomTabView(MainTabActivity.this);
            view.setImage(tab_icons[i]);
            view.setName(tab_names[i]);
            view.clearBadge();
            if(i==2){
                view.flip();
            }

            mTabHost.addTab(mTabHost.newTabSpec(tab_names[i]).setIndicator(view),
                    tab_fragments.get(i),null);

        }

    }



}
