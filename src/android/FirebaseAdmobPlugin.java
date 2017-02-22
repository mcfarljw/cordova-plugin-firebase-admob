package com.jernung.plugins.firebase.admob;

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

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        mInterstitialAd = new InterstitialAd(cordova.getActivity());
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
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

    private Boolean admobCanRequestNewAd() {
        return !mInterstitialAd.isLoaded() && !mInterstitialAd.isLoading();
    }

    private void admobRequestNewInterstitial() {
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
                AdRequest adRequest = new AdRequest.Builder()
                        .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                        .addTestDevice("1FDC9A41C4D572E23F89019DAF62C95E")
                        .addTestDevice("9514505C5ED1E879B831750FFE7C14A4")
                        .build();

                if (admobCanRequestNewAd()) {
                    mInterstitialAd.loadAd(adRequest);
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
