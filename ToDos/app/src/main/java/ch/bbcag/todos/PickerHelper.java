package ch.bbcag.todos;

import android.app.Activity;

/**
 * Created by bbadoe on 12.07.2017.
 */

public class PickerHelper {

    //Hier wird der Datepicker aufgerufen.
    public static void showDatePickerDialog(Activity activity) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.setActivity(activity);
        newFragment.show(activity.getFragmentManager(), "Datum wählen");
    }
}
