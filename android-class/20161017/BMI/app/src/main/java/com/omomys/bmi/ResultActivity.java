package com.omomys.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String ok = getIntent().getExtras().getString("OK");
        Double k = getIntent().getExtras().getDouble("Cancel", 0.0);
        TextView tv = (TextView) findViewById(R.id.result);
        tv.setText(ok + String.valueOf(k));
    }

    public void goBack(View view){
        Intent intent = getIntent();
        intent.putExtra("MESSAGE", "I came back from the called Activity");
        intent.putExtra("VALUE", 23.34);
        setResult(1, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        return;
    }
}
