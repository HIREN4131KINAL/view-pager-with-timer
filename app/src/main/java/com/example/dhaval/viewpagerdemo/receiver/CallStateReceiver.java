package com.example.dhaval.viewpagerdemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.example.dhaval.viewpagerdemo.MyPreferences;

/**
 * Created by Dhaval on 07-Apr-16.
 */
public class CallStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        MyPreferences.init(context);
            if(intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(
                    TelephonyManager.EXTRA_STATE_IDLE)
                    ){
                if(MyPreferences.preferences.contains("number")){
                    Toast.makeText(context, "You have called to : "+MyPreferences.preferences.getString("number",""), Toast.LENGTH_SHORT).show();
                    MyPreferences.editor.clear().commit();
                }
                Log.d("Call", "Call ended");
            }



    }
}
