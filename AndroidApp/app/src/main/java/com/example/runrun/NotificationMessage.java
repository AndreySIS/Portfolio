package com.example.runrun;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public final class NotificationMessage extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent resultIntent = new Intent(context, MainActivity.class);

        PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 0, resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Run&Run")
                        .setContentText("Посмотрите тренировку на сегодня")
                        .setContentIntent(resultPendingIntent)
                        .setAutoCancel(true);

        Notification notification = builder.build();

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

}
