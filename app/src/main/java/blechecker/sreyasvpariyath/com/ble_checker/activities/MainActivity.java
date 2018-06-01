package blechecker.sreyasvpariyath.com.ble_checker.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import blechecker.sreyasvpariyath.com.ble_checker.R;
import blechecker.sreyasvpariyath.com.ble_checker.activities.admobsfullscreen.activities.InterstitialAd_Activity;
import blechecker.sreyasvpariyath.com.ble_checker.activities.admobsfullscreen.activities.Reward_Video_Activity;

public class MainActivity extends AppCompatActivity
{
    ImageButton imgResult;
    Button btnScan;
    Button btnList;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgResult = (ImageButton) findViewById(R.id.imgResult);
        btnScan = (Button) findViewById(R.id.btnScan);
        btnList = (Button) findViewById(R.id.btnSupport);
        checkBLE();
        clickListners();
        addMob();
    }

    public void addMob()
    {
        View adContainer = findViewById(R.id.addContainer);

        mAdView = new AdView(MainActivity.this);
        mAdView.setAdSize(AdSize.SMART_BANNER);
        mAdView.setAdUnitId(getString(R.string.bleutilbanner));
        ((RelativeLayout) adContainer).addView(mAdView);
        AdRequest adRequest = new AdRequest.Builder()./*.addTestDevice("YHKBDAIZY95P8S69").*/build();

        mAdView.setAdListener(new AdListener()
        {
            @Override
            public void onAdLoaded()
            {
            }

            @Override
            public void onAdClosed()
            {
                Toast.makeText(getApplicationContext(), "Ad is closed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode)
            {
                //  Toast.makeText(getApplicationContext(), "Ad failed to load! error code: " + errorCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLeftApplication()
            {
                //  Toast.makeText(getApplicationContext(), "Ad left application!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened()
            {
                super.onAdOpened();
            }
        });

        mAdView.loadAd(adRequest);
    }

    @Override
    public void onPause()
    {
        if (mAdView != null)
        {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if (mAdView != null)
        {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy()
    {
        if (mAdView != null)
        {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    public void clickListners()
    {
        btnScan.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), R.string.willbeenabled, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, InterstitialAd_Activity.class));
                finish();
            }
        });

        btnList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), R.string.willbeenabled, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Reward_Video_Activity.class));
                finish();
            }
        });
    }

    public void checkBLE()
    {
        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE))
        {
            Toast.makeText(this, R.string.ble_not_supported, Toast.LENGTH_SHORT).show();
            imgResult.setImageResource(R.drawable.wrong);
            imgResult.invalidate();
        }
        else
        {
            imgResult.setImageResource(R.drawable.correct);
        }
    }
}
