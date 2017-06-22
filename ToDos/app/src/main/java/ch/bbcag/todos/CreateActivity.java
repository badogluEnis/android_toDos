package ch.bbcag.todos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;

public class CreateActivity extends AppCompatActivity {

    EditText date;
    DatePickerFragment datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        date = (EditText) findViewById(R.id.date);
        datePicker = new DatePickerFragment();

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


    private void createTodo(View view){
        // 1. Validieren der Eingaben.
        // 2. Datenbankeintrag von: Name, Desc, und Datum!!
        // 3. Wieder auf die Startactivity wechseln
    }
}
