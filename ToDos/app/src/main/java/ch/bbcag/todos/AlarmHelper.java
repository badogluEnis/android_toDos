package ch.bbcag.todos;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by bbadoe on 10.07.2017.
 */

public class AlarmHelper  {

    //Hier wird ein "Alarm" gesetzt. Somit wird man nachher benachrichtigt, falls das ToDo abläuft.
    public static void setAlarm(Context context, int todoId, String dateString, String title){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        try {
            cal.setTime(sdf.parse(dateString));// all done
        } catch (Exception e) {

            //TODO: Add Toast message
        }
        Intent intent = new Intent(context, MyBroadcastReceiver.class);
        intent.putExtra("TITLE", title);
        intent.putExtra("id", todoId);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, todoId, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);

    }

    //Hier wird der "Alarm" entfernt, damit man nicht mehr benachrichtigt wird, ob das ToDo abläuft.
    public static void cancelAlarm(Context context, int id, String title){

        Intent intent = new Intent(context, MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, id, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);

    }

}

