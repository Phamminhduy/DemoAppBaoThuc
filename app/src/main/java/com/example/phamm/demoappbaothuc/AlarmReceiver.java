package com.example.phamm.demoappbaothuc;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by phamm on 8/7/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {
    PendingIntent pendingIntent;
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("AAA","Hẹn Giờ ");
        String kt = intent.getExtras().getString("extra") ;
        Intent intent2 = new Intent(context,PlayMusic.class);
        String strings = "Thông Báo Đồng Hồ Báo Thức";
        pendingIntent = PendingIntent.getActivity(context,0,new Intent(context,MainActivity.class),0);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.icon_clock).setContentTitle("Đồng Hồ Báo Thức")
                .setContentIntent(pendingIntent).setAutoCancel(true).setContentText(strings);
        Notification notification = builder.build();
        notificationManager.notify(12345,notification);
        intent2.putExtra("extra",kt);
        context.startService(intent2);

    }
}
