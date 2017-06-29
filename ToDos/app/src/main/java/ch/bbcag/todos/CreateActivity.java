package ch.bbcag.todos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateActivity extends AppCompatActivity {

    EditText date;
    EditText name;
    EditText desc;
    DatePickerFragment datePicker;
    ToDosDAO dbConnection;
    Switch benachrichtigung;
    int pushmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        benachrichtigung = (Switch) findViewById(R.id.push) ;
        date = (EditText) findViewById(R.id.date);
        name = (EditText) findViewById(R.id.name);
        desc = (EditText) findViewById(R.id.description);
        datePicker = new DatePickerFragment();

        date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });


    }

    //Hier Schreiben wir den Text, vom Datepicker ind das Textedit.
    public void setDate(String dateText){
        date.setText(dateText);
    }

    //Hier wird der Datepicker aufgerufen.
    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.setActivity(this);
        newFragment.show(getFragmentManager(), "Datum wählen");
    }

    //Hier wird ein ToDo erstellt.
    public void createTodo(View view){
        // 1. Validieren der Eingaben.
        // 2. Datenbankeintrag von: Name, Desc, benachrichtigen? und Datum!!
        // 3. Wieder auf die Startactivity wechseln

        Pattern p = Pattern.compile("[^\\p{L}+]");
        Matcher m = p.matcher(name.getText().toString());
        if(m.find()){

            name.setError("Bitte verwenden sie keine Zahlen.");
        }

        else{

            Pattern forDate = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$");
            Matcher mForDate = forDate.matcher(date.getText().toString());

            if(mForDate.find()){

                date.setError("Bitte verwenden sie folgendes Format: DD.MM.JJJJ");
            }
            else {

                if (benachrichtigung.isChecked()){
                    pushmessage = 1;
                }
                else {
                    pushmessage = 0;
                }

                dbConnection.getInstance(getBaseContext()).createToDo(name.getText().toString(),  desc.getText().toString(), date.getText().toString(), pushmessage);

                Intent intent = new Intent(this, StartActvity.class);
                startActivity(intent);
            }
        }
    }
}
