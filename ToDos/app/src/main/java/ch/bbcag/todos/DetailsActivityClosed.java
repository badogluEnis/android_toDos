package ch.bbcag.todos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

public class DetailsActivityClosed extends AppCompatActivity {

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
        setContentView(R.layout.activity_details_closed);

        del = (ImageButton) findViewById(R.id.infoBtnDel);
        edit = (ImageButton) findViewById(R.id.infoBtnEdit);
        done = (ImageButton) findViewById(R.id.infoBtnDone);

        name = (TextView) findViewById(R.id.infoName);
        date = (TextView) findViewById(R.id.infoDate);
        desc = (TextView) findViewById(R.id.infoDesc);

        push = (Switch) findViewById(R.id.InfoPush);
        push.setClickable(false);

        int idTodo = getIntent().getIntExtra("id", -1);
        ToDos todo = ToDosDAO.getInstance(getBaseContext()).getToDoByID(idTodo);
        name.setText(todo.getTitle());
        date.setText(todo.getDate());
        desc.setText(todo.getDescription());

        push.setChecked(todo.isPushmessage());

        del.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ToDosDAO.getInstance(getBaseContext()).deleteToDo(id);
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
            }
        });
    }
}
