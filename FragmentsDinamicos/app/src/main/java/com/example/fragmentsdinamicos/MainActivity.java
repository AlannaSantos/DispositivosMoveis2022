package com.example.fragmentsdinamicos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        LeftFragment leftFragment = new LeftFragment();
        RightFragment rightFragment = new RightFragment();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment1, leftFragment, "Left");
        fragmentTransaction.add(R.id.fragment2, rightFragment, "Right");
        fragmentTransaction.commit();
    }
}