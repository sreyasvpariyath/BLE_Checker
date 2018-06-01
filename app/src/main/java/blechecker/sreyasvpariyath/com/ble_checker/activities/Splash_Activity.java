package blechecker.sreyasvpariyath.com.ble_checker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import blechecker.sreyasvpariyath.com.ble_checker.R;


public class Splash_Activity  extends AppCompatActivity
{
   // Animation animFadeIn, animZoomIn;
   // TextView txtHead, txtSubHead, txtPowered;
    private long ms = 0;
    private long splashTime = 2000;
    private boolean splashActive = true;
    private boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread mythread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    while (splashActive && ms < splashTime)
                    {
                        if (!paused)
                        {
                            ms = ms + 100;
                        }
                        sleep(100);
                    }
                }
                catch (Exception e)
                {
                }
                finally
                {
                    {
                        Intent intent = new Intent(Splash_Activity.this, MainActivity.class);
                        intent.putExtra("flag", 10);
                        startActivity(intent);
                        finish();
                    }

                }
            }
        };
        mythread.start();
    }

    @Override
    protected void onStart()
    {
        super.onStart();

    }
}
