package ch.bbcag.todos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by bbadoe on 11.07.2017.
 */

public class ErrorAlert {

    public static void showError(Context context){

        //error anzeigen!!
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setCancelable(false);
        alertDialog.setTitle("Lade-Fehler");
        alertDialog.setMessage("Ups, es ein Fehler im System aufgetreten, bitte starten Sie die App neu");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
