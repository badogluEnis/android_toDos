package ch.bbcag.todos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;

public class EditActivity extends AppCompatActivity {

    ImageButton save;
    ImageButton cancel;
    EditText date;
    EditText name;
    EditText desc;
    Switch push;
    int pushmessage;
    int id_vom_TODO; //nur ein reminder!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        id_vom_TODO = 1;
        save = (ImageButton) findViewById(R.id.btnSave);
        cancel = (ImageButton) findViewById(R.id.btnCancel);
        date = (EditText) findViewById(R.id.editDate);
        name = (EditText) findViewById(R.id.editName);
        desc = (EditText) findViewById(R.id.editDesc);
        push = (Switch) findViewById(R.id.editBenachrichtigen);


        ToDos todo = new ToDos();

        todo = ToDosDAO.getInstance(getBaseContext()).getToDoByID(Integer.parseInt(getIntent().getStringExtra("id")));
        name.setText(todo.getTitle());
        date.setText(todo.getDate());
        desc.setText(todo.getDescription());

        push.setChecked(todo.isPushmessage());

        //Hier wird ein Listener gesetzt, welcher Dann die Daten updated, sobald man "Specihern" Klickt.
        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (push.isChecked()) {
                    pushmessage = 1;
                } else {
                    pushmessage = 0;
                }

                //Update der Datensätze
                ToDosDAO.getInstance(getBaseContext()).updateToDo(id_vom_TODO, name.getText().toString(), desc.getText().toString(), date.getText().toString(), pushmessage);

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
            }

        });










    }

}
