package com.ted.memoryleak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.Main;

import junit.framework.Test;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        test();
    }

    private void test() {
        Main.changeStringTest();
    }
}
