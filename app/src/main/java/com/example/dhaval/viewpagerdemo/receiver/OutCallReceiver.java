package com.example.dhaval.viewpagerdemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.dhaval.viewpagerdemo.MyPreferences;


public class OutCallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        MyPreferences.init(context);
        if(intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)){
            String phonenumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            MyPreferences.editor.putString("number",phonenumber).commit();
            Log.d("OutgoingCallReceiver",phonenumber);
            Log.d("OutgoingCallReceiver", intent.getExtras().toString());
        }

    }
}
