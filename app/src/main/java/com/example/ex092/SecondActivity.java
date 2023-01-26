package com.example.ex092;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.text.DecimalFormat;

/**
 * The type Second activity.
 */
public class SecondActivity extends AppCompatActivity implements View.OnCreateContextMenuListener {
    /**
     * The L v.
     */
    ListView lV;
    /**
     * The T v 1.
     */
    TextView tV1;
    /**
     * The Gi.
     */
    Intent gi;
    /**
     * The Series.
     */
    String[] series = new String[20];
    /**
     * The Sum arr.
     */
    double[] sumArr = new double[20];
    /**
     * The Bool.
     */
    boolean bool;
    /**
     * The First.
     */
    double first;
    /**
     * The Multiplier number.
     */
    double multiplierNumber;
    /**
     * The Dg.
     */
    LinearLayout DG;
    /**
     * The Si.
     */
    Intent si;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tV1 = findViewById(R.id.tV1);
        lV = findViewById(R.id.lV);
        gi = getIntent();
        DG = (LinearLayout)findViewById(R.id.dg);
        si = new Intent(this,Credits.class);

        lV.setOnCreateContextMenuListener(this);
        lV.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        first = gi.getDoubleExtra("n", -1919);
        tV1.setText(String.valueOf(first));
        multiplierNumber = gi.getDoubleExtra("nn", -193);
        //tV2.setText(String.valueOf(multiplierNumber));
        bool = gi.getBooleanExtra("nnn", false);
        double temp = first;

        if (bool) {

            for (int i = 0; i < series.length; i++) {
                series[i] = df.format(temp);
                sumArr[i] = temp;
                temp = temp + multiplierNumber;
            }
        }
        else {
            for (int i = 0; i < series.length; i++) {
                series[i] = df.format(temp);
                sumArr[i] = temp;
                temp = temp * multiplierNumber;
            }
        }
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, series);
        lV.setAdapter(adp);
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        String st = item.getTitle().toString();
        if(st.equals("Credits"))
            startActivity(si);
        if(st.equals("Back to main"))
            doneActivity(DG);
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Done activity.
     *
     * @param view the view
     */
    public void doneActivity(View view) {
        finish();
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        menu.setHeaderTitle("Series options");
        menu.add("The member's place in the series");
        menu.add("The sum of the series between the first member and the selected member");
    }

    public boolean onContextItemSelected(MenuItem item)
    {
        String op = item.getTitle().toString();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        switch(op)
        {
            case "The member's place in the series":
                tV1.setText("The member's place in the series: " + Integer.toString(index));
                break;
            case "The sum of the series between the first member and the selected member":
                double count = 0;
                for(int k = 0; k < index + 1; k++)
                {
                    count = count + sumArr[k];
                }
                tV1.setText(Double.toString(count));
                break;
        }
        return true;
    }
}