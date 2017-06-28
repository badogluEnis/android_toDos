package ch.bbcag.todos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

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
        dbConnection = new ToDosDAO(getApplicationContext());

        date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });


    }

    public void setDate(String dateText){
        date.setText(dateText);
    }

    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.setActivity(this);
        newFragment.show(getFragmentManager(), "Datum wählen");
    }


    public void createTodo(View view){
        // 1. Validieren der Eingaben.
        // 2. Datenbankeintrag von: Name, Desc, benachrichtigen? und Datum!!
        // 3. Wieder auf die Startactivity wechseln

        if (benachrichtigung.isChecked()){
            pushmessage = 1;
        }
        else {
            pushmessage = 0;
        }

        dbConnection.createToDo(name.getText().toString(), desc.getText().toString(), date.getText().toString(), pushmessage , 0);

    }
}
