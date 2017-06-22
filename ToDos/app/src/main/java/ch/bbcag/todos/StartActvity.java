package ch.bbcag.todos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class StartActvity extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_actvity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToDo(view);
            }
        });

        Button open = (Button) findViewById(R.id.buttonOpen);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openedToDos();
            }
        });

        Button closed = (Button) findViewById(R.id.buttonClosed);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closedToDos();
            }
        });

        ListView list = (ListView) findViewById(R.id.listview);


    }


    private void addToDo(View view) {
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }

    private void openedToDos() {

    }

    private void closedToDos() {

    }

    private void closeToDo() {

    }

    private void deleteToDo() {

    }

/*
    //Definition einer anonymen Klicklistener Klasse
    AdapterView.OnItemClickListener mListClickedHandler = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int position, long id) {
            Intent intent = new Intent(getApplicationContext(), CreateActivity.class);
            String selected = parent.getItemAtPosition(position).toString();
//Kleine Infobox anzeigen
            Toast.makeText(StartActvity.this, selected, Toast.LENGTH_SHORT).show();
//Intent mit Zusatzinformationen - hier die Badi Nummer

            startActivity(intent);
        }
    };

    @Override
    public void onClick(View v) {

    }
        list.setOnItemClickListener(mListClickedHandler);
*/
}
