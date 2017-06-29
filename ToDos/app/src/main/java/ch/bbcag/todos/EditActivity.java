package ch.bbcag.todos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class EditActivity extends AppCompatActivity {

    ToDosDAO connection;
    Button save;
    Button cancel;
    EditText date;
    EditText name;
    EditText desc;
    Switch benachrichtigung;
    int pushmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        save = (Button) findViewById(R.id.btnSave);
        cancel = (Button) findViewById(R.id.btnCancel);
        date = (EditText) findViewById(R.id.editDate);
        name = (EditText) findViewById(R.id.editName);
        desc = (EditText) findViewById(R.id.editDesc);
        benachrichtigung = (Switch) findViewById(R.id.editBenachrichtigen);

        //Hier wird ein Listener gesetzt, welcher Dann die Daten updated, sobald man "Specihern" Klickt.
        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (benachrichtigung.isChecked()){
                    pushmessage = 1;
                }
                else {
                    pushmessage = 0;
                }

                //Update der Datensätze
                connection.getInstance(getBaseContext()).updateToDo(1, name.getText().toString(), desc.getText().toString(), date.getText().toString(), pushmessage, 1);

            }
        });



        connection.getToDos(1);

    }

}
