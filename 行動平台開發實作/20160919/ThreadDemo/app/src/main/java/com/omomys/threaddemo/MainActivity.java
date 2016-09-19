package com.omomys.threaddemo;

import android.app.Activity;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AudioAttributes at = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build();


        final SoundPool sp = new SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(at)
                .build();

        final int snd = sp.load(this, R.raw.scifi018, 1);

        final Handler h = new Handler();

        Thread t = new Thread(new Runnable() {
           @Override
           public void run() {
               //have to wait for loading sound
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

                for(int i=0; i<10; i++) {
                    // sound id, left vol, right vol, priority, loop, rate
                    sp.play(snd, 1.0f, 1.0f, 0, 0, 1.0f);
                    final String str = "Beep no. " + i;

                    h.post(new Runnable(){
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, str.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();

    }


}
