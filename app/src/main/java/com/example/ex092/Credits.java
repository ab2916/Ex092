package com.example.ex092;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * The type Credits.
 */
public class Credits extends AppCompatActivity {

    /**
     * The Si.
     */
    Intent si;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        si = new Intent(this,MainActivity.class);
    }

    /**
     * Go.
     *
     * @param view the view
     */
    public void go(View view) {
        startActivity(si);
    }
}