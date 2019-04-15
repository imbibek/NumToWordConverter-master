package com.example.numtowordconverter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    private EditText etNumber;
    private TextView tvOutput;
    private Button btnConvert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConvert = findViewById(R.id.btnCOnvert);
        etNumber= findViewById(R.id.etNumber);
        tvOutput = findViewById(R.id.tvOutput);
        btnConvert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCOnvert) {
            if (validation()) {
                String numberz =etNumber.getText().toString();
                final long number = Long.parseLong(numberz);
                String returnz = Converter.convert(number);
                tvOutput.setText(returnz);

            }
        }
    }

    public boolean validation(){
        boolean flag = true;
        if (TextUtils.isEmpty(etNumber.getText().toString())){
            etNumber.setError("Please enter Height");
            etNumber.requestFocus();
            flag = false;
        }

        return flag;
    }

}


