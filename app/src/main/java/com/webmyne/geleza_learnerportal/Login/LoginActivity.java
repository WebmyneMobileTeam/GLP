package com.webmyne.geleza_learnerportal.Login;

import android.app.Activity;
import android.app.ActionBar;


import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.WindowManager;
import android.widget.Button;

import com.webmyne.geleza_learnerportal.Application.BaseActivity;
import com.webmyne.geleza_learnerportal.Application.MainTabActivity;
import com.webmyne.geleza_learnerportal.R;


public class LoginActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //todo remove this code so that login option is visible.

        // only for testing
        /* Intent i = new Intent(this, MainTabActivity.class);
        startActivity(i);
        finish();*/

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container,new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener{

        private Button btnLogin;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_login, container, false);
            btnLogin = (Button)rootView.findViewById(R.id.btnLogin);
            btnLogin.setOnClickListener(this);

            return rootView;
        }

        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.btnLogin:

                    Intent i = new Intent(getActivity(), MainTabActivity.class);
                    startActivity(i);
                    getActivity().finish();

                    break;

            }

        }
    }
}
