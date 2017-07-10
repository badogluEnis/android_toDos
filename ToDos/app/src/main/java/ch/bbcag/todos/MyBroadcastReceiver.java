package ch.bbcag.todos;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by bbadoe on 10.07.2017.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = new Notification.Builder(context)
                .setContentTitle(intent.getStringExtra("TITLE") + "ist fällig")
                .setContentText("Ihr ToDo läuft ab!")
                .setSmallIcon(R.drawable.ic_today_black_18dp)
                .build();

        nm.notify(intent.getIntExtra("id", -1) , notification);
    }

}