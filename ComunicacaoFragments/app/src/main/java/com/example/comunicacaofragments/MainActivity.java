package com.example.comunicacaofragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TextFragment.OnFragmentInteractionListener {

    private ResultFragment resultFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultFragment = (ResultFragment) getSupportFragmentManager().findFragmentById(R.id.frag_result);

    }

    @Override
    public void onfragmentInteration(String text) {
        resultFragment.definirText(text);
    }
}