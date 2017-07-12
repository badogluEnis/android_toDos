package ch.bbcag.todos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {


    TextView name;
    TextView date;
    TextView desc;

    ImageButton del;
    ImageButton edit;
    ImageButton done;

    Switch push;

    int idTodo;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        del = (ImageButton) findViewById(R.id.infoBtnDel);
        edit = (ImageButton) findViewById(R.id.infoBtnEdit);
        done = (ImageButton) findViewById(R.id.infoBtnDone);

        name = (TextView) findViewById(R.id.infoName);
        date = (TextView) findViewById(R.id.infoDate);
        desc = (TextView) findViewById(R.id.infoDesc);

        push = (Switch) findViewById(R.id.InfoPush);
        push.setClickable(false);

        idTodo = getIntent().getIntExtra("id", -1);
        if (idTodo == -1){
            
            ErrorAlert.showError(this);
        }
        ToDos todo = ToDosDAO.getInstance(getBaseContext()).getToDoByID(idTodo);

        name.setText(todo.getTitle()); //aus datenbank auslesen!!
        date.setText(todo.getDate()); //aus datenbank auslesen!!
        desc.setText(todo.getDescription()); //aus datenbank auslesen!!

        push.setChecked(todo.isPushmessage()); //aus datenbank auslesen!!

        del.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                title = name.getText().toString();
                ToDosDAO.getInstance(getBaseContext()).deleteToDo(idTodo);
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                Toast.makeText(getApplicationContext(), "Todo " + title + " wurde gelöscht", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                title = name.getText().toString();
                Intent intent = new Intent(getApplicationContext(), EditActivity.class);
                intent.putExtra("id", idTodo);
                startActivity(intent);

            }
        });

        done.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                title = name.getText().toString();
                ToDosDAO.getInstance(getBaseContext()).closeToDo(idTodo);
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                Toast.makeText(getApplicationContext(), "Todo " + title + " wurde als erledigt markiert", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }
}
