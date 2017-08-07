package com.example.phamm.demoappbaothuc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by phamm on 8/7/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("AAA","Hẹn Giờ ");
        String kt = intent.getExtras().getString("extra") ;
        Intent intent2 = new Intent(context,PlayMusic.class);
        intent2.putExtra("extra",kt);
            context.startService(intent2);

    }
}
