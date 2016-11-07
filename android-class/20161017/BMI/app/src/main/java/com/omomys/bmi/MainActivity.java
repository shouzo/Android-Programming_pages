package com.omomys.bmi;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText weight;
    private EditText height;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findView();
    }

    private void findView() {
        weight = (EditText) findViewById(R.id.weight);
        height = (EditText) findViewById(R.id.height);
    }

    public void calculateBMI(View view){
        String w = weight.getText().toString();
        String h = height.getText().toString();
        Double dw = Double.valueOf(w);
        Double dh = Double.valueOf(h);
        Double bmi = dw / Math.pow(dh, 2);

        new AlertDialog.Builder(this)
                .setTitle("BMI")
                .setMessage(String.valueOf(bmi))
                .setPositiveButton(R.string.positive_button_title, null)
                .setNegativeButton(R.string.negative_button_title, null)
                .setNeutralButton(R.string.neutural_button_title, null)
                .show();

        Intent intent = new Intent(this, ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("OK", "The BMI is ");
        bundle.putDouble("Cancel", bmi);
        intent.putExtras(bundle);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void help(View view){
        new AlertDialog.Builder(this)
                .setTitle("Help")
                .setMessage(getString(R.string.message_in_dialog_alert))
                .setPositiveButton(getString(R.string.positive_button_title), null)
                .setNegativeButton(getString(R.string.negative_button_title), null)
                .setNeutralButton(getString(R.string.neutural_button_title), null)
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            if(requestCode == 1){
                String message = data.getStringExtra("MESSAGE");
                Double value = data.getDoubleExtra("VALUE", 0.0);
                new AlertDialog.Builder(this)
                        .setTitle(message)
                        .setMessage(String.valueOf(value))
                        .setPositiveButton(R.string.positive_button_title, null)
                        .setNegativeButton(R.string.negative_button_title, null)
                        .setNeutralButton(R.string.neutural_button_title, null)
                        .show();
            }

        }
    }

}
