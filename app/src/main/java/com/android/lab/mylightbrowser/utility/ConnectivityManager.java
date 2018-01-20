package com.android.lab.mylightbrowser.utility;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;

import com.android.lab.mylightbrowser.app.AppController;


/**
 * Created by USER on 19/12/17.
 */

public class ConnectivityManager extends BroadcastReceiver {

    Context context;
    public static ConnectivityReceiverListener connectivityReceiverListener;

    public ConnectivityManager() {
//        this.context = context;
        super();
    }

    public boolean isConnected() {
        android.net.ConnectivityManager connMgr = (android.net.ConnectivityManager) AppController.getInstance().getApplicationContext().getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void onReceive(Context context, Intent arg1) {

        android.net.ConnectivityManager connMgr = (android.net.ConnectivityManager) context.getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        boolean isConnected = networkInfo != null
                && networkInfo.isConnectedOrConnecting();

        if (connectivityReceiverListener != null) {
            connectivityReceiverListener.onNetworkConnectionChanged(isConnected);
        }
    }

    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(boolean isConnected);
    }
}
