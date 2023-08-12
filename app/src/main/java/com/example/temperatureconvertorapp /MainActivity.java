package com.example.temperatureconvertorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button ansBtn,againBtn;
    TextView showAns;
    EditText getVal;
    RadioButton c2f,f2c;
    Double x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ansBtn = (Button) findViewById(R.id.ansBtn);
        showAns =(TextView) findViewById(R.id.showAns);
        getVal = (EditText)findViewById(R.id.getVal);
        c2f = (RadioButton) findViewById(R.id.c2f);
        f2c =(RadioButton) findViewById(R.id.f2c);
        againBtn = (Button) findViewById(R.id.againBtn);
        againBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getVal.getText().toString().isEmpty()) {
                    showAns.setText("Please Give Temperature");
                }
                else {
                    //showAns.setText("Everything OK!");
                    x = Double.parseDouble(String.valueOf(getVal.getText()));
                    if (c2f.isChecked()) {
                        //x = (x * 9) / 5 + 32;
                        x = Double.parseDouble(new DecimalFormat("##,###").format(x));
                        x = (x * 9) / 5 + 32;
                        showAns.setText(String.valueOf(x) + "Degree F");
                    }
                    else if (f2c.isChecked()) {
                        x = (x - 32) * 5 / 9;
                        x = Double.parseDouble(new DecimalFormat("##,###").format(x));
                        showAns.setText(String.valueOf(x) + "Degree C");
                    }
                    else {
                        showAns.setText(("Please Select an option!"));

                    }
                }
            }
        });
        ansBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAns.setText("0.0");
                getVal.setText("");
                c2f.setChecked(false);
                f2c.setChecked(false);
            }
        });
    }
}
