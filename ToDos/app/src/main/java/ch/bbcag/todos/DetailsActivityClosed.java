package ch.bbcag.todos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivityClosed extends AppCompatActivity {

    TextView name;
    TextView date;
    TextView desc;

    ImageButton del;
    ImageButton edit;
    ImageButton done;

    Switch push;

    int idTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_closed);

        // Die Button usw. werden gecasted

        del = (ImageButton) findViewById(R.id.infoBtnDel);
        edit = (ImageButton) findViewById(R.id.infoBtnEdit);
        done = (ImageButton) findViewById(R.id.infoBtnDone);

        name = (TextView) findViewById(R.id.infoName);
        date = (TextView) findViewById(R.id.infoDate);
        desc = (TextView) findViewById(R.id.infoDesc);

        push = (Switch) findViewById(R.id.InfoPush);
        push.setClickable(false);


        // Wenn ein Fehler passiert wird hier ein Erroro ausgelöst
        idTodo = getIntent().getIntExtra("id", -1);
        if (idTodo == -1){

           ErrorAlert.showError(this);
        }

        // Ein einziges ToDo wird ausgeles und dann werden die Werte gesetzt
        ToDos todo = ToDosDAO.getInstance(getBaseContext()).getToDoByID(idTodo);

        final String title_for_delete_not = todo.getTitle();
        final boolean pushmessage_for_delete_not = todo.isPushmessage();

        name.setText(todo.getTitle());
        date.setText(todo.getDate());
        desc.setText(todo.getDescription());

        push.setChecked(pushmessage_for_delete_not);

        // Ein ToDo wird gelöscht
        del.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ToDosDAO.getInstance(getBaseContext()).deleteToDo(getIntent().getIntExtra("id", -1));
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);

                // Wenn die Pushmessage erwünscht war wird hier der Alarm abegeschaltet
                if (pushmessage_for_delete_not) {

                    AlarmHelper.cancelAlarm(getApplicationContext(), idTodo, title_for_delete_not);
                }
                Toast.makeText(getApplicationContext(), "Todo " + name.getText().toString() + " wurde gelöscht", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
    }
}
