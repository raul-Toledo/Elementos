package com.example.sir_c.radiospiner;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    CheckBox chbBold, chbItalic;
    RadioButton rbtnR, rbtnG, rbtnB, rbtnY;
    Spinner spnFuente;
    Button btnProbar;
    TextView txvPrueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chbBold = (CheckBox)findViewById(R.id.chbNegrita);
        chbItalic = (CheckBox)findViewById(R.id.chbCursiva);
        rbtnB = (RadioButton)findViewById(R.id.rbtnBlue);
        rbtnG = (RadioButton)findViewById(R.id.rbtnGreen);
        rbtnR = (RadioButton)findViewById(R.id.rbtnRed);
        rbtnY = (RadioButton)findViewById(R.id.rbtnYellow);
        spnFuente = (Spinner)findViewById(R.id.spnFuente);
        btnProbar = (Button)findViewById(R.id.btnPrueba);
        txvPrueba = (TextView)findViewById(R.id.txvPrueba);


        spnFuente.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                this.getResources().getStringArray(R.array.strFuente)));

        spnFuente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String strFuente="";

                strFuente = spnFuente.getSelectedItem().toString();

                switch (strFuente){
                    case "Sans":
                        txvPrueba.setTypeface(Typeface.SANS_SERIF,Typeface.NORMAL);
                        break;
                    case  "Serif":
                        txvPrueba.setTypeface(Typeface.SERIF,Typeface.NORMAL);
                        break;
                    case "Monospace":
                        txvPrueba.setTypeface(Typeface.MONOSPACE,Typeface.NORMAL);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnProbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chbBold.isChecked() && !chbItalic.isChecked()){
                    txvPrueba.setTypeface(null,Typeface.BOLD);
                }
                if (chbItalic.isChecked() && !chbBold.isChecked()){
                    txvPrueba.setTypeface(null,Typeface.ITALIC);
                }
                if (chbItalic.isChecked() && chbBold.isChecked()){
                    txvPrueba.setTypeface(null,Typeface.BOLD_ITALIC);
                }
                if (!chbItalic.isChecked() && !chbBold.isChecked()){
                    txvPrueba.setTypeface(null,Typeface.NORMAL);
                }
                if (rbtnG.isChecked()){
                    txvPrueba.setTextColor(Color.GREEN);
                }
                if (rbtnB.isChecked()){
                    txvPrueba.setTextColor(Color.BLUE);
                }
                if (rbtnR.isChecked()){
                    txvPrueba.setTextColor(Color.RED);
                }
                if (rbtnY.isChecked()){
                    txvPrueba.setTextColor(Color.YELLOW);
                }

            }
        });

    }
}
