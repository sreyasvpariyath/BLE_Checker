package blechecker.sreyasvpariyath.com.ble_checker.activities.admobsfullscreen.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import blechecker.sreyasvpariyath.com.ble_checker.R;
import blechecker.sreyasvpariyath.com.ble_checker.activities.MainActivity;

public class InterstitialAd_Activity extends AppCompatActivity
{

    private String TAG = InterstitialAd_Activity.class.getSimpleName();
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial_ad);
        addInt();
    }

    public void addInt()
    {
        mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.bleutilinterstitial));

        AdRequest adRequest = new AdRequest.Builder().build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener()
        {
            public void onAdLoaded()
            {
                showInterstitial();
            }
        });
    }

    private void showInterstitial()
    {
        if (mInterstitialAd.isLoaded())
        {
            mInterstitialAd.show();
        }
    }

    @Override
    public void onBackPressed()
    {
        Log.d("CDA", "onBackPressed Called");
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}
