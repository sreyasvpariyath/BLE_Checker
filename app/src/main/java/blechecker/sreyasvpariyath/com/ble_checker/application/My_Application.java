package blechecker.sreyasvpariyath.com.ble_checker.application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.google.android.gms.ads.MobileAds;

import blechecker.sreyasvpariyath.com.ble_checker.R;

/**
 * Created by sreyasvpariyath on 31/05/18.
 */

public class My_Application extends Application
{

    @Override
    public void onCreate()
    {
        super.onCreate();

        // initialize the AdMob app
        MobileAds.initialize(this, getString(R.string.admob_app_id));
    }

    @Override
    protected void attachBaseContext(Context base)
    {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
