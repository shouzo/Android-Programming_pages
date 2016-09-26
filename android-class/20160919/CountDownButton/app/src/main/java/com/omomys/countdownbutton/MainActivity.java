package com.omomys.countdownbutton;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Handler h; //用來指向管理 UI Thread 的 handler
    private Thread countingThread; //用來指向倒數用的 Thread
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int t = 20; //在這裡指定秒數
        b = (Button) findViewById(R.id.countdown_button);
        b.setText(String.valueOf(t));
        b.setEnabled(false);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //指定按鈕按了要做什麼
                Toast.makeText(MainActivity.this, "Bingo", Toast.LENGTH_SHORT).show();
            }
        });
        h = new CountDownHandler(b); //產生管理 UI Thread 的 Handler
        countingThread = new Thread(new CountDown(t)); //傳入 Runnable (要做的事)，並產生 Thread (做事的物件)
        countingThread.start(); //啟動 Thread (讓做事的物件開始做事，在 UI Thread 之外)
    }

    private class CountDown implements Runnable{
        private int times;
        Message msg;
        CountDown(int t){
            times = t;
        } //利用建構式中傳入倒數秒數

        @Override
        public void run(){

            for(int i=0; i<times; i++) {
                try { //暫停 1 秒
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                msg = new Message(); //產生新訊息
                msg.arg1 = times-i-1; //在訊息中加入參數
                h.sendMessage(msg); //將訊息送給 Handler
            }
        }
    }

    private class CountDownHandler extends Handler{

        private Button btn;
        CountDownHandler(Button v){
            btn = v;
        }; //利用建構式傳入要處理的對象(此例為按鈕)

        @Override
        public void handleMessage(Message msg){ //處理傳來的訊息
            btn.setText(String.valueOf(msg.arg1)); //取得參數
            if(msg.arg1==0)
                btn.setEnabled(true);
        }
    }
}

