package com.omomys.timerdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private boolean timesUp = false;

    private Timer t;
    private Button b;

    private final Handler h = new Handler() {
        @Override
        public void handleMessage(Message m){
            switch(m.what){
                case 1:
                    b.setEnabled(true);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.count_down_btn);
        t = new Timer();
        t.schedule(new TimerTask(){
            @Override
            public void run() {
                Message m = new Message();
                m.what = 1;
                h.sendMessage(m);
            }
        }, 10000);

    }

    public void onButtonClick(View view){
        Toast.makeText(this, "Bingo", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        t.cancel();
    }
}
