package com.omomys.layoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSwitchLayout(View view){
        switch(view.getId()){
            case R.id.btn_img_1:
                setContentView(R.layout.linear_layout);
                break;
            case R.id.btn_img_2:
                setContentView(R.layout.linear_layout_horizontal);
                break;
            case R.id.btn_img_3:
                setContentView(R.layout.table_layout);
                break;
            case R.id.btn_img_4:
                setContentView(R.layout.frame_layout);
                break;
            case R.id.btn_img_5:
                setContentView(R.layout.grid_layout);
                break;
            case R.id.btn_img_6:
                setContentView(R.layout.activity_main);
                break;
        }

    }
}
