package ch.bbcag.todos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {


    TextView name;
    TextView date;
    TextView desc;

    ImageButton del;
    ImageButton edit;
    ImageButton done;

    Switch push;

    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ToDos todo = new ToDos();

        del = (ImageButton) findViewById(R.id.infoBtnDel);
        edit = (ImageButton) findViewById(R.id.infoBtnEdit);
        done = (ImageButton) findViewById(R.id.infoBtnDone);

        name = (TextView) findViewById(R.id.infoName);
        date = (TextView) findViewById(R.id.infoDate);
        desc = (TextView) findViewById(R.id.infoDesc);

        push = (Switch) findViewById(R.id.InfoPush);
        push.setClickable(false);

        todo = ToDosDAO.getInstance(getBaseContext()).getToDoByID(Integer.parseInt(getIntent().getStringExtra("id")));
        name.setText(todo.getTitle()); //aus datenbank auslesen!!
        date.setText(todo.getDate()); //aus datenbank auslesen!!
        desc.setText(todo.getDescription()); //aus datenbank auslesen!!

        push.setChecked(todo.isPushmessage()); //aus datenbank auslesen!!

        del.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ToDosDAO.getInstance(getBaseContext()).deleteToDo(id);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EditActivity.class);
                intent.putExtra("id", getIntent().getStringExtra("id"));
                startActivity(intent);

            }
        });

        done.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ToDosDAO.getInstance(getBaseContext()).closeToDo(id);
            }
        });
    }
}
