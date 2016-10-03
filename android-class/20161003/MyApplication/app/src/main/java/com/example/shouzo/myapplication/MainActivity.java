package com.example.shouzo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etWeight;
    private EditText etHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        etWeight = (EditText) findViewById(R.id.et_weight);
        etHeight = (EditText) findViewById(R.id.et_height);
    }

    public void bmi(View v){
        String w = etWeight.getText().toString();
        String h = etHeight.getText().toString();
        float wf = Float.parseFloat(w);
        float hf = Float.parseFloat(h);

        float bmi = wf / (hf * hf);
        Log.i("BMI = ", String.valueOf(bmi));
        Toast.makeText(this, String.valueOf(bmi), Toast.LENGTH_SHORT).show();
    }
}
