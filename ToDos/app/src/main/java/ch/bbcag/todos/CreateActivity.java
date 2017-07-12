package ch.bbcag.todos;

import android.app.Activity;
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

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateActivity extends AppCompatActivity implements DateSettable {

    EditText date;
    EditText name;
    EditText desc;
    ImageButton createButton;
    DatePickerFragment datePicker;
    ToDosDAO dbConnection;
    Switch benachrichtigung;
    int pushmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        createButton = (ImageButton) findViewById(R.id.createButton);
        benachrichtigung = (Switch) findViewById(R.id.push);
        date = (EditText) findViewById(R.id.date);
        name = (EditText) findViewById(R.id.name);
        desc = (EditText) findViewById(R.id.description);
        datePicker = new DatePickerFragment();


        // Der DatePickerDialog wird aufgerufen und man kann ein Datum setzten

        date.setOnFocusChangeListener(new View.OnFocusChangeListener() {


            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (hasFocus) {

                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    PickerHelper.showDatePickerDialog(CreateActivity.this);

                }

            }
        });


        // Das ToDo wird gemacht
        createButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                createTodo(v);
            }
        });

    }

    //Hier Schreiben wir den Text, vom Datepicker ind das Textedit.
    @Override
    public void setDate(String dateText) {

        date.setText(dateText);
    }


    //Hier wird ein ToDo erstellt.
    public void createTodo(View view) {

        // 1. Validieren der Eingaben.
        // 2. Datenbankeintrag von: Name, Desc, benachrichtigen? und Datum!!
        // 3. Wieder auf die Startactivity wechseln

        if (name.getText().toString().length() >= 20) {

            name.setError("Nicht mehr als 20 Zeichen verwenden");
            return;
        }

        if (name.getText().toString().matches("")) {

            name.setError("Der Titel darf nicht leer sein");
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

            if (benachrichtigung.isChecked()) {

                pushmessage = 1;
            } else {

                pushmessage = 0;
            }

            // Das ToDO wird erstellt
            dbConnection.getInstance(getBaseContext()).createToDo(name.getText().toString(), desc.getText().toString(), date.getText().toString(), pushmessage);

            // Wenn eine benachrichtigung erwünscht wird wird sie erstellt sonst nicht
            if (benachrichtigung.isChecked()) {

                AlarmHelper.setAlarm(getApplicationContext(), getIntent().getIntExtra("id", -1), date.getText().toString(), name.getText().toString());
                Toast.makeText(getApplicationContext(), "Todo " + name.getText().toString() + " wurde mit Benachrichtigung erstellt", Toast.LENGTH_LONG).show();
            }
            else{

                Toast.makeText(getApplicationContext(), "Todo " + name.getText().toString() + " wurde ohne Benachrichtigung erstellt", Toast.LENGTH_LONG).show();
            }

            Intent intent = new Intent(this, StartActivity.class);
            startActivity(intent);

        }
    }
}
