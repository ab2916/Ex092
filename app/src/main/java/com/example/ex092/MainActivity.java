package com.example.ex092;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The E tn 1.
     */
    EditText eTN1, /**
     * The E tn 2.
     */
    eTN2;
    /**
     * The First number.
     */
    double firstNumber;
    /**
     * The Multiplier number.
     */
    double multiplierNumber;
    /**
     * The Str.
     */
    String str;
    /**
     * The Si.
     */
    Intent si;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eTN1 = findViewById(R.id.eTN1);
        eTN2 = findViewById(R.id.eTN2);
        si = new Intent(this,SecondActivity.class);
    }

    /**
     * Check number boolean.
     *
     * @param str the str
     * @return the boolean
     */
    public boolean checkNumber(String str)
    {
        if(str.equals("") || str.equals("-") || str.equals(".") || str.equals("-.") || str.equals(".-"))
        {
            return false;
        }
        return true;
    }

    /**
     * Arithmetical.
     *
     * @param view the view
     */
    public void arithmetical(View view) {
        if(checkNumber(eTN1.getText().toString()) == false || checkNumber(eTN2.getText().toString()) == false)
        {
            Toast.makeText(this, "there is no data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            str = eTN1.getText().toString();
            firstNumber = Double.parseDouble(str);
            str = eTN2.getText().toString();
            multiplierNumber = Double.parseDouble(str);
            si.putExtra("n", firstNumber);
            si.putExtra("nn", multiplierNumber);
            si.putExtra("nnn", true);
            startActivity(si);
        }
    }

    /**
     * Geometric.
     *
     * @param view the view
     */
    public void geometric(View view) {
        if(checkNumber(eTN1.getText().toString()) == false || checkNumber(eTN2.getText().toString()) == false)
        {
            Toast.makeText(this, "there is no data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            str = eTN1.getText().toString();
            firstNumber = Double.parseDouble(str);
            str = eTN2.getText().toString();
            multiplierNumber = Double.parseDouble(str);
            si.putExtra("n",firstNumber);
            si.putExtra("nn",multiplierNumber);
            si.putExtra("nnn",false);
            startActivity(si);
        }
    }
}