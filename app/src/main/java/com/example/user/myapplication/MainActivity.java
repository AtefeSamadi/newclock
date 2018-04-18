package com.example.user.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import java.util.Calendar;

public class MainActivity extends Activity {


    static  int i = 0;
    static  int j = 0;

    static  int m0;
    static  int m1;
    static  int m2;
    static int m3;
    static  int ok;
    static  int theTimeIs;

    static  int clockMin = 0;
    static  int clockHrs = 12;



    private Button sayTimeButton;
    private TextView clockValue;

    private SoundPool soundclip;


    public void loadTimeAudio(int hour, int minute) {

        int tens;

        ok = 0;
        j = 0;

        switch (hour) {
            case 1:
                m0 = soundclip.load(this, R.raw.yek, 1);
                break;
            case 2:
                m0 = soundclip.load(this, R.raw.doo, 1);
                break;
            case 3:
                m0 = soundclip.load(this, R.raw.se, 1);
                break;
            case 4:
                m0 = soundclip.load(this, R.raw.chahar, 1);
                break;
            case 5:
                m0 = soundclip.load(this, R.raw.panj, 1);
                break;
            case 6:
                m0 = soundclip.load(this, R.raw.shesh, 1);
                break;
            case 7:
                m0 = soundclip.load(this, R.raw.haft, 1);
                break;
            case 8:
                m0 = soundclip.load(this, R.raw.hasht, 1);
                break;
            case 9:
                m0 = soundclip.load(this, R.raw.noh, 1);
                break;
            case 10:
                m0 = soundclip.load(this, R.raw.dah, 1);
                break;
            case 11:
                m0 = soundclip.load(this, R.raw.yazdah, 1);
                break;
            case 12:
                m0 = soundclip.load(this, R.raw.davazdah, 1);
                break;

        }
        i = 3;
        tens = 0;

        if (minute >= 50) {
            m1 = soundclip.load(this, R.raw.panjah, 1);
            tens = 50;
        } else if (minute >= 40) {
            m1 = soundclip.load(this, R.raw.chehel, 1);
            tens = 40;
        } else if (minute >= 30) {
            m1 = soundclip.load(this, R.raw.si, 1);
            tens = 30;
        } else if (minute >= 20) {
            m1 = soundclip.load(this, R.raw.bist, 1);
            tens = 20;
        } else if (minute >= 10) {
            tens = 10;
        }



        if ((tens >= 20) || (tens == 0)) {
            i = 4;

            if (tens >= 20) {
                minute -= tens;
            }

            switch (minute) {
                case 0:
                    if (tens == 0) {
                        ok = 1;
                    }
                    i = 3;
                    break;
                case 1:
                    m2 = soundclip.load(this, R.raw.yek, 1);
                    break;
                case 2:
                    m2 = soundclip.load(this, R.raw.doo, 1);
                    break;
                case 3:
                    m2 = soundclip.load(this, R.raw.se, 1);
                    break;
                case 4:
                    m2 = soundclip.load(this, R.raw.chahar, 1);
                    break;
                case 5:
                    m2 = soundclip.load(this, R.raw.panj, 1);
                    break;
                case 6:
                    m2 = soundclip.load(this, R.raw.shesh, 1);
                    break;
                case 7:
                    m2 = soundclip.load(this, R.raw.haft, 1);
                    break;
                case 8:
                    m2 = soundclip.load(this, R.raw.hasht, 1);
                    break;
                case 9:
                    m2 = soundclip.load(this, R.raw.noh, 1);
                    break;

            }
        }

        if (tens == 10) {
            minute -= tens;

            switch (minute) {
                case 0:
                    m1 = soundclip.load(this, R.raw.dah, 1);
                    break;
                case 1:
                    m1 = soundclip.load(this, R.raw.yazdah, 1);
                    break;
                case 2:
                    m1 = soundclip.load(this, R.raw.davazdah, 1);
                    break;
                case 3:
                    m1 = soundclip.load(this, R.raw.sizdah, 1);
                    break;
                case 4:
                    m1 = soundclip.load(this, R.raw.chahardah, 1);
                    break;
                case 5:
                    m1 = soundclip.load(this, R.raw.panzdah, 1);
                    break;
                case 6:
                    m1 = soundclip.load(this, R.raw.shanzdah, 1);
                    break;
                case 7:
                    m1 = soundclip.load(this, R.raw.hefdah, 1);
                    break;
                case 8:
                    m1 = soundclip.load(this, R.raw.hejdah, 1);
                    break;
                case 9:
                    m1 = soundclip.load(this, R.raw.nouzdah, 1);
                    break;

            }
        }

    }



    public void setTimeValue(TextView tt, int hrs, int min) {

            tt.setText("" + hrs + ":" + String.format("%02d", min) );
        }


    public void wait1(int x) {
        try { Thread.sleep(250 * x); }
        catch (InterruptedException ex) {}
    }


    public void playClockTime() {
        soundclip.play(m0,1,1,0,0,1);
        if (ok == 0){
            wait1(4);
            soundclip.play(m1,1,1,0,0,1);
        }
        if (i == 4){
            wait1(2);
            soundclip.play(m2,1,1,0,0,1);
        }
        wait1(4);
        soundclip.play(m3,1,1,0,0,1);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock);

        soundclip = new SoundPool(1,AudioManager.STREAM_MUSIC,0);
        soundclip.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                j += 1;
                if (i == j) {
                    playClockTime();
                }

            }
        });


        theTimeIs = soundclip.load(this,R.raw.saat,1);

        clockValue = findViewById(R.id.clockValue);

        sayTimeButton  =findViewById(R.id.sayTimeButton);

        sayTimeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                soundclip.play(theTimeIs,1,1,0,0,1);
                wait1(4);
                loadTimeAudio(clockHrs, clockMin);
            }
        });


        sayTimeButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                soundclip.play(theTimeIs,1,1,0,0,1);
                wait1(4);
                loadTimeAudio(clockHrs, clockMin);
                return true;
            }
        });


        updateTimerThread.run();
    }


    private Runnable updateTimerThread = new Runnable() {

        public void run() {

            Calendar mytime = Calendar.getInstance();

            clockHrs = mytime.get(Calendar.HOUR);
            clockMin = mytime.get(Calendar.MINUTE);

            setTimeValue(clockValue, clockHrs, clockMin);

        }
    };

}