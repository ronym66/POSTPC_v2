package com.example.rony.v2;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment frag = new MainFragment();
        FragmentTransaction trans = getFragmentManager().beginTransaction();
        trans.replace(R.id.container, frag, "MainFragment");
        trans.commit();

    }
}