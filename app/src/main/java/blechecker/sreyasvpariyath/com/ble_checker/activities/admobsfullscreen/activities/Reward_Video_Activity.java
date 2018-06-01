package blechecker.sreyasvpariyath.com.ble_checker.activities.admobsfullscreen.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import blechecker.sreyasvpariyath.com.ble_checker.R;
import blechecker.sreyasvpariyath.com.ble_checker.activities.MainActivity;

public class Reward_Video_Activity extends AppCompatActivity
{
    private RewardedVideoAd mRewardedVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward_video);
        videoAddPlay();
    }

    public void videoAddPlay()
    {
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener()
        {

            @Override
            public void onRewarded(RewardItem rewardItem)
            {
              //  Toast.makeText(Reward_Video_Activity.this, "onRewarded! currency: " + rewardItem.getType() + "  amount: " +
                    //    rewardItem.getAmount(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdLeftApplication()
            {
               // Toast.makeText(Reward_Video_Activity.this, "onRewardedVideoAdLeftApplication",
                   //     Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdClosed()
            {
             //   Toast.makeText(Reward_Video_Activity.this, "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int errorCode)
            {
               // Toast.makeText(Reward_Video_Activity.this, "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdLoaded()
            {
              //  Toast.makeText(Reward_Video_Activity.this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdOpened()
            {
               // Toast.makeText(Reward_Video_Activity.this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoStarted()
            {
               // Toast.makeText(Reward_Video_Activity.this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
            }
        });

        loadRewardedVideoAd();
    }

    private void loadRewardedVideoAd()
    {
        mRewardedVideoAd.loadAd(getString(R.string.bleutilvideo),
                new AdRequest.Builder().build());

        // showing the ad to user
        showRewardedVideo();
    }

    private void showRewardedVideo()
    {
        // make sure the ad is loaded completely before showing it
        if (mRewardedVideoAd.isLoaded())
        {
            mRewardedVideoAd.show();
        }
    }

    @Override
    public void onResume()
    {
        mRewardedVideoAd.resume(this);
        super.onResume();
    }

    @Override
    public void onPause()
    {
        mRewardedVideoAd.pause(this);
        super.onPause();
    }

    @Override
    public void onDestroy()
    {
        mRewardedVideoAd.destroy(this);
        super.onDestroy();
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
