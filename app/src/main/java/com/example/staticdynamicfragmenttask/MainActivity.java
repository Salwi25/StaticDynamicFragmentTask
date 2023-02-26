package com.example.staticdynamicfragmenttask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private boolean isFragmentDisplayed = false;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.lihat_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFragmentDisplayed) {
                    displayFragment();
                } else {
                    switchFragment();
                }
            }
        });
    }

    public void displayFragment(){
        SimpleFragment simpleFragment = SimpleFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment1, simpleFragment).commit();
        textView = findViewById(R.id.fragment_desc);
        textView.setText(R.string.honda_pcx160_detail);
        mButton.setText("Mantap!");
        isFragmentDisplayed = true;
    }

    public void switchFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager
                .findFragmentById(R.id.fragment1);
        if (simpleFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment1, simpleFragment).commit();
        }
        textView = findViewById(R.id.fragment_desc);
        textView.setText(R.string.honda_pcx160);
        mButton.setText("LIhat Kelebihan");
        isFragmentDisplayed = false;
    }
}