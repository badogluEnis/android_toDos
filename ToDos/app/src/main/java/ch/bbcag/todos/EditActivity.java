package ch.bbcag.todos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditActivity extends AppCompatActivity implements DateSettable {

    ImageButton save;
    ImageButton cancel;
    EditText date;
    EditText name;
    EditText desc;
    Switch push;
    int pushmessage;
    int pushmeggaseOld;
    int idTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);



        // Hier werden die Buttons usw. gecasted

        save = (ImageButton) findViewById(R.id.btnSave);
        cancel = (ImageButton) findViewById(R.id.btnCancel);
        date = (EditText) findViewById(R.id.editDate);
        name = (EditText) findViewById(R.id.editName);
        desc = (EditText) findViewById(R.id.editDesc);
        push = (Switch) findViewById(R.id.editBenachrichtigen);

        idTodo = getIntent().getIntExtra("id", -1);

        // Wenn ein Fehler passiert wird hier ein Erroro ausgelöst
        if (idTodo == -1) {

            ErrorAlert.showError(this);
        }

        ToDos todo;
        todo = ToDosDAO.getInstance(getBaseContext()).getToDoByID(getIntent().getIntExtra("id", -1));

        name.setText(todo.getTitle());
        date.setText(todo.getDate());
        desc.setText(todo.getDescription());

        push.setChecked(todo.isPushmessage());

        if (todo.isPushmessage()) {
            pushmeggaseOld = 1;
        } else {
            pushmeggaseOld = 0;
        }

        date.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus){

                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    PickerHelper.showDatePickerDialog(EditActivity.this);
                }
            }
        });

        //Hier wird ein Listener gesetzt, welcher Dann die Daten updated, sobald man "Specihern" Klickt.
        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Pattern forDate = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
                Matcher mForDate = forDate.matcher(date.getText().toString());


                if (name.getText().toString().length() >= 20) {

                    name.setError("Nicht mehr als 20 Zeichen verwenden");
                    return;
                }

                if (name.getText().toString().matches("")) {

                    name.setError("Der Titel darf nicht leer sein");
                    return;
                }


                if (mForDate.find()) {

                    date.setError("Bitte verwenden sie folgendes Format: DD.MM.JJJJ");
                    return;

                }

                if (desc.getText().length() >= 150) {

                    desc.setError("Nicht mehr als 150 Zeichen verwenden");
                    return;
                }

                if (desc.getText().toString().matches("")) {

                    desc.setError("Die Beschreibung darf nicht leer sein");
                    return;


                } else {

                    if (push.isChecked()) {
                        pushmessage = 1;
                    } else {
                        pushmessage = 0;
                    }

                    if (pushmeggaseOld != pushmessage) {

                        if (pushmessage == 1) { //eine Push message erstellen

                            AlarmHelper.setAlarm(getApplicationContext(), getIntent().getIntExtra("id", -1), date.getText().toString(), name.getText().toString());
                            Toast.makeText(getApplicationContext(), "Todo " + name.getText().toString() + " wurde geändert, Sie erhalten eine Benachrichtigung", Toast.LENGTH_LONG).show();

                        } else { //die Push message löschen

                            AlarmHelper.cancelAlarm(getApplicationContext(), getIntent().getIntExtra("id", -1), name.getText().toString());
                            Toast.makeText(getApplicationContext(), "Todo " + name.getText().toString() + " wurde geändert, Sie erhalten keine Benachrichtigung mehr", Toast.LENGTH_LONG).show();
                        }
                    }
                    else{

                        Toast.makeText(getApplicationContext(), "Todo " + name.getText().toString() + " wurde geändert", Toast.LENGTH_LONG).show();
                    }

                    //Update der Datensätze
                    ToDosDAO.getInstance(getBaseContext()).updateToDo(idTodo, name.getText().toString(), desc.getText().toString(), date.getText().toString(), pushmessage);
                    Intent intent = new Intent(getApplicationContext(), StartActivity.class);

                    startActivity(intent);
                }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Todo " + name.getText().toString() + " wurde nicht geändert", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
            }

        });


    }

    @Override
    public void setDate(String dateText) {

        date.setText(dateText);
    }
}
