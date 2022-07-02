package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements ButtonsFragment.OnFragmentInteractionListener {

    private ColorFragment colorFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorFragment = (ColorFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentColor);
    }
    public void onfragmentInteration(int color) {
        colorFragment.definirColor(color);
    }
}