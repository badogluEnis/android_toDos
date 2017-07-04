package ch.bbcag.todos;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private Activity activity;

    private int year_ip;
    private int month_ip;
    private int day_ip;

    private String date_shown;

    public void setActivity(Activity activity){

        this.activity = activity;
    }

    public int getYear_ip() {

        return year_ip;
    }

    public int getMonth_ip() {

        return month_ip;
    }

    public int getDay_ip() {

        return day_ip;
    }

    public String getDate_shown() {

        return date_shown;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {

        date_shown = day + ". " + month + ". " + year;
        year_ip = year;
        month_ip = month;
        day_ip = day;
        ((CreateActivity)activity).setDate(date_shown);

    }
}