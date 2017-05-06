package com.jernung.plugins.firebase.admob;

import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

public class FirebaseAdmobPlugin extends CordovaPlugin {

    private static final String PLUGIN_NAME = "FirebaseAdmobPlugin";

    private InterstitialAd mInterstitialAd;
    private JSONArray mTestDeviceIds;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        mInterstitialAd = new InterstitialAd(cordova.getActivity());
        mTestDeviceIds = new JSONArray();
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("addTestDevice".equals(action)) {
            admobAddTestDevice(args.getString(0));
            callbackContext.success(admobGetTestDevices());
            return true;
        }
        if ("getTestDevices".equals(action)) {
            callbackContext.success(admobGetTestDevices());
            return true;
        }
        if ("requestInterstitial".equals(action)) {
            admobRequestNewInterstitial();
            return true;
        }
        if ("setInterstitialAdUnitId".equals(action)) {
            String adUnitId = args.getString(0);
            admobSetInterstitialAdUnitId(adUnitId);
            return true;
        }
        if ("showInterstitial".equals(action)) {
            admobShowInterstitial();
            return true;
        }

        return false;
    }

    private void admobAddTestDevice(final String deviceId) {
        mTestDeviceIds.put(deviceId);
    }

    private Boolean admobCanRequestNewAd() {
        return !mInterstitialAd.isLoaded() && !mInterstitialAd.isLoading();
    }

    private JSONArray admobGetTestDevices() {
        return mTestDeviceIds;
    }

    private void admobRequestNewInterstitial() {
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                AdRequest.Builder adRequest = new AdRequest.Builder()
                        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR);

                try {
                    for (int i = 0; i < mTestDeviceIds.length(); i++) {
                        adRequest.addTestDevice(mTestDeviceIds.getString(i));
                    }
                } catch (JSONException error) {
                    Log.e(PLUGIN_NAME, error.getMessage());
                }

                if (admobCanRequestNewAd()) {
                    mInterstitialAd.loadAd(adRequest.build());
                }
            }
        });
    }

    private void admobSetInterstitialAdUnitId(final String adUnitId) {
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                mInterstitialAd.setAdUnitId(adUnitId);
                mInterstitialAd.setAdListener(
                        new AdListener() {
                            @Override
                            public void onAdClosed() {
                                admobRequestNewInterstitial();
                            }
                        }
                );

                admobRequestNewInterstitial();
            }
        });
    }

    private void admobShowInterstitial() {
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    admobRequestNewInterstitial();
                }
            }
        });
    }

}
